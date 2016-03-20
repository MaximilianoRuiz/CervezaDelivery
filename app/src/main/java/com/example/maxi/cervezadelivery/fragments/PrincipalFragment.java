package com.example.maxi.cervezadelivery.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.maxi.cervezadelivery.R;

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
        String list[] = {"Primero", "Segundo", "Tercero",};
        int[] toViews = {android.R.id.text1};
        lvBeers = (ListView) view.findViewById(R.id.lvBeers);
        lvBeers.setAdapter(new SimpleCursorAdapter(getContext(), android.R.layout.simple_list_item_1, null, list, toViews, 0));
    }
}
