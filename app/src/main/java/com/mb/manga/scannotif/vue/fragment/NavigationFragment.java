package com.mb.manga.scannotif.vue.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.mb.manga.scannotif.R;

public class NavigationFragment extends Fragment {

    private OnNavigationListener mListener;

    private ImageButton btnNewScan;
    private ImageButton btnFavori;
    private ImageButton btnParametre;
    private ImageButton btnAPropos;


    public NavigationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_navigation, container, false);

        btnNewScan = v.findViewById(R.id.btn_nav_newscan);
        btnFavori = v.findViewById(R.id.btn_nav_favori);
        btnParametre = v.findViewById(R.id.btn_nav_param);
        btnAPropos = v.findViewById(R.id.btn_nav_apropos);

        btnNewScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToNewScan();
            }
        });

        btnFavori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToFavori();
            }
        });

        btnParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToParametre();
            }
        });

        btnAPropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToAPropos();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNavigationListener) {
            mListener = (OnNavigationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnNavigationListener {
        void goToNewScan();
        void goToFavori();
        void goToParametre();
        void goToAPropos();
    }
}
