package com.briatka.pavol.themilkyway.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.briatka.pavol.themilkyway.R;
import com.briatka.pavol.themilkyway.models.customobjects.NasaObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NasaDataAdapter extends RecyclerView.Adapter<NasaDataAdapter.ViewHolder> {

    private ArrayList<NasaObject> dataList;
    private final static String DIVIDER = " | ";
    private OnItemClickedListener onItemClickedListener;

    public interface OnItemClickedListener {
        void onItemClicked(NasaObject nasaObject);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.center)
        TextView center;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.item_image)
        ImageView itemImage;
        @BindView(R.id.list_item_gradient)
        View gradientView;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);

        }
    }

    public NasaDataAdapter(ArrayList<NasaObject> list, OnItemClickedListener listener){
        this.dataList = list;
        this.onItemClickedListener = listener;
    }

    @NonNull
    @Override
    public NasaDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NasaDataAdapter.ViewHolder viewHolder, int position) {

        final NasaObject currentItem = dataList.get(position);


            String itemTitle = currentItem.getTitle();
            String itemCenter = currentItem.getCenter() + DIVIDER;
            String itemDate = truncateDateString(currentItem.getDate());

            viewHolder.gradientView.setVisibility(View.VISIBLE);
            viewHolder.title.setText(itemTitle);
            viewHolder.center.setText(itemCenter);
            viewHolder.date.setText(itemDate);


            String imgUrl = currentItem.getImgUrl();
            Picasso.get()
                    .load(imgUrl)
                    .placeholder(R.drawable.ic_image_grey)
                    .error(R.drawable.ic_broken_image_grey)
                    .into(viewHolder.itemImage);



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onItemClickedListener.onItemClicked(currentItem);
            }
        });


    }

    @Override
    public int getItemCount() {
        return (dataList == null) ? 0 : dataList.size();
    }

    public void setData(ArrayList<NasaObject> passedData){
        this.dataList = passedData;
        notifyDataSetChanged();
    }

    private String truncateDateString(String rawText){
        rawText = rawText.substring(0,10);
        return rawText;
    }
}
