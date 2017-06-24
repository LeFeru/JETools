package com.example.rachid.jetools.ListAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.rachid.jetools.Models.JourneeModel;
import com.example.rachid.jetools.R;

import java.util.List;

/**
 * Created by rachid on 12/05/17.
 */
public class JourneeAdapter extends ArrayAdapter<JourneeModel> {

    //tweets est la liste des models à afficher
    public JourneeAdapter(Context context, List<JourneeModel> journees) {
        super(context, 0, journees);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_journee,parent, false);
        }

        JourneeViewHolder viewHolder = (JourneeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new JourneeViewHolder();
            viewHolder.journee = (TextView)convertView.findViewById(R.id.journee);
            viewHolder.number = (TextView)convertView.findViewById(R.id.number);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        JourneeModel journee = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.journee.setText(journee.getJournee());
        viewHolder.number.setText(journee.getNumber()+"");
        return convertView;
    }

    private class JourneeViewHolder{
        public TextView journee;
        public TextView number;
    }
}