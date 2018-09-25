package com.briatka.pavol.themilkyway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.briatka.pavol.themilkyway.adapters.NasaDataAdapter;
import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.model.CollectionData;
import com.briatka.pavol.themilkyway.model.CollectionItem;
import com.briatka.pavol.themilkyway.model.RequestData;
import com.briatka.pavol.themilkyway.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;
    private NasaDataAdapter adapter;

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeRecyclerView();

        presenter = new MainPresenter(new RequestData(),this);
        presenter.requestDataFromNetwork();
    }

    private void initializeRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NasaDataAdapter(null);
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
}
