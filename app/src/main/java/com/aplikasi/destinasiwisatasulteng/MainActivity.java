package com.aplikasi.destinasiwisatasulteng;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.fragment_home) {
                    fragment = new HomeFragment();
                } else if (itemId == R.id.fragment_category) {
                    fragment = new CategoryFragment();
                } else if (itemId == R.id.fragment_account) {
                    fragment = new AccountFragment();
                }

                if (fragment != null) {
                    switchFragment(fragment);
                    return true;
                }

                return false;
            }
        });
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}

