package com.malo.smsreader.Objects;

/**
 * Created by Malo on 14/04/2018.
 */

public class Contact {

    private String number;
    private String name;

    public Contact(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
