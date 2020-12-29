package com.example.tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText email;
        final EditText password;
        Button button;

        email = (EditText)findViewById(R.id.usernameInput);
        password = (EditText)findViewById(R.id.passwordInput);
        button = (Button)findViewById(R.id.inputButton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = email.getText().toString().trim();
                String passwordString = password.getText().toString().trim();
                Log.d("emailTag", emailString);
                if(!TextUtils.isEmpty(emailString) && Patterns.EMAIL_ADDRESS.matcher(emailString).matches() && passwordString.equals("admin")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wrong input", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


    }
}
