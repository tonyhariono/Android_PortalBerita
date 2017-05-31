package id.co.imastudio.latihanportalberita;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tOnY-ROG on 5/19/2017.
 */

public class BeritaModel {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("judul")
    @Expose
    private String judul;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    @SerializedName("gambar")
    @Expose
    private String gambar;

    //generate constructor

    //data dummy
    public BeritaModel(String id, String judul, String deskripsi, String gambar) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    //dari online
    public BeritaModel() {
    }

    //generate > getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
