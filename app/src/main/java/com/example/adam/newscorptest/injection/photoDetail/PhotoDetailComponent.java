package com.example.adam.newscorptest.injection.photoDetail;

import com.example.adam.newscorptest.view.photoDetail.PhotoDetailActivity;

import dagger.Component;

/**
 * Created by adam on 6/12/17.
 */

@Component(modules = PhotoDetailModule.class)
public interface PhotoDetailComponent {

    void inject(PhotoDetailActivity photoDetailActivity);
}
