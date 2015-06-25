package com.jtbmilan.habeat.selfhelp.deepbreathing;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.jtbmilan.habeat.R;

public class DeepBreathingActivity extends Activity {
    private TextView breathCounterTxt;
    private TextView breathModeTxt;
    private View breathVisualization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_breathing);
        breathCounterTxt = (TextView) findViewById(R.id.breathCntrTxt);
        breathModeTxt = (TextView) findViewById(R.id.breathModeTxt);
        breathVisualization = findViewById(R.id.breathVisualization);
        startDeepBreathing();
    }

    private void startDeepBreathing() {
        breathCounterTxt.setText("1");
        final Handler handler = new Handler();
        updateBreathVisualization(BreathMode.INHALE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("4".equals(breathCounterTxt.getText().toString())) {
                    updateBreathMode();
                }
                updateBreathCounterTxt();
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    private void updateBreathMode() {
        BreathMode currMode = BreathMode.valueOf(breathModeTxt.getText().toString());
        BreathMode nextMode = currMode.next();
        breathModeTxt.setText(nextMode.toString());
        updateBreathVisualization(nextMode);
    }

    private void updateBreathVisualization(BreathMode mode) {
        final Animation anim = AnimationUtils.loadAnimation(this, mode.getAnimationID());
        breathVisualization.startAnimation(anim);
        GradientDrawable bgShape = (GradientDrawable)breathVisualization.getBackground();
        bgShape.setColor(mode.getVisualizationColor());
    }

    private void updateBreathCounterTxt() {
        int currCnt = Integer.parseInt(breathCounterTxt.getText()
                .toString()) % 4;
        breathCounterTxt.setText((currCnt + 1) + "");
    }

    public void onClickBackBtn(View view) {
        finish();
    }
}
