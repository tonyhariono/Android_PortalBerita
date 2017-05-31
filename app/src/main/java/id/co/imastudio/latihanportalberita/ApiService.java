package id.co.imastudio.latihanportalberita;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tOnY-ROG on 5/19/2017.
 */

public interface ApiService {
    @GET("getBerita.php")
    Call<ListBeritaModel> ambilBerita();
}
