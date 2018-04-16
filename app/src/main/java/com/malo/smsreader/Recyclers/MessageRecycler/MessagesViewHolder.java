package com.malo.smsreader.Recyclers.MessageRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.malo.smsreader.R;

/**
 * Created by Malo on 14/03/2018.
 */

public class MessagesViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewMessageBody = null;

    public MessagesViewHolder(View itemView) {
        super(itemView);

        textViewMessageBody = itemView.findViewById(R.id.message_body);

    }

    public TextView getTextViewMessageBody() {
        return textViewMessageBody;
    }
}
