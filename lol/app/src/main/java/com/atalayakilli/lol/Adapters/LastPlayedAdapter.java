package com.atalayakilli.lol.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atalayakilli.lol.ChampionInformation;
import com.atalayakilli.lol.LiveMatchInfo;
import com.atalayakilli.lol.Models.Champions;
import com.atalayakilli.lol.Models.MatchesItem;
import com.atalayakilli.lol.R;
import com.atalayakilli.lol.SummonerInfos;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class LastPlayedAdapter extends BaseAdapter {
    List<MatchesItem> list;
    Context context;
    List<Champions> summoner = ChampionInformation.fillChampions();

    public LastPlayedAdapter(List<MatchesItem> list, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.playedmatches,parent,false);
        LinearLayout linearLayout = convertView.findViewById(R.id.liveMatchLayout);
        TextView txtPlatformId = convertView.findViewById(R.id.txtPlatformId);
        TextView txtLane = convertView.findViewById(R.id.txtLane);
        TextView txtTimeStamp = convertView.findViewById(R.id.txtTimeStamp);
        ImageView imgChampiom = convertView.findViewById(R.id.imageChampion);

        Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/"+championSelect(list.get(position).getChampion()).getChampionPicture()+".png").into(imgChampiom);

        txtPlatformId.setText(championSelect(list.get(position).getChampion()).getChampionName());
        txtLane.setText(list.get(position).getLane());
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date (list.get(position).getTimestamp()));
        txtTimeStamp.setText(date);


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
