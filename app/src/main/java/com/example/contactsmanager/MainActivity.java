package com.example.contactsmanager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //data source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    //adapter
    private MyAdapter myAdapter;

    //Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Data Binding
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        handlers = new MainActivityClickHandlers(this);
        mainBinding.setClickHandler(handlers);

        //RecyclerView
        RecyclerView recyclerView = mainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        //dataabse
        contactDatabase = ContactDatabase.getInstance(this);

        //viewModel
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        //Inserting new contact for testing
        Contacts c1 = new Contacts("Mostafa","mostafa6520@gmail.com");
        viewModel.addNewContact(c1);
        //Load from DB
        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                for (Contacts c:contacts){
                    Log.v("TAGY>>>>>>>>>>",c.getName());
                    contactsArrayList.add(c);
                }
                myAdapter.notifyDataSetChanged();
            }
        });

        //adapter
        myAdapter = new MyAdapter(contactsArrayList);

        recyclerView.setAdapter(myAdapter);
    }
}