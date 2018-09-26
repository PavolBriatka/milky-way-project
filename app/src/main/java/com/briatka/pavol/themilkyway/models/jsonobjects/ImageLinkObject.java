package com.briatka.pavol.themilkyway.models.jsonobjects;

import com.google.gson.annotations.SerializedName;

//5.ImageLinkObjects is the second core element that returns the image URL.

public class ImageLinkObject {


    @SerializedName("href")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
