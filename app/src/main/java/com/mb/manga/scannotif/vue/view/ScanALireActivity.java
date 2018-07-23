package com.mb.manga.scannotif.vue.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.mb.manga.scannotif.R;
import com.mb.manga.scannotif.model.Scan;
import com.mb.manga.scannotif.service.ServiceScan;
import com.mb.manga.scannotif.vue.fragment.NavigationFragment;
import com.mb.manga.scannotif.vue.fragment.ScanFragment;

import java.util.List;

public class ScanALireActivity extends AppCompatActivity implements ScanFragment.OnScanFragmentListener, NavigationFragment.OnNavigationListener{

    private ServiceScan serviceScan = new ServiceScan();
    private List<Scan> scans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        scans = serviceScan.recupererScanALire();
        setContentView(R.layout.activity_scan_a_lire);
    }

    @Override
    public Context getContext() {
        return ScanALireActivity.this;
    }

    @Override
    public List<Scan> recupererScans() {
        return scans;
    }

    @Override
    public void goToScan(String lien) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(lien));
        startActivity(browserIntent);
    }

    @Override
    public void goToNewScan() {
        Intent intent = new Intent(ScanALireActivity.this,LoadActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToFavori() {

    }

    @Override
    public void goToParametre() {

    }

    @Override
    public void goToAPropos() {
        Intent intent = new Intent(ScanALireActivity.this,AProposActivity.class);
        startActivity(intent);
    }
}
