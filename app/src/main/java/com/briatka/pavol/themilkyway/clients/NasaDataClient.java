package com.briatka.pavol.themilkyway.clients;

import com.briatka.pavol.themilkyway.models.jsonobjects.RootCollectionObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaDataClient {

    @GET("/search")
    Call<RootCollectionObject> getNasaData(@Query("q") String q,
                                           @Query("media_type") String media_type,
                                           @Query("year_start") String year_start,
                                           @Query("year_end") String year_end);


}
