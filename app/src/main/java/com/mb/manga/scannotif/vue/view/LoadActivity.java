package com.mb.manga.scannotif.vue.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mb.manga.scannotif.R;
import com.mb.manga.scannotif.dto.ScanListParcelable;
import com.mb.manga.scannotif.dto.ScanParcelable;
import com.mb.manga.scannotif.model.Scan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoadActivity extends AppCompatActivity {

    final String URL = "https://www.japscan.cc/rss/";
    final String BALISE_XML = "<item>";
    final String BALISE_CLOSE_XML = "</item>";
    final int LENGTH_BALISE = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("finish")) {
                    finish();
                }
                unregisterReceiver(this);
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("finish"));

        LoadAsyncTask task = new LoadAsyncTask();
        task.execute();
    }

    private void readFluxRss() throws IOException {
        String xml;
        ScanListParcelable scans = new ScanListParcelable();

        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET,URL,future,future);

        RequestQueue queue = Volley.newRequestQueue(LoadActivity.this);
        queue.add(request);

        try{
            xml = future.get();

            scans = decouperXml(xml);

            Intent intent = new Intent(LoadActivity.this,ScanActivity.class);
            intent.putExtra("listScan",(Parcelable) scans);
            startActivity(intent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class LoadAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                readFluxRss();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private ScanListParcelable decouperXml(String xml) throws IOException {
        ScanListParcelable scans = new ScanListParcelable();
        XmlMapper xmlMapper = new XmlMapper();
        String[] splitXml;
        String scanXml;
        int i = 1;

        splitXml = xml.split(BALISE_XML);

        while(i != splitXml.length){
            scanXml = splitXml[i].substring(0,splitXml[i].length()-LENGTH_BALISE);
            scanXml = BALISE_XML + scanXml+ BALISE_CLOSE_XML;

            ScanParcelable scan = xmlMapper.readValue(scanXml,ScanParcelable.class);
            i++;
            scans.add(scan);
        }
        return scans;
    }
}
