package com.example.rachid.jetools.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rachid.jetools.Fragments.JourneesFragment;
import com.example.rachid.jetools.R;

/**
 * Created by rachid on 12/05/17.
 */
public class JourneesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journees);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout,new JourneesFragment())
                .commit();
    }

}