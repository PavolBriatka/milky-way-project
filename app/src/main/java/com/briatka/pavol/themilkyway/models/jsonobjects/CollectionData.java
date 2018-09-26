package com.briatka.pavol.themilkyway.models.jsonobjects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//2. Child of the root element that returns a list of CollectionItem objects.

public class CollectionData {

    @SerializedName("items")
    private List<CollectionItem> collectionItemList;

    public List<CollectionItem> getCollectionItemList() {
        return collectionItemList;
    }

    public void setCollectionItemList(List<CollectionItem> collectionItemList) {
        this.collectionItemList = collectionItemList;
    }


}
