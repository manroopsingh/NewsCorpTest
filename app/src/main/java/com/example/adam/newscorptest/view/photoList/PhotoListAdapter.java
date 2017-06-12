package com.example.adam.newscorptest.view.photoList;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adam.newscorptest.R;
import com.example.adam.newscorptest.model.Photo;
import com.example.adam.newscorptest.view.photoDetail.PhotoDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 6/12/17.
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {



    List<Photo> photoList = new ArrayList<>();
    Context context;

    public PhotoListAdapter(List<Photo> photoList, Context context) {
        this.photoList = photoList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivPhoto;
        private TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

        }
    }



    @Override
    public PhotoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_list_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final PhotoListAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(photoList.get(position).getThumbnailUrl()).into(holder.ivPhoto);
        holder.tvTitle.setText(photoList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, PhotoDetailActivity.class);
                intent.putExtra("photo", photoList.get(position));
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
