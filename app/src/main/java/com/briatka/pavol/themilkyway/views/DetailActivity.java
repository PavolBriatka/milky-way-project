package com.briatka.pavol.themilkyway.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.briatka.pavol.themilkyway.R;
import com.briatka.pavol.themilkyway.contracts.MainContract;
import com.briatka.pavol.themilkyway.models.customobjects.NasaObject;
import com.briatka.pavol.themilkyway.presenters.DetailPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements MainContract.DetailView {

    private static final String SAVED_OBJECT_KEY = "saved_object";
    private MainContract.DetailPresenter detailPresenter;
    private NasaObject nasaObjectData;

    @BindView(R.id.action_up)
    ImageButton actionUpButton;
    @BindView(R.id.detail_image)
    ImageView detailImage;
    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.detail_center)
    TextView detailCenter;
    @BindView(R.id.detail_date)
    TextView detailDate;
    @BindView(R.id.detail_description)
    TextView detailDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        actionUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSupportNavigateUp();
            }
        });

        if (savedInstanceState != null) {
            NasaObject savedObject = savedInstanceState.getParcelable(SAVED_OBJECT_KEY);
            updateUi(savedObject);
        } else {
            Intent intent = getIntent();
            detailPresenter = new DetailPresenter(this);
            detailPresenter.loadDataFromIntentExtras(intent);
        }


    }

    @Override
    public void updateUi(NasaObject nasaObject) {
        nasaObjectData = nasaObject;
        String imgUrl = nasaObject.getImgUrl();
        String title = nasaObject.getTitle();
        String center = nasaObject.getCenter();
        String date = nasaObject.getDate();
        String description = nasaObject.getDescription();

        Picasso.get().load(imgUrl).into(detailImage);
        detailTitle.setText(title);
        detailCenter.setText(Html.fromHtml(getString(R.string.detail_center, center)));
        detailDate.setText(Html.fromHtml(getString(R.string.detail_date, date)));
        detailDescription.setMovementMethod(LinkMovementMethod.getInstance());
        detailDescription.setText(Html.fromHtml(description));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_OBJECT_KEY, nasaObjectData);
    }
}
