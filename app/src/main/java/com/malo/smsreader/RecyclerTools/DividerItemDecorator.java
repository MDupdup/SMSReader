package com.malo.smsreader.RecyclerTools;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Malo on 15/03/2018.
 */


// Classe qui gere les "barres" de separation entre chaque item des deux recyclerviews (dans Main et Country Activity)
public class DividerItemDecorator extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public DividerItemDecorator(Drawable divider) {
        mDivider = divider;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        final int left = parent.getPaddingLeft() + 40;
        final int right = parent.getWidth() - parent.getPaddingRight() - 40;
        final int childCount = parent.getChildCount();
        final int dividerHeight = mDivider.getIntrinsicHeight();

        for (int i = 1; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int ty = (int)(child.getTranslationY() + 0.5f);
            final int top = child.getTop() - params.topMargin + ty;
            final int bottom = top + dividerHeight;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
