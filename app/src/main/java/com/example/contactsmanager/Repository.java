package com.example.contactsmanager;

import java.util.List;

public class Repository {

    //initializing the vars for the all the databases we have in the app

    private final ContactDAO contactDAO;


    public Repository(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    //All methods from the DAO should be executed here
    public void addContact(Contacts contact){
        contactDAO.insert(contact);
    }

    public void deleteContact(Contacts contact)
    {
        contactDAO.delete(contact);
    }

    public List<Contacts> getAllContacts(){

        return contactDAO.getAllContacts();
    }
}
