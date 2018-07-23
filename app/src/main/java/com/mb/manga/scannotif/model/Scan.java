package com.mb.manga.scannotif.model;


    public class Scan{
    private String nomManga;
    private String nomScan;
    private String numScan;
    private String versionScan;
    private String lien;

    public String getNomManga() {
            return nomManga;
            }
    public void setNomManga(String nomManga) {this.nomManga = nomManga;}

    public String getNomScan() {
            return nomScan;
        }
    public void setNomScan(String nomScan) {
            this.nomScan = nomScan;
        }

    public String getNumScan() {
            return numScan;
            }
    public void setNumScan(String numScan) {
            this.numScan = numScan;
            }

    public String getVersionScan() {
            return versionScan;
            }
    public void setVersionScan(String versionScan) {
            this.versionScan = versionScan;
            }

    public String getLien() {
            return lien;
            }
    public void setLien(String lien) {
            this.lien = lien;
            }

    public Scan() {}
    public Scan(String nomManga, String nomScan, String numScan, String lien) {
            this.nomManga = nomManga;
            this.nomScan = nomScan;
            this.numScan = numScan;
            this.lien = lien;
    }
    public Scan(String nomManga, String nomScan, String numScan, String versionScan, String lien) {
            this.nomManga = nomManga;
            this.nomScan = nomScan;
            this.numScan = numScan;
            this.versionScan = versionScan;
            this.lien = lien;
    }
}
