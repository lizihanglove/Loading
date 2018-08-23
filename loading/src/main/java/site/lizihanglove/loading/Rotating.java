package site.lizihanglove.loading;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author lizihanglove
 * @date 2018/8/23
 * @email one_mighty@163.com
 * @desc
 */
public class Rotating extends Dialog {
    public Rotating(@NonNull Context context) {
        super(context);
    }

    public Rotating(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected Rotating(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    /**
     *  Rotating Dialog Builder
     */
    public static class Builder {
        private Context mContext;
        /**
         * dialog cancelable
         */
        private boolean mCancelable = true;

        /**
         * constructor of Builder Class
         *
         * @param mContext Context
         */
        public Builder(Context mContext) {
            this.mContext = mContext;
        }


        /**
         * set dialog cancelable
         *
         * @param isCancelable true for cancelable
         * @return Dialog Builder
         */
        public Rotating.Builder setCancelable(boolean isCancelable) {
            this.mCancelable = isCancelable;
            return this;
        }

        /**
         * construc a Dialog For Rotating
         *
         * @return Rotating Dialog
         */
        public Rotating build() {
            LayoutInflater inflater;
            String inflaterService = Context.LAYOUT_INFLATER_SERVICE;
            inflater = (LayoutInflater) mContext.getSystemService(inflaterService);
            Rotating instance = new Rotating(mContext);
            instance.setCancelable(mCancelable);
            assert inflater != null;
            View layout = inflater.inflate(R.layout.rotating_layout, null);
            int matchParent = ViewGroup.LayoutParams.MATCH_PARENT;
            int wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(matchParent, wrapContent);
            instance.addContentView(layout, layoutParams);
            ImageView animLeft = layout.findViewById(R.id.animLeft);
            ImageView animRight = layout.findViewById(R.id.animRight);

            //Animation of View
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator translateXLeftAnimator;
            translateXLeftAnimator = ObjectAnimator.ofFloat(animLeft, "TranslationX", -80f, 0f, 80f);
            translateXLeftAnimator.setDuration(1000);
            translateXLeftAnimator.setRepeatCount(100000);
            translateXLeftAnimator.setRepeatMode(ValueAnimator.REVERSE);

            //Animation of View
            ObjectAnimator translateXRightAnimator;
            translateXRightAnimator = ObjectAnimator.ofFloat(animRight, "TranslationX", 80f, 0f, -80f);
            translateXRightAnimator.setDuration(1000);
            translateXRightAnimator.setRepeatCount(100000);
            translateXRightAnimator.setRepeatMode(ValueAnimator.REVERSE);
            animatorSet.playTogether(translateXLeftAnimator, translateXRightAnimator);
            animatorSet.start();
            return instance;
        }
    }
}
