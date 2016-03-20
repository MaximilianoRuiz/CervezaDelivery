package com.example.maxi.cervezadelivery.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.maxi.cervezadelivery.R;

public class LogginActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        initWidgets();
    }

    private void initWidgets(){
        btnLogin = (Button) findViewById(R.id.btnLogin);

        addActionListeners();
    }

    private void addActionListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Hola", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
