package site.lizihanglove.loading;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;


/**
 * @author lizihanglove
 * @email one_mighty@163.com
 * @date 2018-06-24
 * @time 17:02
 * @desc 加载动画
 */
public class Loading extends Dialog {

    private Loading(@NonNull Context context) {
        this(context, R.style.dialog);
    }

    private Loading(@NonNull Context context, int themeResId) {
        super(context, themeResId);
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
     * 对话框创建者
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
        public Builder setCancelable(boolean isCancelable) {
            this.mCancelable = isCancelable;
            return this;
        }

        /**
         * construc a Dialog For Loading
         *
         * @return Loading Dialog
         */
        public Loading build() {
            LayoutInflater inflater;
            String inflaterService = Context.LAYOUT_INFLATER_SERVICE;
            inflater = (LayoutInflater) mContext.getSystemService(inflaterService);
            Loading instance = new Loading(mContext);
            instance.setCancelable(mCancelable);
            assert inflater != null;
            View layout = inflater.inflate(R.layout.loading_layout, null);
            int matchParent = LayoutParams.MATCH_PARENT;
            int wrapContent = LayoutParams.WRAP_CONTENT;
            LayoutParams layoutParams = new LayoutParams(matchParent, wrapContent);
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
