package com.example.project1.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.project1.Attendence;
import com.example.project1.Model.User_model;
import com.example.project1.R;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Attendence_adapter extends RecyclerView.Adapter<Attendence_adapter.Holder> {

    public  ArrayList<User_model>list;
    public  ArrayList<User_model>list2;

    Context context;

    public Attendence_adapter(ArrayList<User_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public Attendence_adapter() {

    }

    @NonNull
    @Override
    public Attendence_adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendence_demo,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Attendence_adapter.Holder holder, int position) {
        User_model model=list.get(position);
        holder.toggleButton.setText(model.getRoll());
        holder.toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.toggleButton.isChecked()){
                    holder.toggleButton.setText(model.getRoll());
                    holder.toggleButton.setTextColor(Color.parseColor("#04D939"));
                    list2.add(list.get(position));
                    model.setAttendence("t");
                    list2.add(model);

                }
                else {
                    holder.toggleButton.setText(model.getRoll());
                    holder.toggleButton.setTextColor(Color.parseColor("#EA1179"));
                    model.setAttendence("f");
                    list.add(model);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class Holder extends RecyclerView.ViewHolder{

        ToggleButton toggleButton;
        public Holder(@NonNull View itemView) {
            super(itemView);
            toggleButton=itemView.findViewById(R.id.toggleButton);
        }
    }
}
