package com.briatka.pavol.themilkyway.models.jsonobjects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//2. Child of the root element that returns a list of CollectionItem objects.

public class CollectionData {

    @SerializedName("items")
    private ArrayList<CollectionItem> collectionItemList;

    public ArrayList<CollectionItem> getCollectionItemList() {
        return collectionItemList;
    }

    public void setCollectionItemList(ArrayList<CollectionItem> collectionItemList) {
        this.collectionItemList = collectionItemList;
    }


}
