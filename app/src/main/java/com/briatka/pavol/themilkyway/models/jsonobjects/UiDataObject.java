package com.briatka.pavol.themilkyway.models.jsonobjects;

import com.google.gson.annotations.SerializedName;

//4. UiDataObject is the first core object that maps attributes that are shown in the app

public class UiDataObject {

    @SerializedName("title")
    private String title;
    @SerializedName("center")
    private String center;
    @SerializedName("date_created")
    private String dateCreated;
    @SerializedName("description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
