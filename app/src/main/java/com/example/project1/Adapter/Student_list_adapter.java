package com.example.project1.Adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.Model.User_model;
import com.example.project1.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Student_list_adapter extends RecyclerView.Adapter<Student_list_adapter.Holder> {
    ArrayList<User_model> list;
    Context context;
    FirebaseFirestore firestore;
    AlertDialog alertDialog;
    ProgressDialog progressDialog;

    public Student_list_adapter(ArrayList<User_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Student_list_adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_demo,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Student_list_adapter.Holder holder, int position) {

firestore=FirebaseFirestore.getInstance();
User_model model=list.get(position);

    holder.name.setText(model.getName());
    if(model.getShift().toString().equals("Day")){
        holder.roll.setText("    "+"1");
        holder.shift.setText("  "+model.getShift());
    }
    else {
        holder.roll.setText(model.getRoll());
        holder.shift.setText(model.getShift());
    }


    holder.cls.setText(model.getCls());
    Picasso.get().load((String) model.getPic()).placeholder(R.drawable.baseline_account_circle_24).into(holder.student_pic);


    if(model.getAttendence().equals("t")){
        Uri uri = Uri.parse("R.drawable.baseline_check_24_green");
        Picasso.get().load(uri).placeholder(R.drawable.baseline_check_24_green).into(holder.attendance);

    }
    else {

        Uri uri = Uri.parse("R.drawable.baseline_check_24_red");
        Picasso.get().load(uri).placeholder(R.drawable.baseline_check_24_red).into(holder.attendance);

    }










    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public  static class Holder extends RecyclerView.ViewHolder {

        TextView name,roll,cls,shift;
        ImageView student_pic,attendance;
        public Holder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.people_demo_name);
            cls=itemView.findViewById(R.id.people_demo_cls);
            shift=itemView.findViewById(R.id.people_demo_shift);
            roll=itemView.findViewById(R.id.people_demo_roll);
            attendance=itemView.findViewById(R.id.people_demo_attendence);
            student_pic=itemView.findViewById(R.id.people_demo_profile_image);
        }
    }


}


