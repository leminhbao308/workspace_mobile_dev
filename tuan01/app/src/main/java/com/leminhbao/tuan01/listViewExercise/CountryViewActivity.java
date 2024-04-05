package com.leminhbao.tuan01.listViewExercise;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.leminhbao.tuan01.R;

import java.util.ArrayList;
import java.util.List;

public class CountryViewActivity extends AppCompatActivity {

    List<Country> countryData;
    CountryAdapter countryAdapter;
    ListView lvCountry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);

        lvCountry = findViewById(R.id.lvCountry);

        countryData = new ArrayList<>();
        countryData.add(new Country(R.drawable.vn_flag, "Vietnam", 100000000));
        countryData.add(new Country(R.drawable.usa_flag, "United States", 300000000));
        countryData.add(new Country(R.drawable.jp_flag, "Japan", 120000000));

        countryAdapter = new CountryAdapter(this, R.layout.item_layout, countryData);

        lvCountry.setAdapter(countryAdapter);
    }
}
