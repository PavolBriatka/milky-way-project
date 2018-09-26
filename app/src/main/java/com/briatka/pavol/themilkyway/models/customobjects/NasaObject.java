package com.briatka.pavol.themilkyway.models.customobjects;

import android.os.Parcel;
import android.os.Parcelable;

public class NasaObject implements Parcelable {

    private String title;
    private String center;
    private String date;
    private String description;
    private String imgUrl;

    public NasaObject(String title, String center, String date, String description, String imgUrl) {
        this.title = title;
        this.center = center;
        this.date = date;
        this.description = description;
        this.imgUrl = imgUrl;
    }


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private NasaObject (Parcel parcel){
        title = parcel.readString();
        center = parcel.readString();
        date = parcel.readString();
        description = parcel.readString();
        imgUrl = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(center);
        parcel.writeString(date);
        parcel.writeString(description);
        parcel.writeString(imgUrl);
    }

    public static Parcelable.Creator<NasaObject> CREATOR = new Parcelable.Creator<NasaObject>() {
        @Override
        public NasaObject createFromParcel(Parcel parcel) {
            return new NasaObject(parcel);
        }

        @Override
        public NasaObject[] newArray(int i) {
            return new NasaObject[i];
        }
    };
}
