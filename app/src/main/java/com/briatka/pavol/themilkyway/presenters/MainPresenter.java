package com.briatka.pavol.themilkyway.presenters;

import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.models.customobjects.NasaObject;
import com.briatka.pavol.themilkyway.models.jsonobjects.CollectionData;
import com.briatka.pavol.themilkyway.models.jsonobjects.CollectionItem;
import com.briatka.pavol.themilkyway.models.jsonobjects.ImageLinkObject;
import com.briatka.pavol.themilkyway.models.jsonobjects.UiDataObject;

import java.util.ArrayList;

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
        view.showProgressBar();
    }

    @Override
    public void convertToNasaObjectList(ArrayList<CollectionItem> list) {
        ArrayList<NasaObject> nasaObjectList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CollectionItem item = list.get(i);
            UiDataObject uiDataObject = item.getUiDataObjectList().get(0);
            ImageLinkObject imageLinkObject = item.getImageLinkList().get(0);

            if (uiDataObject != null && imageLinkObject != null) {

                nasaObjectList.add(new NasaObject(uiDataObject.getTitle(),
                        uiDataObject.getCenter(),
                        uiDataObject.getDateCreated(),
                        uiDataObject.getDescription(),
                        imageLinkObject.getImageUrl()));
            }
        }
        view.initiateNasaObjectList(nasaObjectList);
    }

    @Override
    public void onSuccessfulResponse(CollectionData collectionData) {
        if (view != null) {
            view.setDataToAdapter(collectionData);
            view.hideProgressBar();
        }
    }

    @Override
    public void onRequestFailed(Throwable throwable) {
        if (view != null) {
            view.onRequestFailed(throwable);
            view.hideProgressBar();
        }

    }
}
