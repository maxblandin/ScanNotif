package com.mb.manga.scannotif.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.mb.manga.scannotif.model.Scan;

import java.util.ArrayList;

public class ScanListParcelable extends ArrayList<ScanParcelable> implements Parcelable {
    public ScanListParcelable(){}
    public ScanListParcelable(Parcel in){
        this.getFromParcel(in);
    }
    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
        public ScanListParcelable createFromParcel(Parcel in)
        {
            return new ScanListParcelable(in);
        }

        @Override
        public Object[] newArray(int size) {
            return null;
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        //Taille de la liste
        int size = this.size();
        dest.writeInt(size);
        for(int i=0; i < size; i++)
        {
            ScanParcelable scan = this.get(i); //On vient lire chaque objet personne
            dest.writeString(scan.getTitle());
            dest.writeString(scan.getDescription());
            dest.writeString(scan.getLink());
            dest.writeString(scan.getPubDate());
        }
    }

    public void getFromParcel(Parcel in)
    {
        // On vide la liste avant tout remplissage
        this.clear();

        //Récupération du nombre d'objet
        int size = in.readInt();

        //On repeuple la liste avec de nouveau objet
        for(int i = 0; i < size; i++)
        {
            ScanParcelable scan = new ScanParcelable();
            scan.setTitle(in.readString());
            scan.setDescription(in.readString());
            scan.setLink(in.readString());
            scan.setPubDate(in.readString());
            this.add(scan);
        }
    }
}

