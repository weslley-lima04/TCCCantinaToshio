package com.cantinatoshio.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;


public class LoggedFragment extends Fragment
{


    NavigationView navigationView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logged, container, false);
        navigationView = view.findViewById(R.id.nav_menuPerfil);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.menuPerfil_sair:
                        Cliente.isLoggedIn = false;

                     //   getParentFragmentManager().beginTransaction().replace(R.id.FrameContainer, perfilFragment).commit();
                        return true;
                }
                return false;
            }
        });




        return view;
    }
}