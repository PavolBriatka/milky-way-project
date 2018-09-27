package com.briatka.pavol.themilkyway.views;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.briatka.pavol.themilkyway.R;
import com.briatka.pavol.themilkyway.adapters.NasaDataAdapter;
import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.models.customobjects.NasaObject;
import com.briatka.pavol.themilkyway.models.data.RequestData;
import com.briatka.pavol.themilkyway.models.jsonobjects.CollectionData;
import com.briatka.pavol.themilkyway.models.jsonobjects.CollectionItem;
import com.briatka.pavol.themilkyway.presenters.MainPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final String NASA_OBJECT_KEY = "nasa_object_key";
    private static final String SAVED_ARRAY_KEY = "saved_array";
    private MainContract.MainPresenter mainPresenter;
    private NasaDataAdapter adapter;
    private ArrayList<NasaObject> nasaObjectList;
    private RecyclerView.LayoutManager layoutManager;


    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public class OnItemClickedListener implements NasaDataAdapter.OnItemClickedListener {

        @Override
        public void onItemClicked(NasaObject nasaObject) {

            Intent openDetailActivity = new Intent(MainActivity.this, DetailActivity.class);
            openDetailActivity.putExtra(NASA_OBJECT_KEY, nasaObject);
            startActivity(openDetailActivity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            ArrayList<NasaObject> nasaObjectArrayList = savedInstanceState.getParcelableArrayList(SAVED_ARRAY_KEY);
            nasaObjectList = nasaObjectArrayList;
            initializeRecyclerView(nasaObjectArrayList);
        } else {
            initializeRecyclerView(null);
            mainPresenter = new MainPresenter(new RequestData(), this);
            mainPresenter.requestDataFromNetwork();
        }


    }


    private void initializeRecyclerView(ArrayList<NasaObject> list) {
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            layoutManager = new LinearLayoutManager(MainActivity.this);
        } else {
            layoutManager = new GridLayoutManager(MainActivity.this, 2);
        }

        recyclerView.setLayoutManager(layoutManager);
        adapter = new NasaDataAdapter(list, new OnItemClickedListener());
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void setDataToAdapter(CollectionData collectionData) {
        ArrayList<CollectionItem> passedList = collectionData.getCollectionItemList();
        mainPresenter.convertToNasaObjectList(passedList);
        adapter.setData(nasaObjectList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onRequestFailed(Throwable throwable) {
        Toast.makeText(this,
                getString(R.string.error_message) + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void initiateNasaObjectList(ArrayList<NasaObject> list) {
        nasaObjectList = list;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(SAVED_ARRAY_KEY, nasaObjectList);
    }
}


