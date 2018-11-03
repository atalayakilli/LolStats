package com.atalayakilli.lol;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.atalayakilli.lol.Models.Ads;
import com.atalayakilli.lol.Models.ApiModel;
import com.atalayakilli.lol.Models.Summoner;
import com.atalayakilli.lol.RestApi.ApiKey;
import com.atalayakilli.lol.RestApi.BaseUrl;
import com.atalayakilli.lol.RestApi.ManagerAll;
import com.atalayakilli.lol.denem.Deneme;
import com.atalayakilli.lol.denem.Participants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnSearch;
    EditText editSummonerName;
    ImageButton cancelButton;
    Summoner summoner = new Summoner();
    TextView deneme;
    Spinner spinnerLegion;
    String legions[] = {"TR", "EUW", "NA", "EUN", "BR", "RU", "OC", "LA1", "LA2", "KR", "JP"};
    ArrayAdapter arrayAdapter;
    ApiModel ap = new ApiModel();
    public static String sumName;
    public static String religionName = "tr1";
    public static String adsBanner;
    public static String adsGecis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deneme = findViewById(R.id.txtDeneme);
        deneme.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        deneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!networkConnection()) {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                } else {
                    Intent ıntent = new Intent(MainActivity.this, ChampionRotations.class);
                    startActivity(ıntent);
                }

            }
        });
        istekAds();
        tanimla();
        arrayAdapterTanimla();
        tiklama();
        istekKey();
        silme();
    }

    public void arrayAdapterTanimla() {
        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, legions);
        spinnerLegion.setAdapter(arrayAdapter);
        spinnerLegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void tanimla() {
        btnSearch = findViewById(R.id.btnSearch);
        editSummonerName = findViewById(R.id.editSummonerName);
        spinnerLegion = findViewById(R.id.spinnerLegion);
        cancelButton = findViewById(R.id.cancelButton);

    }

    public void silme() {

        editSummonerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cancelButton.setImageResource(R.drawable.ic_cancel_black_24dp);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSummonerName.setText("");
                editSummonerName.requestFocus();
                cancelButton.setImageResource(R.drawable.ic_search_black_24dp);

            }
        });

    }

    public void tiklama() {

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!networkConnection()) {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                } else {
                    if (editSummonerName.getText().toString().trim().equals("")) {
                        editSummonerName.setError("Please enter a summoner name!");

                        silme();
                    } else {
                        if (spinnerLegion.getSelectedItem().equals("TR")) {
                            religionName = "tr1";
                        } else if (spinnerLegion.getSelectedItem().equals("RU")) {
                            religionName = "ru";

                        } else if (spinnerLegion.getSelectedItem().equals("KR")) {
                            religionName = "kr";

                        } else if (spinnerLegion.getSelectedItem().equals("BR")) {
                            religionName = "br1";

                        } else if (spinnerLegion.getSelectedItem().equals("OC")) {
                            religionName = "oc1";

                        } else if (spinnerLegion.getSelectedItem().equals("JP")) {
                            religionName = "jp1";

                        } else if (spinnerLegion.getSelectedItem().equals("NA")) {
                            religionName = "na1";

                        } else if (spinnerLegion.getSelectedItem().equals("EUN")) {
                            religionName = "eun1";

                        } else if (spinnerLegion.getSelectedItem().equals("EUW")) {
                            religionName = "euw1";

                        } else if (spinnerLegion.getSelectedItem().equals("LA1")) {
                            religionName = "la1";

                        } else {
                            religionName = "la2";
                        }
                        BaseUrl.url = "https://" + religionName + ".api.riotgames.com/lol/";
                        silme();
                        istek();
                    }
                }


            }
        });

    }

    public boolean networkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isAvailable() && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void istek() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Wait");
        dialog.setMessage("Loading data...");
        dialog.setCancelable(false);
        dialog.show();
        sumName = editSummonerName.getText().toString();

        Call<Summoner> summonerInfo = ManagerAll.getInstance().callSummoner();
        summonerInfo.enqueue(new Callback<Summoner>() {
            @Override
            public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                if (response.isSuccessful()) {
                    summoner = response.body();


                    Intent ıntent = new Intent(getApplicationContext(), SummonerInfos.class);
                    ıntent.putExtra("summonerId", summoner.getId());
                    ıntent.putExtra("profileIcon", summoner.getProfileIconId());
                    ıntent.putExtra("summonerLevel", summoner.getSummonerLevel());
                    ıntent.putExtra("summonerName", summoner.getName());
                    ıntent.putExtra("epochTime", summoner.getRevisionDate());
                    ıntent.putExtra("accountId", summoner.getAccountId());

                    dialog.cancel();
                    startActivity(ıntent);

                } else {
                    dialog.cancel();
                    Toast.makeText(MainActivity.this, "Summoner '" + editSummonerName.getText().toString() + "' not available in this region", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Summoner> call, Throwable t) {

            }
        });


    }

    public void istekKey() {

        Call<ApiModel> apiKey = ManagerAll.getInstance().callApiKey();
        apiKey.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                if (response.isSuccessful()) {
                    ap = response.body();

                    ApiKey.api_key = ap.getApikey();
                }
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {

            }
        });

    }

    public void istekAds() {
        Call<Ads> ads = ManagerAll.getInstance().callAds();
        ads.enqueue(new Callback<Ads>() {
            @Override
            public void onResponse(Call<Ads> call, Response<Ads> response) {
                if (response.isSuccessful()) {
                    adsBanner = response.body().getBanner();
                    adsGecis = response.body().getGecis();

                } else {
                    Toast.makeText(MainActivity.this, "Reklam id getirme hatası", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Ads> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
