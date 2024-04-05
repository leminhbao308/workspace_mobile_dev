package com.leminhbao.tuan01.baiTap19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leminhbao.tuan01.R;

import java.util.List;

public class ProvinceAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Province> data;

    public ProvinceAdapter(Context context, int layout, List<Province> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Province getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getProvinceImage();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(layout, null);

        // Get the province at the current position
        Province province = data.get(position);

        // Set the image of the province
        ImageView imgProvince = row.findViewById(R.id.ivIcon);
        imgProvince.setImageResource(province.getProvinceImage());

        // Set the name of the province
        TextView imgProvinceName = row.findViewById(R.id.tvProvinceName);
        imgProvinceName.setText(province.getProvinceName());

        return row;
    }
}
