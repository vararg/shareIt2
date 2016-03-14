package com.test.shareit2.utils.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by user on 13.03.2016.
 */
public class SpacesItemDecorator extends RecyclerView.ItemDecoration {
    private int mSpace;

    public SpacesItemDecorator(Context context, @DimenRes int itemOffsetId) {
        mSpace = context.getResources().getDimensionPixelSize(itemOffsetId);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mSpace, mSpace, mSpace, mSpace);
    }
}
