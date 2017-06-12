package com.example.adam.newscorptest.view.photoDetail;

import android.content.Intent;

import com.example.adam.newscorptest.BasePresenter;
import com.example.adam.newscorptest.BaseView;
import com.example.adam.newscorptest.model.Photo;
import com.example.adam.newscorptest.view.photoList.PhotoListContract;

/**
 * Created by adam on 6/12/17.
 */

public interface PhotoDetailContract {

    interface View extends BaseView {

         void updateViews(Photo photo);

    }


    interface Presenter extends BasePresenter<View> {

        void getData(Intent intent);


    }

}
