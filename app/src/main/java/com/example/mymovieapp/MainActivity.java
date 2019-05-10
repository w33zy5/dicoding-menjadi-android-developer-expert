package com.example.mymovieapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mymovieapp.fragment.MovieFragment;
import com.example.mymovieapp.fragment.TvShowFragment;

public class MainActivity extends AppCompatActivity {
    String title;
    final String STATE_TITLE = "state_string";
    final String STATE_MODE = "state_mode";
    int mode;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;
            mode = item.getItemId();

            switch (mode) {
                case R.id.navigation_movies:
                    title = "Movies";
                    setActionBarTitle(title);
                    fragment = new MovieFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();

                    return true;
                case R.id.navigation_tvshows:
                    title = "Tv Shows";
                    setActionBarTitle(title);
                    fragment = new TvShowFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
            }

            return false;
        }
    };

    public void setMode(int selectedMode){
        Fragment fragment;
        switch (selectedMode){
            case R.id.navigation_movies:
                title = "Movies";
                fragment = new MovieFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();
                break;
            case R.id.navigation_tvshows:
                title = "Tv Shows";
                fragment = new TvShowFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_layout);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        int stateMode;
        if(savedInstanceState == null){
            setActionBarTitle(title);
            stateMode = R.id.navigation_movies;
            setMode(stateMode);
        } else {
            title = savedInstanceState.getString(STATE_TITLE);
            setActionBarTitle(title);
            stateMode = savedInstanceState.getInt(STATE_MODE);
            setMode(stateMode);
        }
    }

    private void setActionBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(STATE_TITLE, title);
        Log.d("STATE_TITLE", "onSaveInstanceState: "+title);
        outState.putInt(STATE_MODE, mode);
        Log.d("STATE_MODE", "onSaveInstanceState: "+mode);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_change_settings){
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
