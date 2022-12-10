package com.cantinatoshio.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class LoginFragment extends Fragment
{

    Button btnlogar;
    TextInputEditText inputemail, inputsenha;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnlogar = view.findViewById(R.id.btnLogar);
        inputemail = view.findViewById(R.id.inputUserEmail);
        inputsenha = view.findViewById(R.id.inputUserPass);

        btnlogar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String email = inputemail.getText().toString().trim();
                String senha = inputsenha.getText().toString().trim();
                if(checkVazio(email, senha))
                {
                    try
                    {
                        new Cliente().logar(email, senha);
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getContext(), "Falha ao fazer login.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

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