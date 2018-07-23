package com.mb.manga.scannotif.vue.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.mb.manga.scannotif.R;
import com.mb.manga.scannotif.model.Scan;
import com.mb.manga.scannotif.service.ServiceScan;
import com.mb.manga.scannotif.vue.adapter.ScanAdapter;

import java.util.List;

public class ScanFragment extends Fragment implements ScanAdapter.ScanAdapterListener{

    private OnScanFragmentListener mListener;
    private ListView lv;
    private Scan scan;


    public ScanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scan, container, false);
        lv  = v.findViewById(R.id.list_scan);

        //On récupére la liste des scans avec le listener
        final ScanAdapter adapter = new ScanAdapter(mListener.getContext(), mListener.recupererScans());
        adapter.setScanAdapterListener(this);

        //On donne à la liste pour l'afficher
        lv.setAdapter(adapter);

        //Le clique sur la liste envoi sur le site pour lire le scan
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                scan = adapter.getItem(position);
                mListener.goToScan(scan.getLien());
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnScanFragmentListener) {
            mListener = (OnScanFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onFavoriClick(ImageButton btn, TextView txt) {
        Toast toast = Toast.makeText(mListener.getContext(),txt.getText(),Toast.LENGTH_LONG);
        toast.show();
        btn.setImageResource(R.drawable.ic_star_black_24dp);
    }

    public interface OnScanFragmentListener {
        Context getContext();
        List<Scan> recupererScans();
        void goToScan(String lien);
    }
}
