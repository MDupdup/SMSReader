package com.malo.smsreader.Objects;

/**
 * Created by Malo on 14/04/2018.
 */

public class File {

    private String name;
    private long date;
    private int messageCount;


    public File(String name, long date, int messageCount) {
        this.name = name;
        this.date = date;
        this.messageCount = messageCount;
    }


    public String getName() {
        return name;
    }

    public long getDate() {
        return date;
    }

    public int getMessageCount() {
        return messageCount;
    }

}
