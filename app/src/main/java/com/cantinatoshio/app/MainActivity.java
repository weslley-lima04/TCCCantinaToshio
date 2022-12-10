package com.cantinatoshio.app;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    PedidosFragment pedidosFragment = new PedidosFragment();
  //  PerfilFragment perfilFragment = new PerfilFragment();
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


        //função que checa status de login
        if(!Objects.isNull(Cliente.idCliente))
        {
            new Cliente().getLoginStatus(Cliente.idCliente);
        }

        //chamando lista pedidos
        if(Cliente.isLoggedIn)
        {
            new Cliente().getPedidosCliente();
        }


        btnCart = findViewById(R.id.btnCart);

        //ID NavDrawer
        toolbar = findViewById(R.id.idToolBar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.idNavigationView);
        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //acessando os itens do header
        headerview = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerview.findViewById(R.id.navUserName);
        TextView navUseremail = (TextView) headerview.findViewById(R.id.navUserEmail);
        CircleImageView userImage = (CircleImageView) headerview.findViewById(R.id.circleImageView);
        menu = navigationView.getMenu();
        MenuItem exit = menu.findItem(R.id.nav_menu_exit);


        //clique para abrir o NavDrawer


        //setando infos do perfil conforme login

        if(!Cliente.isLoggedIn)
        {
            navUsername.setVisibility(View.GONE);
            navUseremail.setVisibility(View.GONE);
            userImage.setVisibility(View.GONE);
            exit.setIcon(R.drawable.ic_baseline_arrow_back);
            exit.setTitle("Entrar");
        }
        else
        {
            navUsername.setText(Cliente.nomeCliente);
            navUseremail.setText(Cliente.emailCliente);
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
                   // case R.id.ic_perfil:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, perfilFragment).commit();
                        //return true;
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.nav_menu_exit)
        {
            if(!Cliente.isLoggedIn)
            {
                Intent intent = new Intent(getApplicationContext(), LogarActivity.class);
                startActivity(intent);
            }
            else
            {
                Cliente.isLoggedIn = false;
                refresh();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Deslogado com sucesso.", Toast.LENGTH_SHORT).show();
            }

        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState)
    {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void refresh()
    {
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}