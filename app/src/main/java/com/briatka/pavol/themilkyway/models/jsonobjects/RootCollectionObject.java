package com.briatka.pavol.themilkyway.models.jsonobjects;


import com.google.gson.annotations.SerializedName;

//1. Root element

public class RootCollectionObject {


    @SerializedName("collection")
    private CollectionData collectionData;

    public CollectionData getCollectionData() {
        return collectionData;
    }

    public void setCollectionData(CollectionData collectionData) {
        this.collectionData = collectionData;
    }


}
