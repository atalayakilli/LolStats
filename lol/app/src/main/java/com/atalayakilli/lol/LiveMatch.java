package com.atalayakilli.lol;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.atalayakilli.lol.Adapters.LiveMatchAdapter;
import com.atalayakilli.lol.Models.Positions;
import com.atalayakilli.lol.Models.Tiers;
import com.atalayakilli.lol.RestApi.ManagerAll;
import com.atalayakilli.lol.denem.Deneme;
import com.atalayakilli.lol.denem.Participants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveMatch extends AppCompatActivity {
    List<Participants> list;
    List<Integer> sumIds = new ArrayList<>();
    List<Tiers> listTiers = new ArrayList<>();
    ListView listView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_match);
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
        istek2();

    }

    public void tanimla() {
        listView = findViewById(R.id.listViewLiveMatch);
    }

    public synchronized void istek2() {
        list = new ArrayList<>();
        Call<Deneme> denemeM = ManagerAll.getInstance().callDeneme();
        denemeM.enqueue(new Callback<Deneme>() {

            @Override
            public void onResponse(Call<Deneme> call, Response<Deneme> response) {

                if (response.isSuccessful()) {

                    list = response.body().getParticipants();
                    for (Participants item : list) {
                        sumIds.add(item.getSummonerId());
                    }

                    for (Integer item : sumIds) {
                        Call<List<Positions>> positionList = ManagerAll.getInstance().callPositionsForTier(item);
                        positionList.enqueue(new Callback<List<Positions>>() {
                            @Override
                            public void onResponse(Call<List<Positions>> call, Response<List<Positions>> response) {

                                if (response.isSuccessful()) {
                                    List<Positions> tier = new ArrayList<>();
                                    tier = response.body();

                                    for (Positions item : tier) {
                                        if (item.getQueueType().equals("RANKED_SOLO_5x5")) {
                                            Tiers tr = new Tiers();
                                            tr.setTier(item.getTier());
                                            tr.setRank(item.getRank());
                                            tr.setPoint(item.getLeaguePoints());
                                            listTiers.add(tr);
                                        }
                                    }
                                    Log.i("yenihata","liste"+listTiers.toString());
                                    if (listTiers.size() >= 10) {

                                        LiveMatchAdapter la = new LiveMatchAdapter(list,listTiers, getApplicationContext());
                                        listView.setAdapter(la);
                                    }

                                } else {
                                    Log.i("yenihata","hata kodu:2");

                                }
                            }

                            @Override
                            public void onFailure(Call<List<Positions>> call, Throwable t) {
                                Log.i("yenihata","hata kodu:3 :"+t);

                            }
                        });

                    }





                } else {
                    Log.i("yenihata","hata kodu:1");

                }
            }

            @Override
            public void onFailure(Call<Deneme> call, Throwable t) {
                Log.i("yenihata","hata kodu: satır 49"+t);
            }
        });

    }

}
