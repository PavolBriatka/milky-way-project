package com.briatka.pavol.themilkyway.contracts;

import android.content.Intent;

import com.briatka.pavol.themilkyway.models.customobjects.NasaObject;
import com.briatka.pavol.themilkyway.models.jsonobjects.CollectionData;
import com.briatka.pavol.themilkyway.models.jsonobjects.CollectionItem;

import java.util.ArrayList;

public interface MainContract {

    interface View {
        void setDataToAdapter(CollectionData collectionData);

        void onRequestFailed(Throwable throwable);

        void showProgressBar();

        void hideProgressBar();

        void initiateNasaObjectList(ArrayList<NasaObject> list);
    }

    interface MainPresenter {
        void requestDataFromNetwork();

        void convertToNasaObjectList(ArrayList<CollectionItem> list);
    }

    interface DetailPresenter {
        void loadDataFromIntentExtras(Intent intent);
    }

    interface DetailView {
        void updateUi(NasaObject nasaObject);
    }

    interface AccessData {

        interface OnFinishedListener {
            void onSuccessfulResponse(CollectionData collectionData);

            void onRequestFailed(Throwable throwable);
        }

        void getCollectionData(OnFinishedListener onFinishedListener);
    }
}
