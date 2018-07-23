package com.mb.manga.scannotif.dao;

import com.mb.manga.scannotif.model.Scan;

import java.util.ArrayList;
import java.util.List;

public class ScanDao {

    private List<Scan> scans;

    public List<Scan> getList(){
        if (scans == null){
            scans = new ArrayList<>();
            return getScanALire();
        }else{
            return scans;
        }
    }

    public List<Scan> getScanALire(){
        Scan s1 = new Scan("Dragon ball","Le super sayan","21" ,"http://google.fr");
        Scan s2 = new Scan("One piece","Gear second","154" ,"http://google.fr");
        Scan s3 = new Scan("Naruto","Naruto vs Pain","587" ,"http://google.fr");

        scans.add(s1);
        scans.add(s2);
        scans.add(s3);

        return scans;
    }

    public void addScanALire(Scan scan){
        scans.add(scan);
    }

    public void deleteScanALire(){

    }
}
