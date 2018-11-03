package com.atalayakilli.lol.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atalayakilli.lol.ChampionInformation;
import com.atalayakilli.lol.Models.Champions;
import com.atalayakilli.lol.Models.Masteries;
import com.atalayakilli.lol.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MasteriesAdapter extends BaseAdapter {
    List<Masteries> list;
    Context context;
    List<Champions> summoner = ChampionInformation.fillChampions();
    public MasteriesAdapter(List<Masteries> list, Context context) {
        this.list = list;
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

        convertView = LayoutInflater.from(context).inflate(R.layout.masterieslayout,parent,false);

        TextView championId = convertView.findViewById(R.id.txtChampionId);
        TextView championLevel = convertView.findViewById(R.id.txtChampionLevel);
        TextView championPoints = convertView.findViewById(R.id.txtChampionPoints);
        TextView lastPlayTime = convertView.findViewById(R.id.txtLastPlayTime);
        TextView championPointsSinceLastLevel = convertView.findViewById(R.id.txtChampionPointsSinceLastLevel);
        TextView championPointsUntilNextLevel = convertView.findViewById(R.id.txtChampionPointsUntilNextLevel);
        ImageView chestGranted = convertView.findViewById(R.id.imageChest);
        TextView tokensEarned = convertView.findViewById(R.id.txtTokensEarned);
        ImageView championIcon = convertView.findViewById(R.id.imageChampionIcon);
        LinearLayout borderLayout = convertView.findViewById(R.id.borderLayout);

        if(list.get(position).getChampionLevel()==1){
            borderLayout.setBackgroundResource(R.drawable.border1);
        } else if(list.get(position).getChampionLevel()==2){
            borderLayout.setBackgroundResource(R.drawable.border2);
        } else if(list.get(position).getChampionLevel()==3){
            borderLayout.setBackgroundResource(R.drawable.border3);
        } else if(list.get(position).getChampionLevel()==4){
            borderLayout.setBackgroundResource(R.drawable.border4);
        } else if(list.get(position).getChampionLevel()==5){
            borderLayout.setBackgroundResource(R.drawable.border5);
        } else if(list.get(position).getChampionLevel()==6){
            borderLayout.setBackgroundResource(R.drawable.border6);
        } else if(list.get(position).getChampionLevel()==7){
            borderLayout.setBackgroundResource(R.drawable.border7);
        } else{
            borderLayout.setBackgroundResource(R.drawable.deneme);
        }

      championId.setText(""+championSelect(list.get(position).getChampionId()).getChampionName());
        championLevel.setText(""+list.get(position).getChampionLevel());
        championPoints.setText(""+list.get(position).getChampionPoints());

        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date (list.get(position).getLastPlayTime()));
        lastPlayTime.setText(date);

        championPointsSinceLastLevel.setText(""+list.get(position).getChampionPointsSinceLastLevel());
        championPointsUntilNextLevel.setText(""+list.get(position).getChampionPointsUntilNextLevel());
        if(list.get(position).isChestGranted()){
            Picasso.get().load("http://smartforkapps.xyz/tiers/true.png").into(chestGranted);
        } else{
            Picasso.get().load("http://smartforkapps.xyz/tiers/false.png").into(chestGranted);
        }
        tokensEarned.setText(""+list.get(position).getTokensEarned());

        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/"+championSelect(list.get(position).getChampionId()).getChampionPicture()+".png").into(championIcon);

        return convertView;
    }

    public Champions championSelect(int id){
        Champions cp = new Champions(0,"","");
        for(Champions item:summoner){
            if(item.getChampionId()==id){
                cp = item;
            } else{

            }
        }
        return cp;
    }
}
