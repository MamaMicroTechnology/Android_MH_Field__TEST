package com.mamahome360.mamaaps.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.mamahome360.mamaaps.R;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction fragmentTransaction;
    Toolbar toolbar;

    SharedPreferences preferences;

    FrameLayout overlay_view;

    String Brands = "BRANDS", Enquiries = "ENQUIRIES", Orders = "ORDERS", Kra = "KRA",
            TrainingVideos = "TRAININGVIDEOS", MyReport = "MYREPORT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionsMenu fab_menu = findViewById(R.id.fab_menu);
       DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab1 = findViewById(R.id.fab_action1);

        overlay_view = findViewById(R.id.overlay);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_menu.collapse();
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.home_container, new AddProjectFragment());
                ft.commit();


            }
        });
    fab_menu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
        @Override
        public void onMenuExpanded() {
            overlay_view.setVisibility(View.VISIBLE);

        }

        @Override
        public void onMenuCollapsed() {
            overlay_view.setVisibility(View.INVISIBLE);
        }
    });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_brand) {
            // Handle the camera action
            doFragmentTransactions(Brands);
        }
        else if (id == R.id.nav_Enquiry) {
            doFragmentTransactions(Enquiries);

        } else if (id == R.id.nav_order) {
            doFragmentTransactions(Orders);

        } else if (id == R.id.nav_kra) {
            doFragmentTransactions(Kra);

        } else if (id == R.id.nav_videos) {
            doFragmentTransactions(TrainingVideos);

        } else if (id == R.id.nav_manage) {
            doFragmentTransactions(MyReport);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void doFragmentTransactions(String Fragment){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,
                R.anim.slide_out_left, R.anim.slide_in_left,
                R.anim.slide_out_right);
        if(Fragment.equals(Brands)){
            fragmentTransaction.replace(R.id.home_container, new ViewBrandFragment(), "BRANDS_FRAGMENT");
            //fragmentTransaction.addToBackStack("BS_BRANDS");
            fragmentTransaction.addToBackStack(null);
        }
        if(Fragment.equals(Enquiries)){
            fragmentTransaction.replace(R.id.home_container, new ViewEnquiryFragment(), "ENQUIRIES_FRAGMENT");
          //  fragmentTransaction.addToBackStack("BS_ENQUIRIES");
           // fragmentTransaction.addToBackStack(null);
        }

        else if(Fragment.equals(Orders)){
            fragmentTransaction.replace(R.id.home_container, new ViewOrderFragment(), "ORDERS_FRAGMENT");
            //  fragmentTransaction.addToBackStack("BS_ORDERS");
          //  fragmentTransaction.addToBackStack(null);
        }
        else if(Fragment.equals(Kra)){
            fragmentTransaction.replace(R.id.home_container, new ViewKraFragment(), "KRA_FRAGMENT");
           // fragmentTransaction.addToBackStack("BS_KRA");
          //  fragmentTransaction.addToBackStack(null);
        }
        else if(Fragment.equals(TrainingVideos)){
            fragmentTransaction.replace(R.id.home_container, new ViewTrainingVideosFragment(), "TRAININGVIDEOS_FRAGMENT");
           // fragmentTransaction.addToBackStack("BS_TRAININGVIDEOS");
          //  fragmentTransaction.addToBackStack(null);
        }
        else if(Fragment.equals(MyReport)){
            fragmentTransaction.replace(R.id.home_container, new ViewMyreportFragment(), "MYREPORT_FRAGMENT");
            //fragmentTransaction.addToBackStack("BS_MYREPORT");
           // fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

}
