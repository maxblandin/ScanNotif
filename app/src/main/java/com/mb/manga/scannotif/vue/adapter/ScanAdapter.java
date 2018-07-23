package com.mb.manga.scannotif.vue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mb.manga.scannotif.R;
import com.mb.manga.scannotif.model.Scan;

import java.util.List;

public class ScanAdapter extends ArrayAdapter<Scan> {

    private ScanAdapterListener mListener;
    private ScanViewHolder viewHolder;

    public ScanAdapter(@NonNull Context context, @NonNull List<Scan> objects) {
        super(context, 0, objects);
    }

    public void setScanAdapterListener(ScanAdapterListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_scan,parent, false);
        }

        viewHolder = (ScanViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ScanViewHolder();
            viewHolder.titre = convertView.findViewById(R.id.titre_scan);
            viewHolder.num = convertView.findViewById(R.id.numero_scan);
            viewHolder.version = convertView.findViewById(R.id.version_scan);
            viewHolder.nomScan = convertView.findViewById(R.id.nom_scan);
            viewHolder.favori = convertView.findViewById(R.id.btn_ajout_fav);
            convertView.setTag(viewHolder);
        }

        Scan scan = getItem(position);

        if (scan != null) {
            viewHolder.titre.setText(scan.getNomManga());
            viewHolder.num.setText(scan.getNumScan());
            viewHolder.version.setText(scan.getVersionScan());
            viewHolder.nomScan.setText(scan.getNomScan());
        }

        viewHolder.favori.setTag(position);
        viewHolder.favori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFavoriClick(viewHolder.favori,viewHolder.titre);
            }
        });

        return convertView;
    }

    private class ScanViewHolder{
        TextView titre;
        TextView num;
        TextView version;
        TextView nomScan;
        ImageButton favori;
    }

    public interface ScanAdapterListener{
        void onFavoriClick(ImageButton btn, TextView txt);
    }
}
