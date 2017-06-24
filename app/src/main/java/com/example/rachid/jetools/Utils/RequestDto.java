package com.example.rachid.jetools.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rachid on 2/05/17.
 */
public class RequestDto {

    private String requestUrl;
    private String route;
    private Map<String, String> requestParams;

    public RequestDto() {
        requestUrl = "http://10.0.2.2:8080/";
        requestParams = new HashMap<String, String>();
        route = "";
    }

    public RequestDto(String requestUrl, String route, Map<String, String> requestParams) {
        this.requestUrl = requestUrl;
        this.route = route;
        this.requestParams = requestParams;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }


    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
    }

    public void ajouterParam(String key, String val){
        requestParams.put(key,val);
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "requestUrl='" + requestUrl + '\'' +
                ", route='" + route + '\'' +
                ", requestParams=" + requestParams +
                '}';
    }
}
