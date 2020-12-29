package com.example.complexviews;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String surname;
    private boolean isOnline;

    public Contact(String name, String surname, boolean isOnline) {
        this.name = name;
        this.surname = surname;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public static ArrayList<Contact> createList(int number) {
        ArrayList<Contact> contacts = new ArrayList<>();

        for(int i = 0; i < number; i++) {
            boolean foo = false;
            if(i % 2 == 0)
                foo = true;
            contacts.add(new Contact("Nume", "Surname" + i, foo));
        }

        return  contacts;
    }
}
