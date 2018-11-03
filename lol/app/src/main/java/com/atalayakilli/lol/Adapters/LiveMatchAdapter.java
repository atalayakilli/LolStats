package com.atalayakilli.lol.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atalayakilli.lol.ChampionInformation;
import com.atalayakilli.lol.LiveMatch;
import com.atalayakilli.lol.LiveMatchInfo;
import com.atalayakilli.lol.MainActivity;
import com.atalayakilli.lol.Models.Champions;
import com.atalayakilli.lol.Models.Positions;
import com.atalayakilli.lol.Models.Summoner;
import com.atalayakilli.lol.Models.Tiers;
import com.atalayakilli.lol.R;
import com.atalayakilli.lol.RestApi.ManagerAll;

import com.atalayakilli.lol.SummonerInfos;
import com.atalayakilli.lol.denem.Participants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveMatchAdapter extends BaseAdapter {
    ImageView imageLiveMatchTier;
    TextView txtLiveMatchTier;
    List<Participants> list;
    List<Tiers> listTiers;
    Context context;
    List<Champions> champion = ChampionInformation.fillChampions();
    public static int sumId = 0;
    Boolean control = true;
    public LiveMatchAdapter(List<Participants> list, List<Tiers> listTiers, Context context) {
        this.list = list;
        this.listTiers = listTiers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.livematchlayout, parent, false);
        LinearLayout linearLayout = convertView.findViewById(R.id.liveMatchLayout);
        TextView txtTeamName = convertView.findViewById(R.id.txtTeamName);
        TextView txtTeamName2 = convertView.findViewById(R.id.txtTeamName2);
        TextView txtLiveChampionName = convertView.findViewById(R.id.txtLiveChampionName);
        TextView txtLiveSummonerName = convertView.findViewById(R.id.txtLiveSummonerName);
        txtLiveMatchTier = convertView.findViewById(R.id.txtLiveMatchTier);

        imageLiveMatchTier = convertView.findViewById(R.id.imageLiveMatchTier);
        ImageView imageLiveChampion = convertView.findViewById(R.id.imageLiveChampion);
        ImageView imageSpell1 = convertView.findViewById(R.id.imageSpell1);
        ImageView imageSpell2 = convertView.findViewById(R.id.imageSpell2);
        ImageView imagePerkStyle = convertView.findViewById(R.id.imagePerkStyle);
        ImageView imagePerkSubStyle = convertView.findViewById(R.id.imagePerkSubStyle);
        ImageView imagePerk1 = convertView.findViewById(R.id.imagePerk1);
        ImageView imagePerk2 = convertView.findViewById(R.id.imagePerk2);
        ImageView imagePerk3 = convertView.findViewById(R.id.imagePerk3);
        ImageView imagePerk4 = convertView.findViewById(R.id.imagePerk4);
        ImageView imagePerk5 = convertView.findViewById(R.id.imagePerk5);
        ImageView imagePerk6 = convertView.findViewById(R.id.imagePerk6);
        if(list.get(position).getTeamId()==100){
            txtTeamName.setVisibility(View.VISIBLE);
            txtTeamName2.setVisibility(View.INVISIBLE);

        } else{
            txtTeamName.setVisibility(View.INVISIBLE);
            txtTeamName2.setVisibility(View.VISIBLE);

        }
        txtLiveChampionName.setText("" + championSelect(list.get(position).getChampionId()).getChampionName());
        txtLiveSummonerName.setText(list.get(position).getSummonerName());

        if (listTiers.get(position).getTier() != null) {
            Picasso.get().load("http://smartforkapps.xyz/tiers/" + listTiers.get(position).getTier() + "_" + listTiers.get(position).getRank() + ".png").into(imageLiveMatchTier);
            txtLiveMatchTier.setText("" + listTiers.get(position).getTier() + " " + listTiers.get(position).getRank()+" "+listTiers.get(position).getPoint()+"LP");

        } else {
            txtLiveMatchTier.setText("Unranked");
        }


        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championSelect(list.get(position).getChampionId()).getChampionPicture() + "_0.jpg").into(imageLiveChampion);
        Picasso.get().load("http://smartforkapps.xyz/spells/" + list.get(position).getSpell1Id() + ".png").into(imageSpell1);
        Picasso.get().load("http://smartforkapps.xyz/spells/" + list.get(position).getSpell2Id() + ".png").into(imageSpell2);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkStyle() + ".png").into(imagePerkStyle);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkSubStyle() + ".png").into(imagePerkSubStyle);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkIds().get(0) + ".png").into(imagePerk1);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkIds().get(1) + ".png").into(imagePerk2);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkIds().get(2) + ".png").into(imagePerk3);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkIds().get(3) + ".png").into(imagePerk4);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkIds().get(4) + ".png").into(imagePerk5);
        Picasso.get().load("http://smartforkapps.xyz/runes/" + list.get(position).getPerks().getPerkIds().get(5) + ".png").into(imagePerk6);



        return convertView;
    }

    public Champions championSelect(int id) {
        Champions cp = new Champions(0, "", "");
        for (Champions item : champion) {
            if (item.getChampionId() == id) {
                cp = item;
            } else {

            }
        }
        return cp;
    }




}
