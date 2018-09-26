package com.briatka.pavol.themilkyway.models.jsonobjects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*3. CollectionItem represents a single item from the list of items. It contains main Ui data
 to be displayed and the URL of the image. Both, UI data and URL are structured in an array in
the JSON response */

public class CollectionItem {

    @SerializedName("data")
    private List<UiDataObject> uiDataObjectList;

    @SerializedName("links")
    private List<ImageLinkObject> imageLinkList;

    public List<UiDataObject> getUiDataObjectList() {
        return uiDataObjectList;
    }

    public void setUiDataObjectList(List<UiDataObject> uiDataObjectList) {
        this.uiDataObjectList = uiDataObjectList;
    }

    public List<ImageLinkObject> getImageLinkList() {
        return imageLinkList;
    }

    public void setImageLinkList(List<ImageLinkObject> imageLinkList) {
        this.imageLinkList = imageLinkList;
    }
}
