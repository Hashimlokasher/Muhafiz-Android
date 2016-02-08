package org.iilab.pb.test.support;


import android.widget.RelativeLayout;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowRelativeLayout;

@Implements(RelativeLayout.class)
public class CustomShadowRelativeLayout extends ShadowRelativeLayout {
    private int color;

    @Override
    public int getBackgroundColor() {
        return color;
    }

    @Implementation
    public void setBackgroundColor(int color) {
        this.color = color;
    }
}
