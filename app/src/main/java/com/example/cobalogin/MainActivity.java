package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LoginMec LM = new LoginMec();
    private TextView tvSesi;
    private String ambilSesi;

    public static String keySPusername = "HakikiWADAW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LM.isLogin(MainActivity.this,keySPusername)){
            startActivity(new
                    Intent(MainActivity.this,Login.class));
            finish();
        }
        else{
            setContentView(R.layout.activity_main);
            ambilSesi = LM.getPref(MainActivity.this,keySPusername);
            tvSesi = findViewById(R.id.tv_sesi);
            tvSesi.setText(ambilSesi);
        }
    }
    public void prosesLogout(View view) {
        LM.setPref(MainActivity.this,keySPusername,null);
        startActivity(new Intent(MainActivity.this,
                Login.class));
        finish();
    }

}