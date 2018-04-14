package com.malo.smsreader.Recyclers.XmlFileRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.malo.smsreader.R;

/**
 * Created by Malo on 14/03/2018.
 */

public class XmlFilesViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewFileName = null;
    private TextView textViewFileDate = null;
    private TextView textViewFileMessageCount = null;

    public XmlFilesViewHolder(View itemView) {
        super(itemView);

        textViewFileName = itemView.findViewById(R.id.file_name);
        textViewFileDate = itemView.findViewById(R.id.file_date);
        textViewFileMessageCount = itemView.findViewById(R.id.file_message_count);
    }

    public TextView getTextViewFileName() {
        return textViewFileName;
    }

    public TextView getTextViewFileDate() {
        return textViewFileDate;
    }

    public TextView getTextViewFileMessageCount() {
        return textViewFileMessageCount;
    }

}