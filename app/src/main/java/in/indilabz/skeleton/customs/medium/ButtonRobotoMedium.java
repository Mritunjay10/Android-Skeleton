package in.indilabz.skeleton.customs.medium;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by praja on 17-May-17.
 */

public class ButtonRobotoMedium extends Button {

    public ButtonRobotoMedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ButtonRobotoMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonRobotoMedium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
            setTypeface(tf);
        }
    }
}
