package com.briatka.pavol.themilkyway.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.briatka.pavol.themilkyway.R;
import com.briatka.pavol.themilkyway.model.CollectionItem;
import com.briatka.pavol.themilkyway.model.UiDataObject;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NasaDataAdapter extends RecyclerView.Adapter<NasaDataAdapter.ViewHolder> {

    private List<CollectionItem> dataList;
    private final static String DIVIDER = " | ";

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.center)
        TextView center;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.item_image)
        ImageView itemImage;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);

        }
    }

    public NasaDataAdapter(List<CollectionItem> list){
        this.dataList = list;
    }

    @NonNull
    @Override
    public NasaDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NasaDataAdapter.ViewHolder viewHolder, int position) {

        CollectionItem currentItem = dataList.get(position);
        if(currentItem.getUiDataObjectList().size()==1){
            UiDataObject uiDataObject = currentItem.getUiDataObjectList().get(0);
            String itemTitle = uiDataObject.getTitle();
            String itemCenter = uiDataObject.getCenter() + DIVIDER;
            String itemDate = truncateDateString(uiDataObject.getDateCreated());

            viewHolder.title.setText(itemTitle);
            viewHolder.center.setText(itemCenter);
            viewHolder.date.setText(itemDate);

        }
        if(currentItem.getImageLinkList().size()==1){
            String imgUrl = currentItem.getImageLinkList().get(0).getImageUrl();
            Picasso.get().load(imgUrl).into(viewHolder.itemImage);

        }


    }

    @Override
    public int getItemCount() {
        return (dataList == null) ? 0 : dataList.size();
    }

    public void setData(List<CollectionItem> passedData){
        this.dataList = passedData;
        notifyDataSetChanged();
    }

    private String truncateDateString(String rawText){
        rawText = rawText.substring(0,10);
        return rawText;
    }
}
