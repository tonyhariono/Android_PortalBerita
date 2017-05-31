package id.co.imastudio.latihanportalberita;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tOnY-ROG on 5/19/2017.
 */

public class RetrofitConfig {
    private static Retrofit getRetrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.1.6/serverberita/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static ApiService getInstanceRetrofit(){
        return getRetrofit().create(ApiService.class);
    }
}
