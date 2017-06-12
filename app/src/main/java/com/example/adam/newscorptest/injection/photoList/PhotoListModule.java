package com.example.adam.newscorptest.injection.photoList;

import com.example.adam.newscorptest.view.photoList.PhotoListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adam on 6/12/17.
 */

@Module
public class PhotoListModule {


    @Provides
    PhotoListPresenter providesPhotoListPresenter() {
        return new PhotoListPresenter();
    }

}
