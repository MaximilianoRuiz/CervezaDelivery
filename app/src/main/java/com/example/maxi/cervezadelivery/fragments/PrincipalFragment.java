package com.example.maxi.cervezadelivery.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.maxi.cervezadelivery.R;
import com.example.maxi.cervezadelivery.data.firebase.FirebaseBeer;
import com.example.maxi.cervezadelivery.data.firebase.FirebaseInterface;

/**
 * A placeholder fragment containing a simple view.
 */
public class PrincipalFragment extends Fragment {

    private ListView lvBeers;

    public PrincipalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        initWidgets(view);

        return view;
    }

    private void initWidgets(View view){
        lvBeers = (ListView) view.findViewById(R.id.lvBeers);

        addAdapters();
    }

    private void addAdapters() {
        FirebaseInterface firebaseInterface = new FirebaseBeer(getContext(), getResources());
        firebaseInterface.setListAdapter(lvBeers);

        addActionListeners();
    }

    private void addActionListeners() {

    }
}
