package com.example.car;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Integer> images;
    private Context mContext;


    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView ;
        public MyViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.ig_audi);


        }

    }

    public MyAdapter(Context mContext,List<Integer> images){
        this.mContext = mContext;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.audi_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //myViewHolder.imageView.setImageResource(images.get(i));

        Glide.with(mContext).load(images.get(i)).into(myViewHolder.imageView);

    }
}
