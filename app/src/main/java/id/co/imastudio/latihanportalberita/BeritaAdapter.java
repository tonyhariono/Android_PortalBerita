package id.co.imastudio.latihanportalberita;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by tOnY-ROG on 5/19/2017.
 */

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    Context context;
    ArrayList<BeritaModel> listBerita;

    //generate constructor
    public BeritaAdapter(Context context, ArrayList<BeritaModel> listBerita) {
        this.context = context;
        this.listBerita = listBerita;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate layout item
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(R.layout.item_berita,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // eventhandling
        holder.judulBerita.setText(listBerita.get(position).getJudul());
        Glide.with(context)
                .load("http://192.168.1.8:8080/serverberita/foto_berita/"+listBerita.get(position).getGambar())
                .into(holder.gambarBerita);

        //mengarahkan ke detail berita
        holder.judulBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent
                Intent pindah=new Intent(context,item_berita_detailActivity.class);

                //putextra
                pindah.putExtra("DATA_JUDUL",listBerita.get(position).getJudul());
                pindah.putExtra("DATA_GAMBAR","http://192.168.1.8:8080/serverberita/foto_berita/"+listBerita.get(position).getGambar());
                pindah.putExtra("DATA_DESKRIPSI",listBerita.get(position).getDeskripsi());

                //start aktivity
                context.startActivity(pindah);

            }
        });
    }

    @Override
    public int getItemCount() {
        //jumlah list
        return listBerita.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView judulBerita;
        private final ImageView gambarBerita;

        public ViewHolder(View itemView) {
            super(itemView);

            judulBerita=(TextView) itemView.findViewById(R.id.tvBerita);
            gambarBerita=(ImageView) itemView.findViewById(R.id.ivBerita);
            //alt+enter->add field in ViewHolder
        }
    }




}
