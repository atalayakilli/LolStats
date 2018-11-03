package com.atalayakilli.lol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.atalayakilli.lol.Adapters.LastPlayedAdapter;
import com.atalayakilli.lol.Models.MatchesItem;
import com.atalayakilli.lol.Models.PlayedMatches;
import com.atalayakilli.lol.RestApi.ManagerAll;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LastPlayed extends AppCompatActivity {
    PlayedMatches pl = new PlayedMatches();
    List<MatchesItem> list;
    ListView listView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_played);
       /* AdView adView = new AdView(this);
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
        listView = findViewById(R.id.listView3);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("debugata","2");
                Toast.makeText(LastPlayed.this, "asd"+list.get(position).getGameId(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void istek(){
       list = new ArrayList<>();
        Call<PlayedMatches> matchesList = ManagerAll.getInstance().callPlayedMatches();
        matchesList.enqueue(new Callback<PlayedMatches>() {
            @Override
            public void onResponse(Call<PlayedMatches> call, Response<PlayedMatches> response) {
                if(response.isSuccessful()){
                    pl = response.body();
                    list = pl.getMatches();
                    LastPlayedAdapter adp = new LastPlayedAdapter(list,getApplicationContext());
                    listView.setAdapter(adp);
                    Log.i("debugata","1");

                } else {
                    Toast.makeText(LastPlayed.this, "hata 1. else", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PlayedMatches> call, Throwable t) {
                Log.i("yenihata",""+t);
            }
        });
    }
}
