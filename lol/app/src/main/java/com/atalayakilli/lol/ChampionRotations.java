package com.atalayakilli.lol;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.atalayakilli.lol.Models.Champions;
import com.atalayakilli.lol.Models.FreeRotation;
import com.atalayakilli.lol.RestApi.ManagerAll;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChampionRotations extends AppCompatActivity {
    List<Champions> listC = ChampionInformation.fillChampions();
    ImageView free1, free2, free3, free4, free5, free6, free7, free8, free9, free10, free11, free12, free13, free14;
    TextView txtFailure, txtFree1, txtFree2, txtFree3, txtFree4, txtFree5, txtFree6, txtFree7, txtFree8, txtFree9, txtFree10, txtFree11, txtFree12, txtFree13, txtFree14;
    FreeRotation freeRotation = new FreeRotation();
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_rotations);
        /*AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(MainActivity.adsBanner);
        mAdView = findViewById(R.id.adViewSum);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if(!MainActivity.adsBanner.equals("0")){
            mAdView.setVisibility(View.VISIBLE);
        }*/
        final ProgressDialog dialog = new ProgressDialog(ChampionRotations.this);
        dialog.setTitle("Wait");
        dialog.setMessage("Loading data...");
        dialog.setCancelable(false);
        dialog.show();
        tanimla();
        istek();
        dialog.cancel();

    }

    public void istek() {

        Call<FreeRotation> rotation = ManagerAll.getInstance().callRotation();
        rotation.enqueue(new Callback<FreeRotation>() {
            @Override
            public void onResponse(Call<FreeRotation> call, Response<FreeRotation> response) {
                if (response.isSuccessful()) {
                    freeRotation = response.body();

                    setImage();

                }
            }

            @Override
            public void onFailure(Call<FreeRotation> call, Throwable t) {
                txtFailure.setText("" + t);


            }

        });


    }

    public Champions championSelect(int id) {
        Champions cp = new Champions(0, "", "");
        for (Champions item : listC) {
            if (item.getChampionId() == id) {
                cp = item;
            } else {

            }
        }
        return cp;
    }

    public void tanimla() {
        free1 = findViewById(R.id.imageFree1);
        free2 = findViewById(R.id.imageFree2);
        free3 = findViewById(R.id.imageFree3);
        free4 = findViewById(R.id.imageFree4);
        free5 = findViewById(R.id.imageFree5);
        free6 = findViewById(R.id.imageFree6);
        free7 = findViewById(R.id.imageFree7);
        free8 = findViewById(R.id.imageFree8);
        free9 = findViewById(R.id.imageFree9);
        free10 = findViewById(R.id.imageFree10);
        free11 = findViewById(R.id.imageFree11);
        free12 = findViewById(R.id.imageFree12);
        free13 = findViewById(R.id.imageFree13);
        free14 = findViewById(R.id.imageFree14);
        txtFree1 = findViewById(R.id.txtFree1);
        txtFree2 = findViewById(R.id.txtFree2);
        txtFree3 = findViewById(R.id.txtFree3);
        txtFree4 = findViewById(R.id.txtFree4);
        txtFree5 = findViewById(R.id.txtFree5);
        txtFree6 = findViewById(R.id.txtFree6);
        txtFree7 = findViewById(R.id.txtFree7);
        txtFree8 = findViewById(R.id.txtFree8);
        txtFree9 = findViewById(R.id.txtFree9);
        txtFree10 = findViewById(R.id.txtFree10);
        txtFree11 = findViewById(R.id.txtFree11);
        txtFree12 = findViewById(R.id.txtFree12);
        txtFree13 = findViewById(R.id.txtFree13);
        txtFree14 = findViewById(R.id.txtFree14);


        txtFailure = findViewById(R.id.txtFailure);
    }

    public void setImage() {

        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(0)).getChampionPicture() + "_0.jpg").into(free1);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(1)).getChampionPicture() + "_0.jpg").into(free2);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(2)).getChampionPicture() + "_0.jpg").into(free3);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(3)).getChampionPicture() + "_0.jpg").into(free4);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(4)).getChampionPicture() + "_0.jpg").into(free5);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(5)).getChampionPicture() + "_0.jpg").into(free6);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(6)).getChampionPicture() + "_0.jpg").into(free7);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(7)).getChampionPicture() + "_0.jpg").into(free8);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(8)).getChampionPicture() + "_0.jpg").into(free9);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(9)).getChampionPicture() + "_0.jpg").into(free10);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(10)).getChampionPicture() + "_0.jpg").into(free11);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(11)).getChampionPicture() + "_0.jpg").into(free12);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(12)).getChampionPicture() + "_0.jpg").into(free13);
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(freeRotation.getFreeChampionIds().get(13)).getChampionPicture() + "_0.jpg").into(free14);
        txtFree1.setText(championSelect(freeRotation.getFreeChampionIds().get(0)).getChampionName());
        txtFree2.setText(championSelect(freeRotation.getFreeChampionIds().get(1)).getChampionName());
        txtFree3.setText(championSelect(freeRotation.getFreeChampionIds().get(2)).getChampionName());
        txtFree4.setText(championSelect(freeRotation.getFreeChampionIds().get(3)).getChampionName());
        txtFree5.setText(championSelect(freeRotation.getFreeChampionIds().get(4)).getChampionName());
        txtFree6.setText(championSelect(freeRotation.getFreeChampionIds().get(5)).getChampionName());
        txtFree7.setText(championSelect(freeRotation.getFreeChampionIds().get(6)).getChampionName());
        txtFree8.setText(championSelect(freeRotation.getFreeChampionIds().get(7)).getChampionName());
        txtFree9.setText(championSelect(freeRotation.getFreeChampionIds().get(8)).getChampionName());
        txtFree10.setText(championSelect(freeRotation.getFreeChampionIds().get(9)).getChampionName());
        txtFree11.setText(championSelect(freeRotation.getFreeChampionIds().get(10)).getChampionName());
        txtFree12.setText(championSelect(freeRotation.getFreeChampionIds().get(11)).getChampionName());
        txtFree13.setText(championSelect(freeRotation.getFreeChampionIds().get(12)).getChampionName());
        txtFree14.setText(championSelect(freeRotation.getFreeChampionIds().get(13)).getChampionName());

    }
}
