package com.example.maxi.cervezadelivery.data.firebase;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ListView;

import com.example.maxi.cervezadelivery.R;
import com.example.maxi.cervezadelivery.adapters.ListBeerAdapter;
import com.example.maxi.cervezadelivery.vo.Beer;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseBeer implements FirebaseInterface {

    public static final String CHILD_BEER = "Beer";

    private String URL;
    private Context context;

    private List<Object> beers;

    public FirebaseBeer(Context context, Resources resources) {
        this.URL = resources.getString(R.string.beer);
        this.context = context;
    }

    @Override
    public void setListAdapter(final ListView listView) {
        Firebase beerFireBaseObject = new Firebase(URL);

        beers = new ArrayList<>();

        beerFireBaseObject.child(CHILD_BEER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshots) {

                for (DataSnapshot snapshot : snapshots.getChildren()) {
                    Beer beer = snapshot.getValue(Beer.class);
                    beers.add(beer);
                }
                listView.setAdapter(new ListBeerAdapter(context, R.layout.adapter_list_beer, beers));
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
    }
}
