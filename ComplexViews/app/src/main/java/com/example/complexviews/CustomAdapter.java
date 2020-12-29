package com.example.complexviews;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Contact> contacts;
    private AdapterView.OnItemClickListener mClick;

    public CustomAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        TextView nameTextView = holder.nameTextView;
        TextView isOnlineTextView = holder.isOnlineView;
        String fullName = contact.getName() + " " + contact.getSurname();
        nameTextView.setText(fullName);

        if(contact.isOnline()) {
            isOnlineTextView.setText("ONLINE");
            isOnlineTextView.setTextColor(Color.GREEN);
        }
        else {
            isOnlineTextView.setText("Offline");
            isOnlineTextView.setTextColor(Color.RED);
            holder.relativeLayout.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public RelativeLayout relativeLayout;
        public TextView nameTextView;
        public TextView isOnlineView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            isOnlineView = (TextView) itemView.findViewById(R.id.isOnline);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.parentRelative);

        }

    }
}