package com.malo.smsreader.Recyclers.MessageRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malo.smsreader.Objects.Contact;
import com.malo.smsreader.R;

import java.util.List;

/**
 * Created by Malo on 14/03/2018.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder> {

    private List<Contact> listMessages = null;


    public MessagesAdapter(List<Contact> listContacts) {
        this.listMessages = listContacts;
    }

    @Override
    public MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCountry = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view,parent,false);
        return new MessagesViewHolder(viewCountry);
    }

    @Override
    public void onBindViewHolder(MessagesViewHolder holder, final int position) {
        holder.getTextViewContactName().setText(listMessages.get(position).getName());
        holder.getTextViewNumber().setText(listMessages.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return listMessages.size();
    }
}
