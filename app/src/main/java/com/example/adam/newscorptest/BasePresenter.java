package com.example.adam.newscorptest;

/**
 * Created by adam on 09-Apr-17.
 */

public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void removeView();
}
