package com.briatka.pavol.themilkyway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.model.CollectionData;
import com.briatka.pavol.themilkyway.model.RequestData;
import com.briatka.pavol.themilkyway.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new RequestData(),this);
        presenter.requestDataFromNetwork();
    }


    @Override
    public void setDataToAdapter(CollectionData collectionData) {
        String title = collectionData.getCollectionItemList()
                .get(1)
                .getUiDataObjectList()
                .get(0)
                .getTitle();

        Log.e("title",title);
    }

    @Override
    public void onRequestFailed(Throwable throwable) {
        Toast.makeText(this,
                getString(R.string.error_message) + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}
