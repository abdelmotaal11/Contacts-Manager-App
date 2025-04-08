package com.example.contactsmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends AndroidViewModel {

    private  Repository myRepository;

    private LiveData<List<Contacts>> allContacts;
    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public void addNewContact(Contacts contact){
        myRepository.addContact(contact);
    }

    public void deleteContact(Contacts contact){
        myRepository.deleteContact(contact);
    }
    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

}
