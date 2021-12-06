package com.prof.amine.myprof;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.prof.amine.myprof.fragments.AccountFrag;
import com.prof.amine.myprof.fragments.EmploiTempsFrag;
import com.prof.amine.myprof.fragments.InstitutionParametersFrag;
import com.prof.amine.myprof.fragments.NoveltiesFrag;
import com.prof.amine.myprof.fragments.SeancesDoneFrag;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //default frag
        NoveltiesFrag novFragment=new NoveltiesFrag();
        android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_frame,novFragment).commit();

        navigationView.setCheckedItem(R.id.nav_novelties);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("هل تريد الخروج من التطبيق ؟");
        builder.setCancelable(true);
        builder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager=getFragmentManager();

        if (id == R.id.nav_myAccount) {
           // fragmentManager.beginTransaction().replace(R.id.content_frame,new Account()).commit();
           /* Intent i=new Intent(MainActivity.this,Account.class);
            startActivity(i);*/
           AccountFrag accountFragment=new AccountFrag();
           android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
           manager.beginTransaction().replace(R.id.content_frame,accountFragment).commit();

        } else if (id == R.id.nav_instParam) {
            InstitutionParametersFrag instParamFragment=new InstitutionParametersFrag();
            android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame,instParamFragment).commit();

        } else if (id == R.id.nav_novelties) {
            NoveltiesFrag novFragment=new NoveltiesFrag();
            android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame,novFragment).commit();

        } else if (id == R.id.nav_emploiTemps) {
            EmploiTempsFrag empTempsFragment=new EmploiTempsFrag();
            android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame,empTempsFragment).commit();

        } else if (id == R.id.nav_seanDone) {
            SeancesDoneFrag seanDoneFragment=new SeancesDoneFrag();
            android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_frame,seanDoneFragment).commit();

        } else if (id == R.id.nav_auth) {
            Intent toSplash = new Intent(MainActivity.this,Authentification.class);
            startActivity(toSplash);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
