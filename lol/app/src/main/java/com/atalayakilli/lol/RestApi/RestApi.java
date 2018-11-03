package com.atalayakilli.lol.RestApi;


import com.atalayakilli.lol.Models.Ads;
import com.atalayakilli.lol.Models.ApiModel;
import com.atalayakilli.lol.Models.FreeRotation;
import com.atalayakilli.lol.Models.Masteries;
import com.atalayakilli.lol.Models.PlayedMatches;
import com.atalayakilli.lol.Models.Positions;
import com.atalayakilli.lol.Models.Summoner;
import com.atalayakilli.lol.denem.Deneme;
import com.atalayakilli.lol.denem.Participants;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RestApi{

    @GET("summoner/v3/summoners/by-name/{user}")
    Call<Summoner> summonerCall( @Path("user") String user, @Query("api_key") String api_key);

    @GET("league/v3/positions/by-summoner/{summonerId}")
    Call<List<Positions>> positionCall(@Path("summonerId") long summonerId, @Query("api_key") String api_key);

    @GET("champion-mastery/v3/champion-masteries/by-summoner/{summonerId}")
    Call<List<Masteries>> masteriesCall(@Path("summonerId") long summonerId, @Query("api_key") String api_key);

    @GET("platform/v3/champion-rotations")
    Call<FreeRotation> rotationCall(@Query("api_key") String api_key);

    @GET("api_key.php")
    Call<ApiModel> apiKeyCall();

    @GET("match/v3/matchlists/by-account/{accountId}")
    Call<PlayedMatches> playerMatchesCall(@Path("accountId") long accountId, @Query("api_key") String api_key);

    @GET("spectator/v3/active-games/by-summoner/{summonerId}")
    Call<Deneme> denemeCall(@Path("summonerId") long summonerId, @Query("api_key") String api_key);

    @GET("lolstatsads.php")
    Call<Ads> adsCall();

}
