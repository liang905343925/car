package com.example.car.BuyFragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.car.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private Context mContext;
    private List<Integer> images;
    private List<String> priceList;


    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        Button addButton;
        Button delButton;
        EditText editText;
        TextView tv_price;
        public MyViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.ig_shopping_item);
            addButton = view.findViewById(R.id.btnIncrease);
            delButton = view.findViewById(R.id.btnDecrease);
            editText = view.findViewById(R.id.etAmount);
            tv_price = view.findViewById(R.id.tv_price);
            delButton.setVisibility(View.GONE);
            editText.setVisibility(View.GONE);
            editText.setFocusable(false);


        }

    }

    public  ItemAdapter(Context mContext,List<Integer> images,List<String> priceList){
        this.priceList = priceList;
        this.images = images;
        this.priceList = priceList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).
                inflate(R.layout.recyclerview_item,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Glide.with(mContext).load(images.get(i)).into(myViewHolder.imageView);
        myViewHolder.tv_price.setText(priceList.get(i));

    }
}
