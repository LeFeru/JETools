package com.example.rachid.jetools.Models;

import com.example.rachid.jetools.Listeners.HttpResponseListener;
import com.example.rachid.jetools.Listeners.UtilisateurModelChangeListener;
import com.owlike.genson.Genson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rachid on 9/05/17.
 */
public class UtilisateurModel implements HttpResponseListener {
    private int id;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private Date dateInscription;
    private String mdp;
    private String mdpConfirme;
    private boolean responsable;
    private int numVersion;
    private int nombreTentativesConnexions;
    private Date dateDerniereTentative;
    private UtilisateurModelChangeListener utilisateurModelChangeListener;

    public UtilisateurModel(int id, String pseudo, String nom, String prenom, String email,
                            Date dateInscription, String mdp, String mdpConfirme, boolean responsable,
                            int numVersion) {
        super();
        this.id = id;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateInscription = dateInscription;
        this.mdp = mdp;
        this.mdpConfirme = mdpConfirme;
        this.responsable = responsable;
        this.numVersion = numVersion;
        this.utilisateurModelChangeListener = null;
    }

    public String getMdpConfirme() {
        return mdpConfirme;
    }


    public void setMdpConfirme(String mdpConfirme) {
        this.mdpConfirme = mdpConfirme;
    }


    public UtilisateurModel() {
        super();
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Date getDateInscription() {
        return dateInscription;
    }


    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }


    public String getMdp() {
        return mdp;
    }


    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public boolean isResponsable() {
        return responsable;
    }


    public void setResponsable(boolean responsable) {
        this.responsable = responsable;
    }


    public String getPseudo() {
        return pseudo;
    }


    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    public int getNumVersion() {
        return this.numVersion;
    }


    public void setNumVersion(int numVersion) {
        this.numVersion = numVersion;
    }


    public String toString() {
        return "UtilisateurImpl [id=" + id + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
                + prenom + ", email=" + email + ", dateInscription=" + dateInscription + ", mdp=" + mdp
                + ", mdpConfirme=" + mdpConfirme + ", responsable=" + responsable + "]";
    }


    public int getNombreTentativesConnexions() {
        return this.nombreTentativesConnexions;
    }


    public void setNombreTentativesConnexions(int nbTentativesConnexions) {
        this.nombreTentativesConnexions = nbTentativesConnexions;
    }


    public Date getDateDerniereTentative() {
        return this.dateDerniereTentative;
    }


    public void setDateDerniereTentative(Date dateDerniereTentative) {
        this.dateDerniereTentative = dateDerniereTentative;
    }

    public void setUtilisateurDto(String utilisateur) {
        Map<String, Object> userJson = new HashMap<String, Object>();
        Genson genson =  new Genson();
        if (utilisateur != null) {
            userJson = genson.deserialize(utilisateur, Map.class);
        }
        else{
            return;
        }
        if (userJson.get("pseudo") != null) {
            this.setPseudo((String) userJson.get("pseudo"));
        }
        if (userJson.get("mdp") != null) {
            this.setMdp((String) userJson.get("mdp"));
        }
        if (userJson.get("confirmerMdp") != null) {
            this.setMdpConfirme((String) userJson.get("confirmerMdp"));
        }
        if (userJson.get("email") != null) {
            this.setEmail((String) userJson.get("email"));
        }
        if (userJson.get("nom") != null) {
            this.setNom((String) userJson.get("nom"));
        }
        if (userJson.get("prenom") != null) {
            this.setPrenom((String) userJson.get("prenom"));
        }
    }

    @Override
    public void onHttpResponse(String response) {
        setUtilisateurDto(response);
        this.utilisateurModelChangeListener.onUtilisateurModelChange();
    }

    public void addUtilisateurModelChangeListener(UtilisateurModelChangeListener listener){
        this.utilisateurModelChangeListener = listener;
    }
}
