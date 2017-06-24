package com.example.rachid.jetools.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rachid.jetools.Controllers.JourneesController;
import com.example.rachid.jetools.Models.JourneeModel;
import com.example.rachid.jetools.Models.JourneesModel;
import com.example.rachid.jetools.R;
import com.example.rachid.jetools.ListAdapters.JourneeAdapter;

import java.util.List;

/**
 * Created by rachid on 12/05/17.
 */
public class JourneesFragment extends Fragment {
    private ListView mListView;
    private JourneesModel journeesModel;
    private JourneesController journeesController;
    public static JourneesFragment newInstance(String title) {
        JourneesFragment fragment = new JourneesFragment();
        return fragment;
    }

    TextView title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.journeesModel = new JourneesModel();
        this.journeesController = new JourneesController(this.journeesModel);
        this.journeesController.getJournees();

        return inflater.inflate(R.layout.fragment_journees, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = (ListView) this.getActivity().findViewById(R.id.listView);

        List<JourneeModel> tweets = this.journeesModel.getJournees();

        JourneeAdapter adapter = new JourneeAdapter(this.getContext(), tweets);
        mListView.setAdapter(adapter);
    }
}