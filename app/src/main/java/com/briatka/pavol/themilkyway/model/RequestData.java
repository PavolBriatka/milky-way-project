package com.briatka.pavol.themilkyway.model;

import com.briatka.pavol.themilkyway.clients.NasaDataClient;
import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestData implements MainContract.AccessData {

    @Override
    public void getCollectionData(final OnFinishedListener onFinishedListener) {

        NasaDataClient client = RetrofitInstance.getRetrofitInstance().create(NasaDataClient.class);
        Call<RootCollectionObject> call = client.getNasaData();

        call.enqueue(new Callback<RootCollectionObject>() {
            @Override
            public void onResponse(Call<RootCollectionObject> call, Response<RootCollectionObject> response) {
                onFinishedListener.onSuccessfulResponse(response.body().getCollectionData());
            }

            @Override
            public void onFailure(Call<RootCollectionObject> call, Throwable t) {
                onFinishedListener.onRequestFailed(t);

            }
        });

    }


}
