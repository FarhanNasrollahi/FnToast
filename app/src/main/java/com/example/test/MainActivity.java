package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.fntoast.FnToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttons).setOnClickListener(v -> {

            FnToast fnToast = new FnToast(MainActivity.this);
            fnToast.setBackgroundColor(Color.BLUE);
            fnToast.setTextColor(Color.BLACK);
            fnToast.setText("salam");
            fnToast.setRadius(10);
            fnToast.setMargin_L_R(40);
            fnToast.setIconVisibility(true);
            fnToast.setForceDark(false);
            fnToast.setDuration(FnToast.LENGTH.SHORT);
            fnToast.show();



        });
    }
}