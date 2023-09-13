package com.example.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project1.Adapter.Student_list_adapter;
import com.example.project1.Model.User_model;
import com.example.project1.databinding.ActivityStudentListBinding;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Student_list extends AppCompatActivity {
ActivityStudentListBinding binding;
    FirebaseFirestore firestore;
    Context context;
    ArrayList<User_model> list;
    Student_list_adapter adapter;
    int total=0,present=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStudentListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore=FirebaseFirestore.getInstance();

        binding.studentListBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Student_list.this,Home2.class);
                startActivity(intent);
            }
        });

        list=new ArrayList<>();
        adapter=new Student_list_adapter(list,context);
        binding.studetRecycelerview.setHasFixedSize(true);
        binding.studetRecycelerview.setLayoutManager(new LinearLayoutManager(Student_list.this));
        binding.studetRecycelerview.setAdapter(adapter);
        receved();
;



    }

    private void receved() {
        String [] cls={"class 1","class 2","class 3","class 4","class 5","class 6","class 7","class 8","class 9","class 10"};
        String [] sf={"Morning","Day"};

for(int i=0;i<10;i++){
    for(int j=0;j<2;j++){

    firestore.collection("Student").document(cls[i]).
            collection(sf[j]).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                    for(DocumentChange documentChange : value.getDocumentChanges()){
                        User_model mm = documentChange.getDocument().toObject(User_model.class);
                        total ++;
                        if(mm.getAttendence().equals("t")){
;                       present ++;}

                        if(documentChange.getType()== DocumentChange.Type.ADDED ){



                            list.add(mm);

                            adapter.notifyDataSetChanged();


                        }

                    }

                    binding.tatalStudent.setText(" Total Student \n     "+list.size());
                    binding.presentStudent.setText("Present Student \n      "+present);
                    int result =list.size()-present;
                    binding.absentStudent.setText("Absent Student \n        "+result);
                }
            });




}



}




    }
}