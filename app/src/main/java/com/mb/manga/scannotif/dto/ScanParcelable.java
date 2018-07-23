package com.mb.manga.scannotif.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class ScanParcelable implements Parcelable {
    private String id;
    private String title;
    private String link;
    private String description;
    private String pubDate;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public ScanParcelable(){};
    public ScanParcelable(Parcel in){
        this.getFromParcel(in);
    }

    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
        public ScanParcelable createFromParcel(Parcel in)
        {
            return new ScanParcelable(in);
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

    //On ecrit dans le parcel les données de notre objet
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.link);
        dest.writeString(this.pubDate);
    }

    //On va ici hydrater notre objet à partir du Parcel
    public void getFromParcel(Parcel in)
    {
        this.setId(in.readString());
        this.setTitle(in.readString());
        this.setDescription(in.readString());
        this.setLink(in.readString());
        this.setPubDate(in.readString());
    }
}

