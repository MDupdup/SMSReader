package com.malo.smsreader.Objects;

/**
 * Created by Malo on 14/04/2018.
 */

public class Message {

    private Contact contact;
    private int type;
    private String body;
    private long date;
    private String readableDate;
    private String object;


    public Message(Contact contact, int type, String body, long date, String readableDate, String object) {
        this.contact = contact;
        this.type = type;
        this.body = body;
        this.date = date;
        this.readableDate = readableDate;
        this.object = object;
    }

    public Contact getContact() {
        return contact;
    }

    public int getType() {
        return type;
    }

    public String getBody() {
        return body;
    }

    public long getDate() {
        return date;
    }

    public String getReadableDate() {
        return readableDate;
    }

    public String getObject() {
        return object;
    }

    public String getDayMonthOfDate() {
        return readableDate.split("\\s+")[0] + " " + readableDate.split("\\s+")[1];
    }
}
