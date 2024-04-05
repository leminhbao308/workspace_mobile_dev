package com.leminhbao.tuan01.baiTap19;

import com.leminhbao.tuan01.R;

public class Province {
    public static int EARTH = R.drawable.earth;
    public static int STAR = R.drawable.star;

    private String provinceName;
    private int provinceImage;

    public Province(String provinceName) {
        this.provinceName = provinceName;

        if (provinceName.length() <= 3) {
            provinceImage = STAR;
        } else {
            provinceImage = EARTH;
        }
    }

    public String getProvinceName() {
        return provinceName;
    }

    public int getProvinceImage() {
        return provinceImage;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setProvinceImage(int provinceImage) {
        this.provinceImage = provinceImage;
    }
}
