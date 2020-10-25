package com.quick.buku.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.quick.buku.R;


public class SplashActivity extends Activity implements View.OnClickListener {

    private TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Attaches a listener for animation/transition to the Mr. Jitters logo
        logo = (TextView) findViewById(R.id.mrjitters);
        logo.setOnClickListener(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.performClick();
            }
        }, 4000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Adds a jitter animation to the Mr. Jitters logo
        RotateAnimation jitter = new RotateAnimation(0, 2, 50, 50);
        jitter.setDuration(10);
        jitter.setRepeatCount(Animation.INFINITE);
        jitter.setRepeatMode(Animation.REVERSE);
        logo.startAnimation(jitter);
    }

    @Override
    public void onClick(View view) {

        // Defines a new alpha/scale animation
        Animation click = AnimationUtils.loadAnimation(this, R.anim.click);

        // Defines a listener to transition to the PlacePickerActivity after the animation completes
        click.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        // Attaches the alpha/scale animation to the view
        view.startAnimation(click);
    }
}
