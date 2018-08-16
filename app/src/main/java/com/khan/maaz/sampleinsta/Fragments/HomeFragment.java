package com.khan.maaz.sampleinsta.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khan.maaz.sampleinsta.R;
import com.khan.maaz.sampleinsta.adapters.StoryAdapter;
import com.khan.maaz.sampleinsta.models.Stories;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private ArrayList<Stories> list;
    Context c;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public HomeFragment() {

    }




    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        list = prepareDummyData();
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.stories);
        StoryAdapter storyAdapter = new StoryAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(storyAdapter);
        return view;

        }

        public ArrayList<Stories> prepareDummyData(){

        ArrayList<Stories> list = new ArrayList<Stories>();
        Resources rs= getResources();
        String[] uploader = rs.getStringArray(R.array.uploader);
        int[] story ={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
        for (int i=0;i<=uploader.length;i++){
            Stories stories = new Stories(uploader[i],story[i]);
            list.add(stories);
        }
        return list;

        }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
