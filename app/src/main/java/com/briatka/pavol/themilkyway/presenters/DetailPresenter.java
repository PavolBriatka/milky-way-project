package com.briatka.pavol.themilkyway.presenters;

import android.content.Intent;

import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.models.customobjects.NasaObject;
import com.briatka.pavol.themilkyway.views.MainActivity;

public class DetailPresenter implements MainContract.DetailPresenter {

    private MainContract.DetailView detailView;

    public DetailPresenter(MainContract.DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void loadDataFromIntentExtras(Intent intent) {

        NasaObject nasaObject = intent.getParcelableExtra(MainActivity.NASA_OBJECT_KEY);
        detailView.updateUi(nasaObject);
    }
}
