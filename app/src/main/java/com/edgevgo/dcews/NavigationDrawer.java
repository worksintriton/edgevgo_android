package com.edgevgo.dcews;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class NavigationDrawer extends AppCompatActivity implements View.OnClickListener{
         private String TAG ="NavigationDrawer";

    private DrawerLayout drawerLayout;
    LayoutInflater inflater;
    View view, header;
    Toolbar toolbar;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;
    ImageView drawerImg;

    FrameLayout frameLayout;
    TextView nav_header_profilename, nav_header_emailid,nav_header_ref_code;
    //SessionManager session;
    String name, image_url, phoneNo;

     public TextView toolbar_title;
     Button btnNotificationPatient;

     public Menu menu;




    ProgressDialog progressDialog;


    private double latitude, longitude;
    private String addressLine = "";

    String emailid = "",patientid = "";
    private Dialog dialog;

    private static final int REQUEST_PHONE_CALL =1 ;
    private String sosPhonenumber;

    public View toolbar_layout;
   public TextView txt_location;
    private String refcode;

    TextView txt_notification_count_badge;
    TextView txt_cart_count_badge;
    private String userid;
    private String profileimage;

    TextView nav_header_logout;


    @SuppressLint({"InflateParams", "LogNotTimber"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        Log.w(TAG, "onCreate---->");

        inflater = LayoutInflater.from(this);
        view = inflater.inflate(R.layout.navigation_drawer_layout, null);



        initUI(view);
        initToolBar(view);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    private void initUI(View view) {

        //Initializing NavigationView
        NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        frameLayout = view.findViewById(R.id.base_container);
        menu = navigationView.getMenu();



        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = view.findViewById(R.id.drawer_layout);
        header = navigationView.getHeaderView(0);


        navigationView.setNavigationItemSelectedListener(menuItem -> {
            //Closing drawer on item click
            drawerLayout.closeDrawers();
            //Check to see which item was being clicked and perform appropriate action
            switch (menuItem.getItemId()) {
                //Replacing the main content with ContentFragment Which is our Inbox View;
                case R.id.nav_item_one:

                    return true;

                default:
                    return true;

            }
        });

    }


    @SuppressLint("SetTextI18n")
    private void initToolBar(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar_layout = view.findViewById(R.id.include_customer_header);

        drawerImg = toolbar_layout.findViewById(R.id.img_menu);


        toggleView();
    }



    private void toggleView() {
        drawerImg.setOnClickListener(v -> {
            if (v.isClickable()) {
                drawerMethod();
            } else {

                Intent intent_re = getIntent();
                overridePendingTransition(0, 0);
                intent_re.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent_re);

            }
        });
    }
    public void drawerMethod() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }

    }
    public void setContentView(int layoutId) {

        Log.e("BaseOncreate", "setContentView");
        View activityView = inflater.inflate(layoutId, null);
        frameLayout.addView(activityView);
        super.setContentView(view);
        //drawerMethod();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                drawerMethod();
                break;


        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"onResume-->");
    }


}
