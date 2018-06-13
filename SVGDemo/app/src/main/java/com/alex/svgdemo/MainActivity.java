package com.alex.svgdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import com.eftimoff.androipathview.PathView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pv_dog)
    PathView pvDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        pvDog.getPathAnimator().delay(500).duration(2000).listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
            @Override
            public void onAnimationEnd() {
                Toast.makeText(MainActivity.this, "动画播放完毕", Toast.LENGTH_SHORT).show();
            }
        }).interpolator(new AccelerateInterpolator()).start();

    }
}
