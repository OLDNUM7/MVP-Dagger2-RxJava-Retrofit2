package com.oldnum7.mvpdagger2rxjavaretrofit2.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oldnum7.mvpdagger2rxjavaretrofit2.R;

import org.greenrobot.eventbus.EventBus;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by admin on 2017/1/10.
 */

public class BaseActivity extends AppCompatActivity{


    private BaseActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        Config.setActivityState(this);

        EventBus.getDefault().register(this);


        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            view.setFitsSystemWindows(true);
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);

        }

        initDefaultView(layoutResID);
        initDefaultToolBar();

    }

    public static void setActivityState(Activity activity) {
        currentContext = activity;
        // 设置App只能竖屏显示
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 向自身维护的Acitivty栈（数据类型为List）中添加Activity
        UUApp.getInstance().addActivity(activity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 在BaseActivity中的Activity栈中移除Activity
        UUApp.getInstance().removeActivity(this);

        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void onResume() {
//        MobclickAgent.onResume(this);


        /**
         * 验证用户票据是否失效，失效的话则默认执行更换票据操作
         *     startActivity中不需要更新票据，否则起始页有可能会弹出登陆提示框
         */
        if (UserConfig.isNeedUpdateTicket() && (!(this instanceof StartActivity) || !this.getClass().getName().equals(StartActivity.class.getName()))) {
            if (!UserConfig.isUpdateTicketing) {
                L.d("onResume 中更新用户票据");
                UserConfig.requestUpdateTicket();
            }
        }

    }

    @Override
    protected void onPause() {
//        MobclickAgent.onPause(this);
    }


    /**
     * event 更改显示登陆状态
     */
    public void onEventMainThread(BaseEvent event) {
//        ...doSomething...
    }


    /**
     * 初始化默认的布局组件
     *
     * @param layoutResID
     */
    private void initDefaultView(int layoutResID) {
        mProgressLayout = (ProgressLayout) findViewById(R.id.progress_layout);
        mProgressLayout.setAttachActivity(this);
        mProgressLayout.setUseSlideBack(false);
        mToolbarContainer = (FrameLayout) findViewById(R.id.toolbar_container);
        mDefaultToolBar = (Toolbar) findViewById(R.id.default_toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        mRvRight = (RippleView) findViewById(R.id.rv_right);
        mRightOptButton = (TextView) findViewById(R.id.right_opt_button);
        mContentContainer = (FrameLayout) findViewById(R.id.fl_content_container);

        View childView = layoutInflater.inflate(layoutResID, null);
        mContentContainer.addView(childView, 0);
    }

    /**
     * 初始化默认的ToolBar
     */
    private void initDefaultToolBar() {
        if (mDefaultToolBar != null) {
            String label = getTitle().toString();
            setTitle(label);
            setSupportActionBar(mDefaultToolBar);
            mDefaultToolBar.setNavigationIcon(R.mipmap.toolbar_back_icn_transparent);
        }
    }

    //执行共有的UI操作，比如显示Toast，显示SnakeBar，显示Progress，显示Dialog等

    public void showToast(String text) {
        if (text != null && !text.trim().equals("")) {
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
    }

    public void showProgress(boolean canCancled, final Config.ProgressCancelListener listener) {
        Config.showProgressDialog(mContext, canCancled, listener);
    }

    public void dismissProgress() {
        Config.dismissProgress();
    }

    public void showResponseCommonMsg(HeaderCommon.ResponseCommonMsg msg) {
        if (msg.getMsg() != null && msg.getMsg().length() > 0) {
            if (msg.hasShowType()) {
                if (msg.getShowType().equals(HeaderCommon.ResponseCommonMsgShowType.TOAST)) {
                    showSnackBarMsg(msg.getMsg());
                } else if (msg.getShowType().equals(HeaderCommon.ResponseCommonMsgShowType.WINDOW)) {
                    showResponseCommonMsg(msg, null);
                }
            } else {
                showSnackBarMsg(msg.getMsg());
            }
        }
    }


}
