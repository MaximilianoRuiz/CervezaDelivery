package com.example.maxi.cervezadelivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxi.cervezadelivery.R;
import com.example.maxi.cervezadelivery.vo.Beer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListBeerAdapter extends ArrayAdapter<Object>{

    private Context context;
    private int resource;
    private List<Object> beers;
    private ViewHolder viewHolder;

    public ListBeerAdapter(Context context, int resource, List<Object> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.beers = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new ViewHolder();

            initialWidgets(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Beer beer = (Beer) beers.get(position);

        if (beer != null) {
            addNewRow(beer);
        }

        return convertView;
    }

    private void initialWidgets(View view) {
        viewHolder.ivBeerImage = (ImageView) view.findViewById(R.id.ivBeerImage);
        viewHolder.tvBeerName = (TextView) view.findViewById(R.id.tvBeerName);
        viewHolder.tvBeerPrice = (TextView) view.findViewById(R.id.tvBeerPrice);
        viewHolder.tvBeerDescription = (TextView) view.findViewById(R.id.tvBeerDescription);

    }

    private void addNewRow(Beer beer) {
        Picasso.with(context).load(beer.getImage()).into(viewHolder.ivBeerImage);
        viewHolder.tvBeerName.setText(beer.getName());
        viewHolder.tvBeerDescription.setText(beer.getDescription());
        viewHolder.tvBeerPrice.setText(beer.getPrice());
    }

    static class ViewHolder {
        private ImageView ivBeerImage;
        private TextView tvBeerName, tvBeerPrice, tvBeerDescription;
    }
}
