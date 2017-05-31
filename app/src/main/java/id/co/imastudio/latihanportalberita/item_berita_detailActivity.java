package id.co.imastudio.latihanportalberita;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class item_berita_detailActivity extends AppCompatActivity {

    ImageView ivBerita;
//    TextView tvDetailBerita;
    WebView wvDetailBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_berita_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String dataJudul=getIntent().getStringExtra("DATA_JUDUL");
        String dataGambar=getIntent().getStringExtra("DATA_GAMBAR");
        String dataDeskripsi=getIntent().getStringExtra("DATA_DESKRIPSI");

        Log.i("DATA",""+dataJudul+dataGambar+dataDeskripsi);

        //tampilkan data
        getSupportActionBar().setTitle(dataJudul);

        ivBerita=(ImageView) findViewById(R.id.ivGambarBerita);
        wvDetailBerita=(WebView) findViewById(R.id.wvDetailBerita);

        Glide.with(item_berita_detailActivity.this)
                .load(dataGambar)
                .into(ivBerita);

//        tvDetailBerita.setText(dataDeskripsi);
        wvDetailBerita.loadData(dataDeskripsi,"text/html","UTF-8");
    }
}
