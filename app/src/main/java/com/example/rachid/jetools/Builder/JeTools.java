package com.example.rachid.jetools.Builder;

import android.app.Application;

import com.example.rachid.jetools.Controllers.UtilisateurController;
import com.example.rachid.jetools.Models.UtilisateurModel;

import java.net.CookieHandler;
import java.net.CookieManager;

/**
 * Created by rachid on 2/05/17.
 */
public class JeTools extends Application {

    CookieManager cookieManager;
    UtilisateurController utilisateurController;
    UtilisateurModel utilisateurModel;

    {
        cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        utilisateurModel = new UtilisateurModel();
        utilisateurController = new UtilisateurController(utilisateurModel);

    }
    public CookieManager getCookieManager(){
        return this.cookieManager;
    }

    public UtilisateurModel getUtilisateurModel(){
        return this.utilisateurModel;
    }

    public UtilisateurController getUtilisateurController(){
        return this.utilisateurController;
    }

}
