package com.briatka.pavol.themilkyway.contracts;

import com.briatka.pavol.themilkyway.model.CollectionData;

public interface MainContract {

    
    interface AccessData {

        interface OnFinishedListener{
            void onSuccessfulResponse(CollectionData collectionData);
            void onRequestFailed(Throwable throwable);
        }

        void getCollectionData(OnFinishedListener onFinishedListener);
    }
}
