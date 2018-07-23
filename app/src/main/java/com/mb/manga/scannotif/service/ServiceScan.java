package com.mb.manga.scannotif.service;

import com.mb.manga.scannotif.dao.ScanDao;
import com.mb.manga.scannotif.model.Scan;

import java.util.ArrayList;
import java.util.List;

public class ServiceScan {

    private ScanDao dao = new ScanDao();

    public List<Scan> recupererScanALire(){
        return dao.getList();
    }

    public void enregistrerScan(Scan scan){

    }
}
