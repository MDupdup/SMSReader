package com.malo.smsreader.Recyclers.MessageRecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.malo.smsreader.Objects.Message;
import com.malo.smsreader.R;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

/**
 * Created by Malo on 14/03/2018.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder> implements FastScrollRecyclerView.SectionedAdapter {

    private List<Message> listMessages = null;
    private Context context;


    public MessagesAdapter(List<Message> listMessages, Context context) {
        this.listMessages = listMessages;
        this.context = context;
    }

    @Override
    public MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCountry = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_view,parent,false);
        return new MessagesViewHolder(viewCountry);
    }

    @Override
    public void onBindViewHolder(MessagesViewHolder holder, final int position) {
        if(listMessages.get(position).getType() == 2) {
            holder.getTextViewMessageBody().setBackground(context.getResources().getDrawable(R.drawable.message_container_type2));
            ((RelativeLayout.LayoutParams) holder.getTextViewMessageBody().getLayoutParams()).setMarginStart((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,150,context.getResources().getDisplayMetrics()));
        } else {
            holder.getTextViewMessageBody().setBackground(context.getResources().getDrawable(R.drawable.message_container_type1));
            ((RelativeLayout.LayoutParams) holder.getTextViewMessageBody().getLayoutParams()).setMarginStart(10);
        }

        holder.getTextViewMessageBody().setText(listMessages.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return listMessages.size();
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        return listMessages.get(position).getDayMonthOfDate();
    }
}
