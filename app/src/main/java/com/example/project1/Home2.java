package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project1.Adapter.event_adapter;
import com.example.project1.Model.event_model;
import com.example.project1.R;
import com.example.project1.databinding.ActivityHome2Binding;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class Home2 extends AppCompatActivity {
ActivityHome2Binding binding;
RecyclerView recyclerView;
FirebaseFirestore firestore;
FirebaseAuth auth;
RecyclerView.Adapter adapter;
    Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firestore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        Random random = new Random();
        String [] hadis={"ডান হাতে খাও এবং যা নিকটে তা থেকে খাও।","সালাত হলো ‘ নূর’ ।","যে  পবিত্র থাকতে চায় , " +
                "আল্লাহ তাকে  পবিত্র রাখেন।","ঘুষদাতা এবং গ্রহীতা উভয়ের উপর আল্লাহর অভিশাপ।","সর্বোত্তম বাণী আল্লাহর কিতাব ।"
                ,"যে নেতার অবাধ্য হলো সে আমার অবাধ্য হলো।"};
        int x = random.nextInt(5);
        binding.hadisTextView.setText(hadis[x]);
        
        initRecyclerView();
        setnamepic();

        binding.bottmProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home2.this, Profile.class);
                startActivity(intent);
            }

        });

        binding.bottomStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home2.this,Student_list.class);
                startActivity(intent);
            }
        });
        binding.bottomHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home2.this,Attendence.class);
                startActivity(intent);
            }
        });







    }

    private void setnamepic() {

        firestore.collection("User").document(auth.getUid().toString()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Picasso.get().load((String) documentSnapshot.getString("pic")).placeholder(R.drawable.baseline_account_circle_24).into(binding.homeProfileImage);
                binding.homeProfileName.setText(documentSnapshot.getString("name").toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    private void initRecyclerView() {
        ArrayList<event_model> item=new ArrayList<>();
        item.add(new event_model("art","তৃতীয় চতুর্থ এবং পঞ্চম শ্রেণির চিত্র অঙ্কন প্রতিযোগিতা","15 ই আগস্ট সকাল 9 টায়"));
        item.add(new event_model("exam","বার্ষিক পরীক্ষা প্রসঙ্গে","পরীক্ষা শুরু 10-09- 2023"));
        item.add(new event_model("gardian","অভিভাবক সমাবেশ","25 ই আগস্ট সকাল 9 টায়"));
        recyclerView=findViewById(R.id.event_recycelerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter=new event_adapter(item);
        recyclerView.setAdapter(adapter);
    }




}