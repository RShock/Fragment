package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fmgr;

    private Fragment f1;
    private Fragment f2;

    private Button btnF1;
    private Button btnF2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fmgr = getSupportFragmentManager();
        f1 = new F1Fragment();
        f2 = new F2Fragment();

        final FragmentTransaction transaction = fmgr.beginTransaction();
        transaction.add(R.id.container, f1);
        transaction.commit();

        btnF1 = findViewById(R.id.buttonF1);
        btnF2 = findViewById(R.id.buttonF2);
        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 FragmentTransaction transaction = fmgr.beginTransaction();
                 transaction.replace(R.id.container, f1);
                 transaction.commit();
            }
        });

        btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fmgr.beginTransaction();
                transaction.replace(R.id.container, f2);
                transaction.commit();
            }
        });
    }
}