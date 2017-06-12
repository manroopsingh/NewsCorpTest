package com.example.adam.newscorptest.view.photoDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adam.newscorptest.R;
import com.example.adam.newscorptest.injection.photoDetail.DaggerPhotoDetailComponent;
import com.example.adam.newscorptest.model.Photo;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoDetailActivity extends AppCompatActivity implements PhotoDetailContract.View{

    @BindView(R.id.ivPhotoLarge)
    ImageView ivPhotoLarge;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @Inject
    PhotoDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        ButterKnife.bind(this);

        DaggerPhotoDetailComponent.create().inject(this);

        presenter.addView(this);
        presenter.getData(getIntent());


    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateViews(Photo photo) {

        Glide.with(this).load(photo.getUrl()).into(ivPhotoLarge);
        tvTitle.setText(photo.getTitle());

    }
}
