package com.example.assignment6_mobileprogramming_braford;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;


public class ContactAdapter extends ArrayAdapter<Contact>{


        private Context context;      // The activity calling this adapter
        private ContactList cnList;       // The object holding the arraylist of contacts

        /**
         *
         * @param context The activity calling this adapter
         * @param rowLayout The xml file defining the layout for one item or row in the list
         * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
         * @param cnList The object holding the arraylist of contacts
         */
        public ContactAdapter(Context context, int rowLayout, int dummyTV, ContactList cnList) {
            super(context, rowLayout, dummyTV, cnList.getList());
            this.context = context;
            this.cnList = cnList;
        }

        /**
         * This is called automatically to display each item in the list.
         *    Here you must fill the layout for one row or item in the list
         *
         * @param position index in the list that is being selected
         * @param convertView
         * @param parent The parent layout this list is in
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.contact_list, null);
            //get the heart rate we are displaying
            Contact c = cnList.getContact(position);

            TextView tvPulse=(TextView)view.findViewById(R.id.textViewName);
            tvPulse.setText(c.getName().toString());

            TextView tvRange =(TextView) view.findViewById(R.id.textViewNumber);
            tvRange.setText(c.getNumber());












            return(view);
        }

    }



