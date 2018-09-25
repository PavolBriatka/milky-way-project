package com.briatka.pavol.themilkyway.clients;

import com.briatka.pavol.themilkyway.model.RootCollectionObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NasaDataClient {

    @GET("/search?q=milky%20way&media_type=image&year_start=2017&year_end=2017")
    Call<RootCollectionObject> getNasaData();


}
