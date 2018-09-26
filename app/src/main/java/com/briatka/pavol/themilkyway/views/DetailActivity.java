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

    private MainContract.DetailPresenter detailPresenter;

    @BindView(R.id.action_up)
    ImageButton actionUpButton;
    @BindView(R.id.detail_image)
    ImageView detailImage;
    @BindView(R.id.detail_title)
    TextView detailTitle;
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

        Intent intent = getIntent();

        detailPresenter = new DetailPresenter(this);
        detailPresenter.loadDataFromIntentExtras(intent);

    }

    @Override
    public void updateUi(NasaObject nasaObject) {
        String imgUrl = nasaObject.getImgUrl();
        String title = nasaObject.getTitle();
        String description = nasaObject.getDescription();

        Picasso.get().load(imgUrl).into(detailImage);
        detailTitle.setText(title);
        detailDescription.setMovementMethod(LinkMovementMethod.getInstance());
        detailDescription.setText(Html.fromHtml(description));
    }
}
