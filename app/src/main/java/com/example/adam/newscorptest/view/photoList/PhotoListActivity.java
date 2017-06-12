package com.example.adam.newscorptest.view.photoList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adam.newscorptest.R;
import com.example.adam.newscorptest.injection.photoList.DaggerPhotoListComponent;
import com.example.adam.newscorptest.model.Photo;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoListActivity extends AppCompatActivity implements PhotoListContract.View{


    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private PhotoListAdapter adapter;

    @BindView(R.id.rvPhotoList)
    RecyclerView rvPhotoList;

    @Inject
    PhotoListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        ButterKnife.bind(this);
        DaggerPhotoListComponent.create().inject(PhotoListActivity.this);
        presenter.addView(this);
        presenter.getPhotoList();




    }

    @OnClick(R.id.btnRefreshList)
    public void refreshList(){
        presenter.getNewPhotoList();

    }


    @Override
    public void showError(String error) {

    }

    @Override
    public void updatePhotoList(List<Photo> photoList) {
        adapter = new PhotoListAdapter(photoList, this);
        rvPhotoList.setLayoutManager(new LinearLayoutManager(this));
        rvPhotoList.setItemAnimator(new DefaultItemAnimator());
        rvPhotoList.setAdapter(adapter);

    }
}
