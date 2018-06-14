package com.open_open.myapplication;

import android.content.Intent;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import com.eftimoff.androipathview.PathView;
import com.open_open.myapplication.base.BaseActivity;
import com.open_open.myapplication.bean.Bean;
import com.open_open.myapplication.ui.home.HomeActivity;
import com.open_open.myapplication.ui.home.HomeContract;
import com.open_open.myapplication.ui.home.HomeModel;
import com.open_open.myapplication.ui.home.HomePresenter;

public class MainActivity extends BaseActivity<HomePresenter,HomeModel> implements HomeContract.View {


    PathView pvDog;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        pvDog=findViewById(R.id.pv_dog);

        pvDog.getPathAnimator().delay(500).duration(2000).listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
            @Override
            public void onAnimationEnd() {
                Toast.makeText(MainActivity.this, "动画播放完毕", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                finish();
            }
        }).interpolator(new AccelerateInterpolator()).start();
    }

    @Override
    public void succ(Bean bean) {

    }

    @Override
    public void fail(String msg) {

    }
}
