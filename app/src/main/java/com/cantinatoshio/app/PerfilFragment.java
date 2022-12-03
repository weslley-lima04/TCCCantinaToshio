package com.cantinatoshio.app;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;


public class PerfilFragment extends Fragment
{

    Button btnlogar;
    TextView semConta;
    TextInputEditText inputemail, inputsenha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);


        semConta = view.findViewById(R.id.txtSemConta);
        btnlogar = view.findViewById(R.id.btnLogar);
        inputemail = view.findViewById(R.id.inputUsername);
        inputsenha = view.findViewById(R.id.inputUserPass);



        //não basta setar o leyout, ele tem de ter o próprio Fragment



        semConta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });

        btnlogar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String email = inputemail.getText().toString().trim();
                String senha = inputsenha.getText().toString().trim();
                if(checkVazio(email, senha))
                {
                    new Cliente().logar(email, senha);
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                }
            }
        });

        if(Cliente.isLoggedIn)
        {
            LoggedFragment loggedFragment = new LoggedFragment();
            getParentFragmentManager().beginTransaction().replace(R.id.FrameContainer, loggedFragment).commit();
        }

        return view;
    }


    private boolean checkVazio(String a, String b)
    {


        if(TextUtils.isEmpty(a))
        {
            inputemail.setError("Por favor, digite seu email.");
            inputemail.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(b))
        {
            inputsenha.setError("Por favor, digite sua senha.");
            inputsenha.requestFocus();
            return false;
        }

        return true;
    }


}