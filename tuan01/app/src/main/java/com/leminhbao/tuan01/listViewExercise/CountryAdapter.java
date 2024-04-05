package com.leminhbao.tuan01.listViewExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leminhbao.tuan01.R;

import java.util.List;

public class CountryAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Country> data;

    public CountryAdapter(Context context, int layout, List<Country> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Country getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getCountryImageId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(layout, null);

        // Get the country at the current position
        Country country = data.get(position);

        // Set the image of the country
        ImageView imgCountry = row.findViewById(R.id.ivCountryFlag);
        imgCountry.setImageResource(country.getCountryImageId());

        // Set the name of the country
        TextView tvCountryName = row.findViewById(R.id.tvCountryName);
        tvCountryName.setText(country.getCountryName());

        // Set the population of the country
        TextView tvCountryPopulation = row.findViewById(R.id.tvCountryPopulation);
        tvCountryPopulation.setText("Population: " + country.getCountryPopulation());

        return row;
    }
}
