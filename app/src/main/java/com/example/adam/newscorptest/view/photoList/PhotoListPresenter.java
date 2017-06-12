package com.example.adam.newscorptest.view.photoList;

import android.util.Log;

import com.example.adam.newscorptest.model.Photo;
import com.example.adam.newscorptest.utils.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by adam on 6/12/17.
 */

public class PhotoListPresenter implements PhotoListContract.Presenter {


    PhotoListContract.View view;
    List<Photo> photoList = new ArrayList<>();

    @Override
    public void addView(PhotoListContract.View view) {
        this.view = view;

    }

    @Override
    public void removeView() {

        this.view = null;
    }

    @Override
    public void getPhotoList() {

        //make the rest call using Rx.Observable
        Observable<List<Photo>> listObservable = RetrofitHelper.getPhotosObs();
        listObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Photo>>() {
                    @Override
                    public void onCompleted() {
                        view.updatePhotoList(photoList);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Photo> photos) {
                        photoList.addAll(photos);
                        Log.d("TAG", "onNext: " + photoList.size());

                    }
                });



    }

    @Override
    public void getNewPhotoList() {
        photoList.clear();
        getPhotoList();


    }
}