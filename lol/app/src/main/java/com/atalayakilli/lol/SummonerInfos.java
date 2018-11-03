package com.atalayakilli.lol;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.atalayakilli.lol.Adapters.PositionsAdapter;
import com.atalayakilli.lol.Models.Positions;
import com.atalayakilli.lol.RestApi.ManagerAll;
import com.atalayakilli.lol.denem.Deneme;
import com.atalayakilli.lol.denem.Participants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SummonerInfos extends AppCompatActivity {
    public static long summonerId;
    public static long accountId;
    ListView listView;
    List<Positions> list;
    TextView summonerNameTitle;
    TextView txtSummonerLevel;
    ImageView summonerIcon;
    int profileIcon;
    String summonerNameString;
    TextView revisionDate;
    String date;
    int summonerLevel;
    Button btnMasteries, btnLastPlayed, btnLive;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner_infos);
       /* AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(MainActivity.adsBanner);
        mAdView = findViewById(R.id.adViewSum);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if(!MainActivity.adsBanner.equals("0")){
            mAdView.setVisibility(View.VISIBLE);
        }*/
        Bundle bundle = getIntent().getExtras();
        summonerId = bundle.getLong("summonerId");
        accountId = bundle.getLong("accountId");
        profileIcon = bundle.getInt("profileIcon");
        summonerNameString = bundle.getString("summonerName");
        summonerLevel = bundle.getInt("summonerLevel");
        long epoch = bundle.getLong("epochTime");
        date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(epoch));
        tanimla();
        summonerInformations();
        tiklama();

        istek();

    }

    public void summonerInformations() {
        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/6.24.1/img/profileicon/" + profileIcon + ".png").into(summonerIcon);
        summonerNameTitle.setText(summonerNameString);
        revisionDate.setText(date);
        txtSummonerLevel.setText("" + summonerLevel);
    }



    public boolean networkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isAvailable() && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
    public void tiklama() {
        btnMasteries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!networkConnection()){
                    Toast.makeText(SummonerInfos.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                } else{
                    Intent ıntent = new Intent(SummonerInfos.this, ChampionMasteries.class);
                    startActivity(ıntent);
                }

            }
        });
        btnLastPlayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!networkConnection()){
                    Toast.makeText(SummonerInfos.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                } else{
                    Intent ıntent2 = new Intent(SummonerInfos.this, LastPlayed.class);
                    startActivity(ıntent2);
                }

            }
        });
        btnLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!networkConnection()){
                    Toast.makeText(SummonerInfos.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                } else{
                    final ProgressDialog dialog = new ProgressDialog(SummonerInfos.this);
                    dialog.setTitle("Wait");
                    dialog.setMessage("Loading data...");
                    dialog.setCancelable(false);
                    dialog.show();
                    Call<Deneme> control = ManagerAll.getInstance().callDeneme();
                    control.enqueue(new Callback<Deneme>() {
                        @Override
                        public void onResponse(Call<Deneme> call, Response<Deneme> response) {

                            if (response.body()!=null) {
                                dialog.cancel();
                                Intent ıntent = new Intent(SummonerInfos.this, LiveMatch.class);
                                startActivity(ıntent);
                            } else {
                                dialog.cancel();
                                Toast.makeText(SummonerInfos.this, "Summoner " + summonerNameString + " is not in a active game.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Deneme> call, Throwable t) {
                            dialog.cancel();
                            Toast.makeText(SummonerInfos.this, "Summoner " + summonerNameString + " is not in a active game.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });
    }

    public void tanimla() {
        btnLastPlayed = findViewById(R.id.btnLastPlayed);
        btnMasteries = findViewById(R.id.btnMasteries);
        revisionDate = findViewById(R.id.txtRevisionDate);
        listView = findViewById(R.id.listView);
        summonerNameTitle = findViewById(R.id.txtSummonerNameTitle);
        summonerIcon = findViewById(R.id.imageSummonerIcon);
        txtSummonerLevel = findViewById(R.id.txtSummonerLevel);
        btnLive = findViewById(R.id.btnLiveMatch);
    }

    public void istek() {
        list = new ArrayList<>();
        Call<List<Positions>> positionList = ManagerAll.getInstance().callPositions();
        positionList.enqueue(new Callback<List<Positions>>() {
            @Override
            public void onResponse(Call<List<Positions>> call, Response<List<Positions>> response) {
                if (response.isSuccessful()) {
                    list = response.body();


                    PositionsAdapter adp = new PositionsAdapter(list, getApplicationContext());
                    listView.setAdapter(adp);
                } else {
                    Toast.makeText(SummonerInfos.this, "Hata var 1. else", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Positions>> call, Throwable t) {
                Log.i("atalay1", "" + t);
            }
        });
    }
}
