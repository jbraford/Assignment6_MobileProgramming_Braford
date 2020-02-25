package com.example.assignment6_mobileprogramming_braford;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    // Array list of contacts
    private ArrayList<Contact> contactList = new ArrayList<>();

    /**
     * Constructor that initializes the array list
     */
    public ContactList() {
        contactList = new ArrayList<>();
    }


    //MainActivity m = new MainActivity();
    //String [] names = m.contactNames;
    //String [] numbers = m.contactPhoneNumbers;

    String[] names = {"Dad","Mom", "Micah"};
    String[] numbers = {"2182563097", "7152222420", "2182447772"};

    /**
     * Adds contacts to the list
     */
    public void CreateContactList() {

        for (int i = 0; i < names.length; i++) {

                contactList.add(new Contact(names[i], numbers[i]));
            }
        }



    public Contact getContact(Integer index) {
        return contactList.get(index);
    }
    public List getList(){
        return contactList;
    }
    public void remove(Integer index){
        contactList.remove(index);
    }

}
