package com.example.car;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.car.BuyFragment.BuyOneFragment;
import com.example.car.BuyFragment.BuyThreeFragment;
import com.example.car.BuyFragment.BuyTwoFragment;
import com.example.car.BuyFragment.MyBuyFragmentAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link buyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link buyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class buyFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    /*
    * MyCode
    *
    * */

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyBuyFragmentAdapter myBuyFragmentAdapter;
    private  TabLayout.Tab one;
    private  TabLayout.Tab two;
    private  TabLayout.Tab three;

    public buyFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment buyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static buyFragment newInstance(String param1, String param2) {
        buyFragment fragment = new buyFragment();
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
        View view = inflater.inflate(R.layout.fragment_buy,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        viewPager = view.findViewById(R.id.buy_view_page);
        myBuyFragmentAdapter = new MyBuyFragmentAdapter(getFragmentManager());
        viewPager.setAdapter(myBuyFragmentAdapter);

        tabLayout = view.findViewById(R.id.buy_tab);
        tabLayout.setupWithViewPager(viewPager);

        one= tabLayout.getTabAt(0);
        two = tabLayout.getTabAt(1);
        three = tabLayout.getTabAt(3);

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
