package com.mb.manga.scannotif.vue.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mb.manga.scannotif.R;
import com.mb.manga.scannotif.dto.ScanListParcelable;
import com.mb.manga.scannotif.model.Scan;
import com.mb.manga.scannotif.tools.ScanTools;
import com.mb.manga.scannotif.vue.fragment.NavigationFragment;
import com.mb.manga.scannotif.vue.fragment.ScanFragment;

import java.util.List;

public class ScanActivity extends AppCompatActivity implements ScanFragment.OnScanFragmentListener, NavigationFragment.OnNavigationListener {

    private ScanTools tools = new ScanTools();
    private List<Scan> scans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        ScanListParcelable lstParcelable = b.getParcelable("listScan");

        scans = tools.listParcelableToListScan(lstParcelable);

        setContentView(R.layout.activity_scan);

        // On termine l'activité d'avant (début appli)
        Intent intent = new Intent("finish");
        sendBroadcast(intent);
    }

    @Override
    public Context getContext() {
        return ScanActivity.this;
    }

    @Override
    public List<Scan> recupererScans() {
        return scans;
    }

    @Override
    public void goToScan(String lien) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(lien));
        startActivity(browserIntent);
    }

    @Override
    public void goToNewScan() {
        Intent intent = new Intent(ScanActivity.this,LoadActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToFavori() {
        Intent intent = new Intent(ScanActivity.this,ScanALireActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToParametre() {

    }

    @Override
    public void goToAPropos() {
        Intent intent = new Intent(ScanActivity.this,AProposActivity.class);
        startActivity(intent);
    }
}
