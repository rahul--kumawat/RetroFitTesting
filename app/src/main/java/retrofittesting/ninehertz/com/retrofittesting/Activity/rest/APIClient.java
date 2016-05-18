package retrofittesting.ninehertz.com.retrofittesting.Activity.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 10-05-2016.
 */
public class APIClient {

//    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String BASE_URL = "http://demo2server.in/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
