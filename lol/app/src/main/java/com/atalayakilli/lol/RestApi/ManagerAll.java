package com.atalayakilli.lol.RestApi;


import com.atalayakilli.lol.Adapters.LiveMatchAdapter;
import com.atalayakilli.lol.MainActivity;
import com.atalayakilli.lol.Models.Ads;
import com.atalayakilli.lol.Models.ApiModel;
import com.atalayakilli.lol.Models.FreeRotation;
import com.atalayakilli.lol.Models.Masteries;
import com.atalayakilli.lol.Models.PlayedMatches;
import com.atalayakilli.lol.Models.Positions;
import com.atalayakilli.lol.Models.Summoner;
import com.atalayakilli.lol.SummonerInfos;
import com.atalayakilli.lol.denem.Deneme;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<Summoner> callSummoner() {
        Call<Summoner> call = getRestApiClient().summonerCall(MainActivity.sumName, ApiKey.api_key);
        return call;
    }

    public Call<List<Positions>> callPositions() {
        Call<List<Positions>> call = getRestApiClient().positionCall(SummonerInfos.summonerId, ApiKey.api_key);
        return call;
    }

    public Call<List<Positions>> callPositionsForTier(int sumId) {
        Call<List<Positions>> call = getRestApiClient().positionCall(sumId, ApiKey.api_key);
        return call;
    }

    public Call<List<Masteries>> callMasteries() {
        Call<List<Masteries>> call = getRestApiClient().masteriesCall(SummonerInfos.summonerId, ApiKey.api_key);
        return call;
    }

    public Call<FreeRotation> callRotation() {
        Call<FreeRotation> call = getRestApiClient().rotationCall(ApiKey.api_key);
        return call;
    }

    public Call<ApiModel> callApiKey() {
        Call<ApiModel> call = getRestApiClientKey().apiKeyCall();
        return call;
    }

    public Call<PlayedMatches> callPlayedMatches() {
        Call<PlayedMatches> call = getRestApiClient().playerMatchesCall(SummonerInfos.accountId, ApiKey.api_key);
        return call;
    }

    public Call<Deneme> callDeneme() {
        Call<Deneme> call = getRestApiClient().denemeCall(SummonerInfos.summonerId, ApiKey.api_key);
        return call;
    }
    public Call<Ads> callAds(){
        Call<Ads> call = getRestApiClientKey().adsCall();
        return call;
    }


}
