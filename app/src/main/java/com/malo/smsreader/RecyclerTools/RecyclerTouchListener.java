package com.malo.smsreader.RecyclerTools;

/**
 * Created by Malo on 16/03/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Classe qui herite de l'interface ClickListener, et gere le clic utilisateur pour des items a l'interieur des recyclerviews
// Donc ici pour le clic de l'utilisateur sur la corbeille dans le recyclerview de MainActivity
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener, ClickListener {

    private ClickListener mListener;
    private GestureDetector mGestureDetector;


    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener listener) {
        this.mListener = listener;

        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public void onClick(View view, int position) {

    }
}