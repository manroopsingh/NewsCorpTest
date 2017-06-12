package com.example.adam.newscorptest.view.photoList;

import com.example.adam.newscorptest.BasePresenter;
import com.example.adam.newscorptest.BaseView;
import com.example.adam.newscorptest.model.Photo;

import java.util.List;

/**
 * Created by adam on 6/12/17.
 */

public interface PhotoListContract {

    interface View extends BaseView{

        void updatePhotoList(List<Photo> photoList);

    }


    interface Presenter extends BasePresenter<View>{

        void getPhotoList();
        void getNewPhotoList();
    }

}
