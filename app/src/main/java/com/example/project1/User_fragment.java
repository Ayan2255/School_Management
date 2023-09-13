package com.example.project1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project1.Model.User_model;
import com.example.project1.databinding.FragmentUserFragmentBinding;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class User_fragment extends Fragment {


    FragmentUserFragmentBinding binding;
    FirebaseFirestore firestore;
    Context context;
    ArrayList<User_model> list;
    //People_Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentUserFragmentBinding.inflate(inflater,container,false);

        firestore=FirebaseFirestore.getInstance();



        return binding.getRoot();
    }

}