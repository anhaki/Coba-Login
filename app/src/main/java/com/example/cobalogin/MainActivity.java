package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LoginMec LM = new LoginMec();
    private TextView tvSesi, tvName;
    private String ambilSesi, ambilNama;

    public static String keySPusername = "HakikiWADAW";
    public static String keySPname = "HqqWADAW";


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

            ambilNama = LM.getPref(MainActivity.this,keySPname);
            tvName = findViewById(R.id.tv_name);
            tvName.setText(ambilNama);
        }
    }
    public void prosesLogout(View view) {
        LM.setPref(MainActivity.this,keySPusername,null);
        LM.setPref(MainActivity.this,keySPname,null);
        startActivity(new Intent(MainActivity.this,
                Login.class));
        finish();
    }

}