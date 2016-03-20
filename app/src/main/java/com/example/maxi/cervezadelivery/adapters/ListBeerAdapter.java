package com.example.maxi.cervezadelivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxi.cervezadelivery.R;

import java.util.List;

public class ListBeerAdapter extends ArrayAdapter<String>{

    private Context context;
    private int resource;

    private ImageView ivBeerImage;
    private TextView tvBeerName, tvBeerPrice, tvBeerDescription;

    public ListBeerAdapter(Context context, int resource, List<String> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(resource, parent, false);

        initialWidgets(row);

        return row;
    }

    private void initialWidgets(View view) {
        ivBeerImage = (ImageView) view.findViewById(R.id.ivBeerImage);
        tvBeerName = (TextView) view.findViewById(R.id.tvBeerName);
        tvBeerPrice = (TextView) view.findViewById(R.id.tvBeerPrice);
        tvBeerDescription = (TextView) view.findViewById(R.id.tvBeerDescription);

    }
}
