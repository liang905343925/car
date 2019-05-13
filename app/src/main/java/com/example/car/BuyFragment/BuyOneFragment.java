package com.example.car.BuyFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.car.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BuyOneFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BuyOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyOneFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    /*
    * code
    * */
    private ArrayList<Integer> images ;
    private RecyclerView recyclerView;
    private ArrayList<String > priceList=new ArrayList<>();

    public BuyOneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuyOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyOneFragment newInstance(String param1, String param2) {
        BuyOneFragment fragment = new BuyOneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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

        View view = inflater.inflate(R.layout.fragment_buy_one,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        images = new ArrayList<>();
        images.add(R.drawable.firesai0);
        images.add(R.drawable.firesai1);
        images.add(R.drawable.firesai2);
        images.add(R.drawable.firesai3);
        images.add(R.drawable.firesai4);
        images.add(R.drawable.firesai5);
        images.add(R.drawable.firesai6);
        images.add(R.drawable.firesai7);
        images.add(R.drawable.firesai8);
        images.add(R.drawable.firesai9);
        images.add(R.drawable.firesai10);
        images.add(R.drawable.firesai11);
        images.add(R.drawable.firesai12);
        images.add(R.drawable.firesai13);
        images.add(R.drawable.firesai14);
        images.add(R.drawable.firesai15);

       for (int i =0 ; i< 17 ;i++){
           priceList.add("$"+i);
       }

        recyclerView = view.findViewById(R.id.ry_buy_one);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemAdapter itemAdapter = new ItemAdapter(getActivity(),images,priceList);
        recyclerView.setAdapter(itemAdapter);

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
