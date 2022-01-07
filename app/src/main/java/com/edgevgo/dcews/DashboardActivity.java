package com.edgevgo.dcews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends NavigationDrawer {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_temp)
    RelativeLayout rl_temp;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_pres)
    RelativeLayout rl_pres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        rl_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DashboardActivity.this,HomeActivity.class));
            }
        });

        rl_pres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DashboardActivity.this,HomeActivity.class));
            }
        });
    }
}