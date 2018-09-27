package com.briatka.pavol.themilkyway.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final String NASA_OBJECT_KEY = "nasa_object_key";
    private MainContract.MainPresenter mainPresenter;
    private NasaDataAdapter adapter;


    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public class OnItemClickedListener implements NasaDataAdapter.OnItemClickedListener {

        @Override
        public void onItemClicked(NasaObject nasaObject) {

            Intent openDetailActivity = new Intent(MainActivity.this,DetailActivity.class);
            openDetailActivity.putExtra(NASA_OBJECT_KEY, nasaObject);
            startActivity(openDetailActivity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeRecyclerView();

        mainPresenter = new MainPresenter(new RequestData(),this);
        mainPresenter.requestDataFromNetwork();
    }



    private void initializeRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NasaDataAdapter(null, new OnItemClickedListener());
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void setDataToAdapter(CollectionData collectionData) {
        List<CollectionItem> passedList = collectionData.getCollectionItemList();
        adapter.setData(passedList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRequestFailed(Throwable throwable) {
        Toast.makeText(this,
                getString(R.string.error_message) + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
