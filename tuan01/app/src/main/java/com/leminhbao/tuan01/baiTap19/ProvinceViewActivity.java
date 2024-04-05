package com.leminhbao.tuan01.baiTap19;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.leminhbao.tuan01.R;

import java.util.ArrayList;
import java.util.List;

public class ProvinceViewActivity extends AppCompatActivity {

    List<Province> provinceData;
    ProvinceAdapter provinceAdapter;
    ListView lvProvince;

    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_19);

        tvDisplay = findViewById(R.id.tvDisplay);
        lvProvince = findViewById(R.id.lvProvince);

        provinceData = new ArrayList<>();
        provinceData.add(new Province("Hà Nội"));
        provinceData.add(new Province("Hồ Chí Minh"));
        provinceData.add(new Province("Đà Nẵng"));
        provinceData.add(new Province("Hải Phòng"));
        provinceData.add(new Province("Cần Thơ"));
        provinceData.add(new Province("Spa"));
        provinceData.add(new Province("Quảng Ninh"));
        provinceData.add(new Province("Nghệ An"));
        provinceData.add(new Province("Huế"));

        provinceAdapter = new ProvinceAdapter(this, R.layout.bai_tap_19_item_layout, provinceData);

        lvProvince.setAdapter(provinceAdapter);

        lvProvince.setOnItemClickListener((parent, view, position, id) -> {
            String selectedProvince = provinceData.get(position).getProvinceName();
            tvDisplay.setText(selectedProvince);
        });
    }
}