package com.example.car;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link meFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link meFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class meFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /*
    * code here
    * */
    private TextView tv_order_form;
    private TextView tv_purchase;
    private TextView tv_setting;
    private TextView tv_connect;
    private Button btn_exit;


    public meFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment meFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static meFragment newInstance(String param1, String param2) {
        meFragment fragment = new meFragment();
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
        View view = inflater.inflate(R.layout.fragment_me,container,false);
        initViexw(view);
        return view;
    }

    private void initViexw(View view) {
        tv_order_form = view.findViewById(R.id.tv_order_form);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_order);
        drawable.setBounds(0,0,80,80);
        tv_order_form.setCompoundDrawables(drawable,null,null,null);
        tv_order_form.setText(R.string.order);

        tv_purchase = view.findViewById(R.id.tv_purchase);
        Drawable drawable1 = getResources().getDrawable(R.drawable.ic_buy);
        drawable1.setBounds(0,0,80,80);
        tv_purchase.setCompoundDrawables(drawable,null,null,null);
        tv_purchase.setText(R.string.purchase);
        tv_purchase.setCompoundDrawables(drawable1,null,null,null);

        tv_setting = view.findViewById(R.id.tv_setting);
        Drawable drawable2 = getResources().getDrawable(R.drawable.ic_setting);
        drawable2.setBounds(0,0,80,80);
        tv_setting.setText(R.string.setting);
        tv_setting.setCompoundDrawables(drawable2,null,null,null);

        tv_connect = view.findViewById(R.id.tv_connect_us);
        Drawable drawable3 = getResources().getDrawable(R.drawable.ic_ring);
        drawable3.setBounds(0,0,80,80);
        tv_connect.setText(R.string.connnect);
        tv_connect.setCompoundDrawables(drawable3,null,null,null);
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
