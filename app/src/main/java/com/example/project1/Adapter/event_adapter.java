package com.example.project1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.project1.Model.event_model;
import com.example.project1.R;

import java.util.ArrayList;


public class event_adapter extends RecyclerView.Adapter<event_adapter.Viewholder> {

    ArrayList<event_model> item;
    Context context;

    public event_adapter(ArrayList<event_model> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public event_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_demoo,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull event_adapter.Viewholder holder, int position) {
     holder.title.setText(item.get(position).getTitle());
     holder.date.setText(item.get(position).getDate());
     int dr=holder.itemView.getResources().getIdentifier(item.get(position).getPic(),"drawable",holder.itemView.getContext().getOpPackageName());
        Glide.with(holder.itemView.getContext())
                .load(dr).transform(new GranularRoundedCorners(30,30,0,0))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class Viewholder extends  RecyclerView.ViewHolder{

        TextView title,date;
        ImageView pic;
        public Viewholder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.title_textView);
            date=itemView.findViewById(R.id.date_textView);
            pic=itemView.findViewById(R.id.event_pic_imageView);
        }
    }
}
