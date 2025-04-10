package com.example.contactsmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
public class Contacts {
    @ColumnInfo(name = "contacts_id")
    @PrimaryKey(autoGenerate = true)
    private  int id;
    @ColumnInfo(name = "contacts_name")
    private String name;
    @ColumnInfo(name = "contacts_email")
    private String email;

    public Contacts( String name, String email) {

        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacts() {
    }
}
