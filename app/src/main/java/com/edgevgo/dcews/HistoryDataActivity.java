package com.edgevgo.dcews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.eazegraph.lib.charts.StackedBarChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.StackedBarModel;

import butterknife.BindView;

public class HistoryDataActivity extends AppCompatActivity {


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_menu)
    ImageView img_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_data);

        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                
            }
        });

        StackedBarChart mStackedBarChart = (StackedBarChart) findViewById(R.id.stackedbarchart);

        StackedBarModel s1 = new StackedBarModel("26Jan");

        s1.addBar(new BarModel(2.3f, 0xFF63CBB0));
        s1.addBar(new BarModel(2.3f, 0xFF56B7F1));
        s1.addBar(new BarModel(2.3f, 0xFFCDA67F));

        StackedBarModel s2 = new StackedBarModel("27Jan");
        s2.addBar(new BarModel(1.1f, 0xFF63CBB0));
        s2.addBar(new BarModel(2.7f, 0xFF56B7F1));
        s2.addBar(new BarModel(0.7f, 0xFFCDA67F));

        StackedBarModel s3 = new StackedBarModel("28Jan");

        s3.addBar(new BarModel(2.3f, 0xFF63CBB0));
        s3.addBar(new BarModel(2.f, 0xFF56B7F1));
        s3.addBar(new BarModel(3.3f, 0xFFCDA67F));

        StackedBarModel s4 = new StackedBarModel("29Jan");
        s4.addBar(new BarModel(1.f, 0xFF63CBB0));
        s4.addBar(new BarModel(4.2f, 0xFF56B7F1));
        s4.addBar(new BarModel(2.1f, 0xFFCDA67F));

        StackedBarModel s5 = new StackedBarModel("30Jan");
        s5.addBar(new BarModel(1.f, 0xFF63CBB0));
        s5.addBar(new BarModel(4.2f, 0xFF56B7F1));
        s5.addBar(new BarModel(2.1f, 0xFFCDA67F));

        StackedBarModel s6 = new StackedBarModel("31Jan");
        s6.addBar(new BarModel(1.f, 0xFF63CBB0));
        s6.addBar(new BarModel(4.2f, 0xFF56B7F1));
        s6.addBar(new BarModel(2.1f, 0xFFCDA67F));



        mStackedBarChart.addBar(s1);
        mStackedBarChart.addBar(s2);
        mStackedBarChart.addBar(s3);
        mStackedBarChart.addBar(s4);
        mStackedBarChart.addBar(s5);
        mStackedBarChart.addBar(s6);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(HistoryDataActivity.this,HomeActivity.class));
    }
}