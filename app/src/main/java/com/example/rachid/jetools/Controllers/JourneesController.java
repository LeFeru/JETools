package com.example.rachid.jetools.Controllers;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rachid.jetools.Listeners.HttpResponseListener;
import com.example.rachid.jetools.Models.JourneesModel;
import com.example.rachid.jetools.Models.UtilisateurModel;
import com.example.rachid.jetools.Utils.HTTPUtils;
import com.example.rachid.jetools.Utils.RequestDto;
import com.owlike.genson.Genson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rachid on 12/05/17.
 */
public class JourneesController implements HttpResponseListener {

    private HttpResponseListener journeesModel;

    public JourneesController(HttpResponseListener journeesModel) {
        super();
        this.journeesModel = journeesModel;
    }

    public void getJournees(){
        Genson genson = new Genson();
        RequestDto req = new RequestDto();
        req.ajouterParam("req","getJournees");
        new AsyncHttpRequest(this).execute(req);
    }

    @Override
    public void onHttpResponse(String response) {
        this.journeesModel.onHttpResponse(response);
    }

    private class AsyncHttpRequest extends AsyncTask<RequestDto, Integer, String> {
        HttpResponseListener listener;
        public AsyncHttpRequest(HttpResponseListener listener){
            this.listener = listener;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(RequestDto... args) {
            RequestDto req = args[0];
            Log.i("req", req.toString());
            return HTTPUtils.performPostCall(req.getRequestUrl(),req.getRequestParams());
        }

        @Override
        protected void onPostExecute(String result) {
            listener.onHttpResponse(result);
        }
    }
}
