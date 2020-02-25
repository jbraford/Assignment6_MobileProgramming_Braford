package com.example.assignment6_mobileprogramming_braford;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    ContactList contactList;        // The list of heart rate objects
    ArrayAdapter<Contact> cnAdapter;  // The custom array adapter for displaying the heart rates in the list view
    ListView lvContacts;              // The list view for the heart rates from the activity_mail.xml file
    TextView tvSelect, textViewStatus;
    Button btnCall, btnText;
    String [] contactNames, contactPhoneNumbers;
    Resources res;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtonClickEvents();
        setupButtonClickEvents2();

        res = getResources();
        contactPhoneNumbers = res.getStringArray(R.array.contact_Number);
        contactNames = res.getStringArray(R.array.contact_Name);








        tvSelect = (TextView) findViewById(R.id.textViewSelect);
        lvContacts = (ListView) findViewById(R.id.lvContacts);


        contactList = new ContactList();
        contactList.CreateContactList();

        cnAdapter = new ContactAdapter(this, R.layout.contact_list, R.id.textViewName, contactList);
        cnAdapter.setDropDownViewResource(R.layout.contact_list);
        lvContacts.setAdapter(cnAdapter);



        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Contact cn = (Contact) parent.getItemAtPosition(position);
                tvSelect.setText("You selected: " + cn.toString());
            }
        });

    }
    private void setupButtonClickEvents() {
        /**
         *   Set up button click event listener for the web info button for the first performance
         */
        btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                textViewStatus.setText("You are calling: " + contactList.getContact(2).getName());
                Uri webpage = Uri.parse("http://www.css.edu/about/spotlight-arts-and-lectures.html");
                Intent intent = new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:" + contactList.getContact(2).getNumber()));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                if (activities.size() > 0) {      // found at least one app to make call
                    startActivity(intent);    // start that app
                }

            }
        });
    }

    private void setupButtonClickEvents2() {

        btnText = (Button) findViewById(R.id.btnText);
        btnText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                textViewStatus.setText("You are texting: " + contactList.getContact(2).getName());
                Uri webpage = Uri.parse("http://www.css.edu/about/spotlight-arts-and-lectures.html");

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("tel:" + contactList.getContact(2).getNumber()));
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    sendIntent.putExtra("sms_body", "Hi");
                    startActivity(sendIntent);
                }
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(sendIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                if (activities.size() > 0) {      // found at least one app to make call
                    startActivity(sendIntent);    // start that app
                }

            }
        });
    }}


