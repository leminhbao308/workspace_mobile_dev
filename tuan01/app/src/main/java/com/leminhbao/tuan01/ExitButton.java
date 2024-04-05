package com.leminhbao.tuan01;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class ExitButton extends androidx.appcompat.widget.AppCompatButton {
    public ExitButton(Context context) {
        super(context);
        init();
    }

    public ExitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExitButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý đóng ứng dụng
                ((Activity) getContext()).finish();
            }
        });
    }
}
