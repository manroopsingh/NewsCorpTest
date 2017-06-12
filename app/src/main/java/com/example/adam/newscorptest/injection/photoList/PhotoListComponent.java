package com.example.adam.newscorptest.injection.photoList;

import com.example.adam.newscorptest.view.photoList.PhotoListActivity;

import dagger.Component;

/**
 * Created by adam on 6/12/17.
 */


@Component(modules = PhotoListModule.class)
public interface PhotoListComponent {

    void inject(PhotoListActivity photoListActivity);

}
