package com.example.contactsmanager;

import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class Repository {

    //initializing the vars for the all the databases we have in the app

    private final ContactDAO contactDAO;

    //Used for Background Database Operations
    Executor executor;
    //Used for update UI
    android.os.Handler handler;


    public Repository(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
        this.executor = Executors.newSingleThreadExecutor();
        this.handler = new android.os.Handler(Looper.getMainLooper());
    }

    //All methods from the DAO should be executed here
    public void addContact(Contacts contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });


    }

    public void deleteContact(Contacts contact)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });

    }

    public LiveData<List<Contacts>> getAllContacts(){
        return contactDAO.getAllContacts();
    }
}
