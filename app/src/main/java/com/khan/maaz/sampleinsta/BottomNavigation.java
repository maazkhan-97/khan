package com.khan.maaz.sampleinsta;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.khan.maaz.sampleinsta.Fragments.FavFragment;
import com.khan.maaz.sampleinsta.Fragments.HomeFragment;
import com.khan.maaz.sampleinsta.Fragments.PostFragment;
import com.khan.maaz.sampleinsta.Fragments.ProfileFragment;
import com.khan.maaz.sampleinsta.Fragments.SearchFragment;

public class BottomNavigation extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener, FavFragment.OnFragmentInteractionListener, PostFragment.OnFragmentInteractionListener{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentContainer, HomeFragment.newInstance());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = HomeFragment.newInstance();
                        break;
                    case R.id.navigation_search:
                        selectedFragment = SearchFragment.newInstance();
                        break;
                    case R.id.navigation_add_photo:
                        selectedFragment = PostFragment.newInstance();
                        break;
                    case R.id.navigation_fav:
                        selectedFragment = FavFragment.newInstance();
                        break;
                    case R.id.navigation_user:
                        selectedFragment = ProfileFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contentContainer, selectedFragment);
                transaction.commit();
                return true;
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}