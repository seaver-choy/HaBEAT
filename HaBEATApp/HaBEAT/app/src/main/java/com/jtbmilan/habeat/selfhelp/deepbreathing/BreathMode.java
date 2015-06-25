package com.jtbmilan.habeat.selfhelp.deepbreathing;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.jtbmilan.habeat.R;

/**
 * Created by jtbmilan on 6/12/15.
 */
public enum BreathMode {
    INHALE(R.anim.inflate, Color.GREEN),
    EXHALE(R.anim.deflate, Color.RED),
    HOLD(R.anim.hold, Color.BLACK);

    private int animationID;
    private int visualizationColor;

    BreathMode(int animationID, int visualizationColor) {
        this.animationID = animationID;
        this.visualizationColor = visualizationColor;
    }

    public int getAnimationID() {
        return animationID;
    }

    public int getVisualizationColor() {
        return visualizationColor;
    }

    public BreathMode next() {
        switch (this) {
            case INHALE: {
                return HOLD;
            }
            case HOLD: {
                return EXHALE;
            }
            case EXHALE: {
                return INHALE;
            }
            default: {
                return null;
            }
        }
    }
}
