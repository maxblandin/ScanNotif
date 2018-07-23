package com.mb.manga.scannotif.tools;

import android.os.AsyncTask;

import com.mb.manga.scannotif.dto.ScanListParcelable;
import com.mb.manga.scannotif.dto.ScanParcelable;
import com.mb.manga.scannotif.model.Scan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScanTools {
    public List<Scan> listParcelableToListScan(ScanListParcelable lstParcelable){
        List<Scan> scans = new ArrayList<Scan>();
        Scan scan;
        int index = 1;
        String[] splitNomScan;
        String[] splitAllInfo;
        String nomManga = "";

        for(ScanParcelable s : lstParcelable){
            scan = new Scan();
            splitNomScan = s.getTitle().split(": ");

            try {
                if(splitNomScan.length < 3) {
                    scan.setNomScan(splitNomScan[1].toString());
                }
            }catch (IndexOutOfBoundsException e){
                scan.setNomScan("");
            }

            splitAllInfo = splitNomScan[0].split(" ");

            while(index != splitAllInfo.length){
                if(index > 0 && index < splitAllInfo.length -2){
                    if (index == 1){
                        nomManga = nomManga + splitAllInfo[index];
                    }else {
                        nomManga = nomManga + " " + splitAllInfo[index];
                    }
                }else if(index == splitAllInfo.length -2){
                    scan.setNumScan(splitAllInfo[index]);
                }else if(index == splitAllInfo.length -1){
                    if(splitNomScan.length > 2){
                        scan.setVersionScan(splitNomScan[2].toString());
                    }else{
                        scan.setVersionScan(splitAllInfo[index]);
                    }
                }
                index++;
            }
            scan.setNomManga(nomManga);
            scan.setLien(s.getLink());
            scans.add(scan);


            nomManga = "";
            index = 1;
        }

        return scans;
    }
}
