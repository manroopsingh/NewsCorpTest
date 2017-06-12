package com.example.adam.newscorptest.utils;

import com.example.adam.newscorptest.model.Photo;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by adam on 09-Apr-17.
 */

public class RetrofitHelper {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;



    }

    public static Observable<List<Photo>> getPhotosObs(){

        Retrofit retrofit = create();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getPhotos();

    }


    public interface RetrofitService{

        @GET("/photos")
        Observable<List<Photo>> getPhotos();

    }

}
