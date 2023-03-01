package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String username, password;
    LoginMec LM = new LoginMec();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }
    public void prosesLogin(View view) {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        if (username.trim().equals("") || password.trim().equals("")) {
            if (username.trim().equals("")){
                etUsername.setError("Username tidak boleh kosong!");
            }
            if (password.trim().equals("")){
                etPassword.setError("Password tidak boleh kosong!");
            }
        }
        else if(username.equals("Haki") && password.equals("123")){
            LM.setPref(Login.this, MainActivity.keySPusername,username);
            LM.setPref(Login.this, MainActivity.keySPname,"Muhammad Anugrah Hakiki");
            startActivity(new Intent(Login.this,
                    MainActivity.class));
            finish();
        }
        else{
            Toast.makeText(this, "Login Gagal",
                    Toast.LENGTH_SHORT).show();
        }
    }
}