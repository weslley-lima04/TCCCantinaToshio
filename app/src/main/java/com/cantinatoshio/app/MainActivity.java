package com.cantinatoshio.app;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cantinatoshio.app.api.Api;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.time.TimeSource;

public class MainActivity extends AppCompatActivity
{

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    PedidosFragment pedidosFragment = new PedidosFragment();
    PerfilFragment perfilFragment = new PerfilFragment();
    FloatingActionButton btnCart;

    //Drawer Layout
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    MaterialToolbar toolbar;
    View headerview;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //chamando lista pedidos
        new Cliente().getPedidosCliente();

        btnCart = findViewById(R.id.btnCart);

        //ID NavDrawer
        toolbar = findViewById(R.id.idToolBar);
        drawerLayout = findViewById(R.id.idNavDrawer);
        navigationView = findViewById(R.id.idNavigationView);

                //getItem(R.id.menuPerfil_sair);

        //acessando os itens do header
        headerview = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerview.findViewById(R.id.navUserName);
        TextView navUseremail = (TextView) headerview.findViewById(R.id.navUserEmail);
        CircleImageView userImage = (CircleImageView) headerview.findViewById(R.id.circleImageView);
        menu = navigationView.getMenu();
        MenuItem exit = menu.findItem(R.id.nav_menu_exit);


        //clique para abrir o NavDrawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //setando infos do perfil conforme login

        if(!Cliente.isLoggedIn)
        {
            navUsername.setVisibility(View.GONE);
            navUseremail.setVisibility(View.GONE);
            userImage.setVisibility(View.GONE);
            exit.setIcon(R.drawable.ic_baseline_arrow_back);
            exit.setTitle("Entrar");
        }

        //parte do bottom navigation

        bottomNavigationView = findViewById(R.id.btnNav);
        callFragment(homeFragment); //iniciar na home

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.ic_Home:
                        callFragment(homeFragment);
                        return true;
                    case R.id.ic_pedidos:
                        callFragment(pedidosFragment);
                        return true;
                    case R.id.ic_perfil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, perfilFragment).commit();
                        return true;
                }

                return false;
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
                startActivity(intent);
            }
        });

    }

    public void callFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, fragment).commit();
    }


}