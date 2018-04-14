package com.malo.smsreader.Recyclers.XmlFileRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malo.smsreader.Objects.File;
import com.malo.smsreader.R;

import java.util.List;

/**
 * Created by Malo on 14/03/2018.
 */

public class XmlFilesAdapter extends RecyclerView.Adapter<XmlFilesViewHolder> {

    private List<File> listFiles = null;


    public XmlFilesAdapter(List<File> listFiles) {
        this.listFiles = listFiles;
    }

    @Override
    public XmlFilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCountry = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_view,parent,false);
        return new XmlFilesViewHolder(viewCountry);
    }

    @Override
    public void onBindViewHolder(XmlFilesViewHolder holder, final int position) {
        holder.getTextViewFileName().setText(listFiles.get(position).getName());
        holder.getTextViewFileDate().setText(String.valueOf(listFiles.get(position).getDate()));
        holder.getTextViewFileMessageCount().setText(String.valueOf(listFiles.get(position).getMessageCount()));
    }

    @Override
    public int getItemCount() {
        return listFiles.size();
    }
}
