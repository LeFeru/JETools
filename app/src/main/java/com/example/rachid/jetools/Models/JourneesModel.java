package com.example.rachid.jetools.Models;

import android.util.Log;

import com.example.rachid.jetools.Listeners.HttpResponseListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rachid on 12/05/17.
 */
public class JourneesModel implements HttpResponseListener{

    private List<JourneeModel> je;
    public JourneesModel(){
        this.je = new ArrayList<>();
    }

    public List<JourneeModel> getJournees(){
        return this.je;
    }

    @Override
    public void onHttpResponse(String json) {
        Log.i("response",json);
        try {
            JSONArray journees = new JSONArray(json);
            for(int i = 0; i < journees.length(); i++){
                int id = journees.getJSONObject(i).getInt("idJournee");
                JSONObject dateJe = journees.getJSONObject(i).getJSONObject("dateJe");
                String date = dateJe.getString("dayOfMonth")+"/"+dateJe.getString("monthValue")+"/"+dateJe.getString("year");
                JourneeModel journee = new JourneeModel(date,id);
                je.add(journee);
            }
        }catch(Exception exception){
            Log.i("faill","onHttpResponse");
        }
    }

}
