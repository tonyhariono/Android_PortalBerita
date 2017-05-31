package id.co.imastudio.latihanportalberita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;

    ArrayList<BeritaModel> listBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBerita=new ArrayList<>();

        //masukkan data dummy
/*
        BeritaModel berita1=new BeritaModel("1","Judul Berita 1","Deskripsi Berita 1","http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-5/256/announcements-icon.png");
        listBerita.add(berita1);

        BeritaModel berita2=new BeritaModel("2","Judul Berita 2","Deskripsi Berita 2","http://icons.iconarchive.com/icons/designcontest/ecommerce-business/256/news-icon.png");
        listBerita.add(berita2);

        BeritaModel berita3=new BeritaModel("3","Judul Berita 3","Deskripsi Berita 3","http://icons.iconarchive.com/icons/bevel-and-emboss/media/256/news-icon.png");
        listBerita.add(berita3);

        BeritaModel berita4=new BeritaModel("4","Judul Berita 4","Deskripsi Berita 4","http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/256/Mimetypes-message-news-icon.png");
        listBerita.add(berita4);

        BeritaModel berita5=new BeritaModel("5","Judul Berita 5","Deskripsi Berita 5","http://icons.iconarchive.com/icons/pelfusion/long-shadow-ios7/128/News-icon.png");
        listBerita.add(berita5);

        BeritaModel berita6=new BeritaModel("6","Judul Berita 6","Deskripsi Berita 6","http://icons.iconarchive.com/icons/pelfusion/folded-flat/128/News-icon.png");
        listBerita.add(berita6);

        BeritaModel berita7=new BeritaModel("7","Judul Berita 7","Deskripsi Berita 7","http://icons.iconarchive.com/icons/paomedia/small-n-flat/128/news-icon.png");
        listBerita.add(berita7);

        BeritaModel berita8=new BeritaModel("8","Judul Berita 8","Deskripsi Berita 8","http://icons.iconarchive.com/icons/dtafalonso/android-lollipop/128/News-And-Weather-icon.png");
        listBerita.add(berita8);

        BeritaModel berita9=new BeritaModel("9","Judul Berita 9","Deskripsi Berita 9","http://icons.iconarchive.com/icons/musett/coffee-shop/128/Newspaper-icon.png");
        listBerita.add(berita9);

        BeritaModel berita10=new BeritaModel("10","Judul Berita 10","Deskripsi Berita 10","http://icons.iconarchive.com/icons/itzikgur/my-seven/128/Newspapers-2-icon.png");
        listBerita.add(berita10);

        //contoh pake method set
        BeritaModel berita11=new BeritaModel();
        berita11.setId("11");
        berita11.setDeskripsi("Deskripsi 11 pake set");
        berita11.setGambar("http://icons.iconarchive.com/icons/dakirby309/windows-8-metro/128/Web-Fox-News-Metro-icon.png");
        berita11.setJudul("Judul Berita 11 pake set");
        listBerita.add(berita11);

        for (int i=12;i<15;i++){
            BeritaModel berita=new BeritaModel();
            berita.setId(Integer.toString(i));
            berita.setDeskripsi("Deskripsi " + Integer.toString(i) + " pake set");
            berita.setGambar("http://icons.iconarchive.com/icons/dakirby309/windows-8-metro/128/Web-Fox-News-Metro-icon.png");
            berita.setJudul("Judul Berita " + Integer.toString(i) + " pake set");
            listBerita.add(berita);
        }
*/
        // ambil data online
        getData();




    }

    private void getData() {
        ApiService service=RetrofitConfig.getInstanceRetrofit();
        Call<ListBeritaModel> call=service.ambilBerita();
        call.enqueue(new Callback<ListBeritaModel>() {
            @Override
            public void onResponse(Call<ListBeritaModel> call, Response<ListBeritaModel> response) {
                if (response.isSuccessful()){
                    listBerita=response.body().getDataBerita();

                    recycler = (RecyclerView) findViewById(R.id.recyclerView);
                    //setAdapter
                    BeritaAdapter adapter=new BeritaAdapter(MainActivity.this,listBerita);
                    recycler.setAdapter(adapter);

                    LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
                    recycler.setLayoutManager(layoutManager);
                }
            }

            @Override
            public void onFailure(Call<ListBeritaModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error get data "+call.toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
