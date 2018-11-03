package com.atalayakilli.lol.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atalayakilli.lol.Models.Champions;
import com.atalayakilli.lol.Models.Positions;
import com.atalayakilli.lol.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PositionsAdapter extends BaseAdapter {
    List<Positions> list;
    Context context;


    public PositionsAdapter(List<Positions> list, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.summonerinfo,parent,false);

        ImageView imgTier = convertView.findViewById(R.id.imageTier);

        TextView leagueName = convertView.findViewById(R.id.txtLeagueName);
        TextView tier = convertView.findViewById(R.id.txtTier);
        TextView leaguePoints = convertView.findViewById(R.id.txtLeaguePoints);
        TextView queueType = convertView.findViewById(R.id.txtQueueType);
        TextView wins = convertView.findViewById(R.id.txtWins);
        TextView losses = convertView.findViewById(R.id.txtLosses);
        TextView situation = convertView.findViewById(R.id.txtSituation);

        String tierImagePath = "http://smartforkapps.xyz/tiers/"+list.get(position).getTier()+"_"+list.get(position).getRank()+".png";

        Picasso.get().load(tierImagePath).into(imgTier);


        leagueName.setText(list.get(position).getLeagueName());

        String tierFull = list.get(position).getTier()+" "+list.get(position).getRank();
        tier.setText(tierFull);

        leaguePoints.setText(""+list.get(position).getLeaguePoints());

        String situationControl="";
        if(list.get(position).isVeteran()){
            situationControl="Veteran";
        }
        else if(list.get(position).isFreshBlood()){
            situationControl="Freshblood";
        }
        else if(list.get(position).isHotStreak()){
            situationControl="Hot Streak";
        }
        else if(list.get(position).isInactive()){
            situationControl="Inactive";
        }
        situation.setText(situationControl);

        wins.setText(""+list.get(position).getWins());
        losses.setText(""+list.get(position).getLosses());

        String queueString ="";
        if(list.get(position).getQueueType().equals("RANKED_SOLO_5x5")){
            queueString="Ranked Solo 5x5";
        }
        else if(list.get(position).getQueueType().equals("RANKED_FLEX_SR")){
            queueString="Ranked Flex 5x5";
        }
        queueType.setText(queueString);


        return convertView;
    }

}
