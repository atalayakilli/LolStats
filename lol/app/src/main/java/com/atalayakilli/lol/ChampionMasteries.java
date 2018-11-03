package com.atalayakilli.lol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.atalayakilli.lol.Adapters.MasteriesAdapter;
import com.atalayakilli.lol.Models.Masteries;
import com.atalayakilli.lol.RestApi.ManagerAll;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChampionMasteries extends AppCompatActivity {
    ListView listView;
    List<Masteries> list;
    TextView totalScore;
    int score = 0;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_masteries);
        /*AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(MainActivity.adsBanner);
        mAdView = findViewById(R.id.adViewSum);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if(!MainActivity.adsBanner.equals("0")){
            mAdView.setVisibility(View.VISIBLE);
        }*/
        tanimla();
        istek();
    }
    public void tanimla(){
        listView = findViewById(R.id.listView2);
        totalScore = findViewById(R.id.txtTotalScore);
    }
    public void istek(){
        list = new ArrayList<>();
        Call<List<Masteries>> masteriesList = ManagerAll.getInstance().callMasteries();
        masteriesList.enqueue(new Callback<List<Masteries>>() {
            @Override
            public void onResponse(Call<List<Masteries>> call, Response<List<Masteries>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    MasteriesAdapter adp = new MasteriesAdapter(list,getApplicationContext());
                    listView.setAdapter(adp);
                    for(Masteries item:list){

                        score = score + item.getChampionLevel();
                        totalScore.setText(""+score);
                    }


                } else{
                    Toast.makeText(ChampionMasteries.this, "Hata var 1. else", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Masteries>> call, Throwable t) {

            }
        });

    }
}
