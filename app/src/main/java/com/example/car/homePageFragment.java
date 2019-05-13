package com.example.car;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link homePageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link homePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homePageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private ArrayList<Integer> images = new ArrayList<Integer>();
    private ArrayList<Integer> lexus_images = new ArrayList<>();
    private ArrayList<Integer> audi_images = new ArrayList<>();
    private ArrayList<Integer> bmw_images = new ArrayList<>();
    private TextView tv_audi;
    private TextView tv_lexus;
    private TextView tv_bmw;
    private RecyclerView audiRecyclerView;
    private RecyclerView lexusRecyclerView;

    private ImageView bmwImageView1;
/*
    private ImageView bmwImageView2;
    private ImageView bmwImageView3;
    private ImageView bmwImageView4;
*/


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public homePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homePageFragment newInstance(String param1, String param2) {
        homePageFragment fragment = new homePageFragment();
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
        View view = inflater.inflate(R.layout.fragment_home_page,container,false);
        initComponent(view);
        return view;
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


    private void initComponent(View view){

        images.add(R.drawable.carone);
        images.add(R.drawable.cartwo);
        images.add(R.drawable.carthree);
        audi_images.add(R.drawable.oooo1);
        audi_images.add(R.drawable.oooo2);
        audi_images.add(R.drawable.oooo3);
        audi_images.add(R.drawable.oooo4);
        lexus_images.add(R.drawable.nx);
        lexus_images.add(R.drawable.rx);
        lexus_images.add(R.drawable.ux);
        bmw_images.add(R.drawable.onehousejpgs);
        bmw_images.add(R.drawable.twohousejpgs);
        bmw_images.add(R.drawable.threehousesjpg);
        bmw_images.add(R.drawable.fourhousesjpg);

        Banner banner = view.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImangerLoader());
        banner.setImages(images);
        banner.start();

        tv_audi = view.findViewById(R.id.tv_audi);
        Drawable drawable = getResources().getDrawable(R.drawable.newlook2);
        drawable.setBounds(0,0,80,80);
        tv_audi.setText(R.string.audi);
        tv_audi.setCompoundDrawables(drawable,null,null,null);

        audiRecyclerView =view.findViewById(R.id.ry_audi);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        audiRecyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(getActivity(),audi_images);
        audiRecyclerView.setAdapter(myAdapter);

        tv_lexus = view.findViewById(R.id.tv_lexus);
        Drawable drawable1 = getResources().getDrawable(R.drawable.newlook2);
        drawable1.setBounds(0,0,80,80);
        tv_lexus.setText(R.string.lexus);
        tv_lexus.setCompoundDrawables(drawable,null,null,null);

        lexusRecyclerView = view.findViewById(R.id.ry_lexus);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        lexusRecyclerView.setLayoutManager(linearLayoutManager1);
        MyAdapter myAdapter1 = new MyAdapter(getActivity(),lexus_images);
        lexusRecyclerView.setAdapter(myAdapter1);

        tv_bmw = view.findViewById(R.id.tv_bmw);
        Drawable drawable2 = getResources().getDrawable(R.drawable.newlook2);
        drawable2.setBounds(0,0,80,80);
        tv_bmw.setText(R.string.BMW);
        tv_bmw.setCompoundDrawables(drawable,null,null,null);

        bmwImageView1 = view.findViewById(R.id.ig_bmw);
        Glide.with(this).load(R.drawable.bmw).into(bmwImageView1);

        /*bmwImageView1 = view.findViewById(R.id.ig_bmw1);
        Glide.with(this).load(R.drawable.onehousejpgs).into(bmwImageView1);
        bmwImageView2 = view.findViewById(R.id.ig_bmw2);
        Glide.with(this).load(R.drawable.twohousejpgs).into(bmwImageView2);
        bmwImageView3 = view.findViewById(R.id.ig_bmw3);
        Glide.with(this).load(R.drawable.threehousesjpg).into(bmwImageView3);
        bmwImageView4 =view.findViewById(R.id.ig_bmw4);
        Glide.with(this).load(R.drawable.fourhousesjpg).into(bmwImageView4);*/


    }
}
