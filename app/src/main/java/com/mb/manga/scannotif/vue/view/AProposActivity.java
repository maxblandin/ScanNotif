package com.mb.manga.scannotif.vue.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mb.manga.scannotif.R;
import com.mb.manga.scannotif.vue.fragment.NavigationFragment;

public class AProposActivity extends AppCompatActivity implements NavigationFragment.OnNavigationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
    }

    @Override
    public void goToNewScan() {
        Intent intent = new Intent(AProposActivity.this,LoadActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToFavori() {
        Intent intent = new Intent(AProposActivity.this,ScanALireActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToParametre() {

    }

    @Override
    public void goToAPropos() {

    }
}
