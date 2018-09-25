package com.briatka.pavol.themilkyway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.briatka.pavol.themilkyway.clients.NasaDataClient;
import com.briatka.pavol.themilkyway.model.RootCollectionObject;
import com.briatka.pavol.themilkyway.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NasaDataClient client = RetrofitInstance.getRetrofitInstance().create(NasaDataClient.class);
        Call<RootCollectionObject> call = client.getNasaData();

        call.enqueue(new Callback<RootCollectionObject>() {
            @Override
            public void onResponse(Call<RootCollectionObject> call, Response<RootCollectionObject> response) {
                RootCollectionObject object = response.body();
                String uiDataObjectTitle = object.getCollectionData()
                        .getCollectionItemList()
                        .get(1).getUiDataObjectList().get(0).getTitle();

                Log.e("title", uiDataObjectTitle);
            }

            @Override
            public void onFailure(Call<RootCollectionObject> call, Throwable t) {

            }
        });
    }
}
