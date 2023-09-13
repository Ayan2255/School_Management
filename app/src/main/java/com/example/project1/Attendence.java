package com.example.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.project1.Adapter.Attendence_adapter;
import com.example.project1.Adapter.Student_list_adapter;
import com.example.project1.Model.User_model;
import com.example.project1.databinding.ActivityAttendenceBinding;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Attendence extends AppCompatActivity {
ActivityAttendenceBinding binding;
FirebaseFirestore firestore;
ArrayList<User_model> list;
Attendence_adapter adapter;
Context context;
String cl="",sf="";
ArrayAdapter<String> adapterItem2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAttendenceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firestore=FirebaseFirestore.getInstance();

        list=new ArrayList<>();
        adapter= new Attendence_adapter(list,context);

        String [] cls={"class 1","class 2","class 3","class 4","class 5","class 6","class 7","class 8","class 9","class 10"};
        String [] shift={"Day","Morning"};

        adapterItem2=new ArrayAdapter<String>(Attendence.this,R.layout.list,cls);
        binding.dropCls.setAdapter(adapterItem2);
        binding.dropCls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cl=parent.getItemAtPosition(position).toString();
            }
        });

        adapterItem2=new ArrayAdapter<String>(Attendence.this,R.layout.list,shift);
        binding.dropItemsShift.setAdapter(adapterItem2);
        binding.dropItemsShift.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sf=parent.getItemAtPosition(position).toString();
            }
        });
        adapter= new Attendence_adapter(list,context);
        binding.attendenceRecycelerview.setHasFixedSize(true);
      //  binding.attendenceRecycelerview.setLayoutManager(new LinearLayoutManager(Attendence.this));
        binding.attendenceRecycelerview.setLayoutManager(new GridLayoutManager(Attendence.this,3));

        binding.attendenceRecycelerview.setAdapter(adapter);



        binding.attendenceSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.removeAll(list);
                adapter.notifyDataSetChanged();


                       if(cl!="" && sf!="") {

                           firestore.collection("Student").document(cl).
                                   collection(sf).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                       @Override
                                       public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                                           for (DocumentChange documentChange : value.getDocumentChanges()) {
                                               User_model mm = documentChange.getDocument().toObject(User_model.class);


                                               if (documentChange.getType() == DocumentChange.Type.ADDED) {


                                                   list.add(mm);

                                                   adapter.notifyDataSetChanged();


                                               }

                                           }

                                       }
                                   });

                       }




            }
        });



        binding.submitAttBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Attendence_adapter attendence_adapter=new Attendence_adapter();
                ArrayList<User_model>list2;
                list2= attendence_adapter.list;
               // User_model  model2=list2.;
                Map<String,Object> map=new HashMap<>();
              //  Toast.makeText(Attendence.this, model2.getAttendence(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}