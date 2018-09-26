package com.briatka.pavol.themilkyway.presenters;

import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.models.jsonobjects.CollectionData;

public class MainPresenter implements MainContract.MainPresenter, MainContract.AccessData.OnFinishedListener {

    private MainContract.AccessData accessData;
    private MainContract.View view;

    public MainPresenter(MainContract.AccessData accessData, MainContract.View view) {
        this.accessData = accessData;
        this.view = view;
    }


    @Override
    public void requestDataFromNetwork() {

        accessData.getCollectionData(this);
    }

    @Override
    public void onSuccessfulResponse(CollectionData collectionData) {
        if(view != null){
            view.setDataToAdapter(collectionData);
        }
    }

    @Override
    public void onRequestFailed(Throwable throwable) {
        if(view != null) {
            view.onRequestFailed(throwable);
        }

    }
}
