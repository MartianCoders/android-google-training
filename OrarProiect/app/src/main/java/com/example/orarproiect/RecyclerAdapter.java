package com.example.orarproiect;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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


import org.w3c.dom.Text;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Ora> items;
    private AdapterView.OnItemClickListener mClick;

    public RecyclerAdapter(List<Ora> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ora ora = items.get(position);

        String groupType = ora.getGroup() + " - " + ora.getTypeOf();


        holder.title.setText(ora.getName());
        holder.type.setText(groupType);
        holder.teacher.setText(ora.getTeacherName());
        holder.classRoom.setText(ora.getClassroom());
        holder.hourStart.setText(ora.getStartHour().toString());
        holder.hourFinish.setText(ora.getFinishHour().toString());

    }

    @Override
    public int getItemCount() {
        return items.size();

    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public TextView title;
        public TextView type;
        public TextView group;
        public TextView teacher;
        public TextView classRoom;
        public TextView hourStart;
        public TextView hourFinish;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.stringTitle);
            type = (TextView) itemView.findViewById(R.id.stringType);
            group = (TextView) itemView.findViewById(R.id.stringGroup);
            teacher = (TextView) itemView.findViewById(R.id.stringTeacher);
            classRoom = (TextView) itemView.findViewById(R.id.stringClassroom);
            hourStart = (TextView) itemView.findViewById(R.id.hourStart);
            hourFinish = (TextView) itemView.findViewById(R.id.hourFinish);

        }

    }
}