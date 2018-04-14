package com.malo.smsreader.Recyclers.ContactsRecycler;

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

public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    private List<Contact> listContacts = null;


    public ContactsAdapter(List<Contact> listContacts) {
        this.listContacts = listContacts;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCountry = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view,parent,false);
        return new ContactsViewHolder(viewCountry);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, final int position) {
        holder.getTextViewContactName().setText(listContacts.get(position).getName());
        holder.getTextViewNumber().setText(listContacts.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }
}
