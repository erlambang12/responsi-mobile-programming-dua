package com.praktikum.responsimp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    Shard sharedPrefManager;
    Handler handler = new Handler();
    EditText idnama, pass;
    Button btnloginn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sharedPrefManager = new Shard(this);
        idnama = findViewById(R.id.idnama);
        pass = findViewById(R.id.pass);
        btnloginn = findViewById(R.id.loginn);
        loginn();
    }

    private void loginn() {
        btnloginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = idnama.getText().toString();
                final String password = pass.getText().toString();

                btnloginn.setVisibility(View.VISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String spuser = sharedPrefManager.getUsername();
                        String sppass = sharedPrefManager.getPassword();

                        Log.d("username", "user" + username);
                        Log.d("password", "pass" + password);

                        if (username.equals(spuser) && password.equals(sppass)) {
                            Intent a = new Intent(sign_up.this, Drawer.class);
                            sharedPrefManager.saveIsLogin(true);
                            finishAffinity();
                            startActivity(a);
                        } else {
                            btnloginn.setVisibility(View.GONE);
                            Toast.makeText(sign_up.this, "username dan password salah lur", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, 3000);
            }
        });
    }
}