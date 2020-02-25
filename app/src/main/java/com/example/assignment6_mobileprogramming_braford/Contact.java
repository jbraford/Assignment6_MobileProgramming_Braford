package com.example.assignment6_mobileprogramming_braford;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;

import java.io.InputStream;

public class Contact {

    private String name;
    private String number;





   //String[] contactNames = {"Dad","Mom", "Micah"};
   // String[] contactPhoneNumbers = {"34433", "3453", "3433"};

    public Contact(String name, String number){
        this.name = name;
        this.number = number;

    }


    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + ": " + number;
    }




}
