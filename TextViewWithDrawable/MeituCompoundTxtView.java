

/**
 * Created by liuyuantao on 17-9-9.
 */

public class MeituCompoundTxtView extends TextView {
    public MeituCompoundTxtView(Context context) {
        super(context);
    }

    public MeituCompoundTxtView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeituCompoundTxtView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //We override this function to make text and compoundDrawable fit center
    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable drawableRight = drawables[2];//TextView.Drawables.Right is 2
            if (drawableRight != null) {
                float textWidth = getPaint().measureText(getText().toString());
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth = drawableRight.getIntrinsicWidth();
                float bodyWidth = textWidth + drawableWidth + drawablePadding;
                int maxBodyWidth = 351;
                if(bodyWidth <=maxBodyWidth) {
                    int paddingRight = (int)(getWidth() - bodyWidth);
                    //Warning: here we must judge whether need to setPadding
                    //Everytime we setPadding will cause re-draw
                    if(getPaddingRight() != paddingRight) {
                        setPadding(0, 0, paddingRight, 0);
                    }
                    canvas.translate(paddingRight / 2, 0);
                } else {
                    int normalPadding = 60;
                    if(getPaddingLeft() != normalPadding) {
                        setPadding(normalPadding, 0, normalPadding, 0);
                    }
                }
            }
        }
        super.onDraw(canvas);
    }
}



/***************************  API *******************************/

    /**
     * Sets the Drawables (if any) to appear to the left of, above, to the
     * right of, and below the text. Use {@code null} if you do not want a
     * Drawable there. The Drawables must already have had
     * {@link Drawable#setBounds} called.
     * <p>
     * Calling this method will overwrite any Drawables previously set using
     * {@link #setCompoundDrawablesRelative} or related methods.
     *
     * @attr ref android.R.styleable#TextView_drawableLeft
     * @attr ref android.R.styleable#TextView_drawableTop
     * @attr ref android.R.styleable#TextView_drawableRight
     * @attr ref android.R.styleable#TextView_drawableBottom
     */
    public void setCompoundDrawables(@Nullable Drawable left, @Nullable Drawable top,
            @Nullable Drawable right, @Nullable Drawable bottom) {
    }

/***************************  API *******************************/
