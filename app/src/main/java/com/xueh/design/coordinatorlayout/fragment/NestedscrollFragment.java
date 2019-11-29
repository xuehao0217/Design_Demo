package com.xueh.design.coordinatorlayout.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xueh.design.R;
import com.xueh.design.coordinatorlayout.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class NestedscrollFragment extends Fragment {

    private ArrayList<String> stringArrayList;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nestedscroll, container, false);
        return view;
    }
}
