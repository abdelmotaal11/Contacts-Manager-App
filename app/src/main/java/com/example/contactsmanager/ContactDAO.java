package com.example.contactsmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDAO {
    @Insert
    void insert(Contacts contact);

    @Delete
    void delete(Contacts contact);

    @Query("SELECT * FROM contacts_table")
    List<Contacts> getAllContacts();
}
