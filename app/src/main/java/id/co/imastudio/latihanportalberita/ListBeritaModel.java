package id.co.imastudio.latihanportalberita;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by tOnY-ROG on 5/19/2017.
 */

public class ListBeritaModel {
    @SerializedName("berita")
    @Expose

    private ArrayList<BeritaModel> dataBerita= new ArrayList<>();

    //getter and setter

    public ArrayList<BeritaModel> getDataBerita() {
        return dataBerita;
    }

    public void setDataBerita(ArrayList<BeritaModel> dataBerita) {
        this.dataBerita = dataBerita;
    }
}
