package com.example.adam.newscorptest.injection.photoDetail;

import com.example.adam.newscorptest.view.photoDetail.PhotoDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adam on 6/12/17.
 */

@Module
public class PhotoDetailModule {


    @Provides
    PhotoDetailPresenter providesPhotoListPresenter() {
        return new PhotoDetailPresenter();

    }

}
