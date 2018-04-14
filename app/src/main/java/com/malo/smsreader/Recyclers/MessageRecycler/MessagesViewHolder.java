package com.malo.smsreader.Recyclers.MessageRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.malo.smsreader.R;

/**
 * Created by Malo on 14/03/2018.
 */

public class MessagesViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewContactName = null;
    private TextView textViewContactNumber = null;

    public MessagesViewHolder(View itemView) {
        super(itemView);

        textViewContactName = itemView.findViewById(R.id.contact_name);
        textViewContactNumber = itemView.findViewById(R.id.contact_number);

    }

    public TextView getTextViewContactName() {
        return textViewContactName;
    }

    public TextView getTextViewNumber() {
        return textViewContactNumber;
    }

}
