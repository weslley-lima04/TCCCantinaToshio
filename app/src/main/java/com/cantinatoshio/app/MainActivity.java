package com.cantinatoshio.app;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    PedidosFragment pedidosFragment = new PedidosFragment();
    PerfilFragment perfilFragment = new PerfilFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //parte do bottom navigation

        bottomNavigationView = findViewById(R.id.btnNav);
        callFragment(homeFragment); //iniciar na home
        //toolbar = findViewById(R.id.mainToolbar);
       // setSupportActionBar(toolbar);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.ic_Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, homeFragment).commit();
                        return true;
                    case R.id.ic_pedidos:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, pedidosFragment).commit();
                        return true;
                    case R.id.ic_perfil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, perfilFragment).commit();
                        return true;
                }

                return false;
            }
        });


    }

    public void callFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, fragment).commit();
    }
}