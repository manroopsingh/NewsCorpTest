package com.example.adam.newscorptest.view.photoDetail;

import android.content.Intent;
import android.util.Log;

import com.example.adam.newscorptest.model.Photo;
import com.example.adam.newscorptest.view.photoList.PhotoListContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 6/12/17.
 */

public class PhotoDetailPresenter implements PhotoDetailContract.Presenter{

    PhotoDetailContract.View view;

    @Override
    public void addView(PhotoDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getData(Intent intent) {

        Photo photo = (Photo) intent.getSerializableExtra("photo");
        Log.d("TAG", "getData: "+photo.getUrl());
        view.updateViews(photo);
    }
}
