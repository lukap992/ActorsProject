package com.example.actorsproject.activites;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.actorsproject.R;
import com.example.actorsproject.adapters.DrawerAdapter;
import com.example.actorsproject.dialog.AboutDialog;
import com.example.actorsproject.fragments.DetailFragment;
import com.example.actorsproject.fragments.ListAllMoviesFragment;
import com.example.actorsproject.fragments.MasterFragment;
import com.example.actorsproject.model.NavigationItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MasterFragment.OnItemSelected, DetailFragment.OnSpinnerSelected {

    private boolean landscape = false;
    private int position = 0;
    private MasterFragment masterFragment = null;
    private DetailFragment detailFragment = null;
    private ListAllMoviesFragment listAllMoviesFragment = null;

    private DrawerLayout drawerLayout;
    private ListView drawerListView;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence drawerTitle;
    private RelativeLayout drawerPane;
    private ArrayList<NavigationItem> drawerItems = new ArrayList<>();

    private AlertDialog aboutDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            position = savedInstanceState.getInt("position", position);
        }
        if(masterFragment == null){
            masterFragment = new MasterFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.master_view, masterFragment, "MasterFragment1");
            fragmentTransaction.commit();
        }

        if(findViewById(R.id.detail_landscape_view) != null){
            landscape = true;
            getFragmentManager().popBackStack();

            if(detailFragment == null){
                detailFragment = new DetailFragment();
                detailFragment.setContent(position);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.detail_landscape_view, detailFragment);
                fragmentTransaction.commit();
            }
        }

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();


        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }
        drawerItems.add(new NavigationItem("Show All Movies","This option shows ALL MOVIES.",R.drawable.ic_format_align_justify_black_24dp));
        drawerItems.add(new NavigationItem("About Application", "Click On me for information",R.drawable.ic_error_black_24dp));

        DrawerAdapter drawerAdapter = new DrawerAdapter(this, drawerItems);
        drawerListView = findViewById(R.id.nav_list);
        drawerListView.setAdapter(drawerAdapter);
        drawerListView.setOnItemClickListener(new DrawerItemClickListener());

        drawerTitle = getTitle();
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerPane = findViewById(R.id.drawer_pane);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                super.onDrawerClosed(drawerView);
            }
        };

    }
    @Override
    public void OnItemClick(int position) {
        this.position = position;

        if(landscape){
            detailFragment.updateContent(position);
        }else{
            detailFragment = new DetailFragment();
            detailFragment.setContent(position);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft1 = fragmentManager.beginTransaction();
            ft1.replace(R.id.master_view, detailFragment, "OnClickMaster");
            ft1.addToBackStack(null);
            ft1.commit();
        }
    }
    @Override
    public void OnSpinnerSelected(int position) {
        this.position = position;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(landscape){
            detailFragment.updateContent(position);
        }
        getFragmentManager().popBackStack();
        detailFragment = new DetailFragment();
        FragmentTransaction ft2 = getFragmentManager().beginTransaction();
        ft2.replace(R.id.master_view, masterFragment);
        ft2.commit();

    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                listAllMoviesFragment = new ListAllMoviesFragment();
                FragmentManager ftm = getFragmentManager();
                FragmentTransaction ft3 = ftm.beginTransaction();
                ft3.replace(R.id.master_view,listAllMoviesFragment,"ListMoviesFragment");
                ft3.addToBackStack(null);
                ft3.commit();
            } else if (position == 1) {
                if (aboutDialog == null) {
                    aboutDialog = new AboutDialog(MainActivity.this).prepareDialog();
                } else {
                    if (aboutDialog.isShowing()) {
                        aboutDialog.dismiss();
                    }
                }
                aboutDialog.show();
            }
            drawerListView.setItemChecked(position,true);
            setTitle(drawerItems.get(position).getTitle());
            drawerLayout.closeDrawer(drawerPane);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_create:
                Snackbar.make(findViewById(R.id.master_view), "CREATED", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.action_delete:
                Snackbar.make(findViewById(R.id.master_view), "DELETED", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.action_update:
                Snackbar.make(findViewById(R.id.master_view), "UPDATED", Snackbar.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        drawerToggle.syncState();
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        drawerToggle.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("position", position);
    }
}
