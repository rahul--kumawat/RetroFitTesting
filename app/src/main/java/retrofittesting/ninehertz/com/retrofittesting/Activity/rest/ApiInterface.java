package retrofittesting.ninehertz.com.retrofittesting.Activity.rest;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofittesting.ninehertz.com.retrofittesting.Activity.model.MovieResponse;
import retrofittesting.ninehertz.com.retrofittesting.Activity.model.RestaurantResponse;

/**
 * Created by Lenovo on 10-05-2016.
 */
public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMoies(@Query("api_key") String api_key);

    @GET("sites/mobile/dive/services/ws-restaurant.php")
    Call<RestaurantResponse> getRestaurantList(@QueryMap HashMap<String, String> map);


//    http://demo2server.in/sites/mobile/dive/services/ws-restaurant.php?type=GETRESTAURANT&signature=76a4a8b3b4952a6de0b035d920785376d23fb10b&data=
//    // [{%22userid%22:%2212%22,%22city%22:%22jaipur%22}]

//    @GET("movie/{id}")
//    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
