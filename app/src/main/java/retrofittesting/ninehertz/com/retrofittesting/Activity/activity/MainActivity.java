package retrofittesting.ninehertz.com.retrofittesting.Activity.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofittesting.ninehertz.com.retrofittesting.Activity.adapter.MainActivityAdaptr;
import retrofittesting.ninehertz.com.retrofittesting.Activity.model.Restaurant;
import retrofittesting.ninehertz.com.retrofittesting.Activity.model.RestaurantResponse;
import retrofittesting.ninehertz.com.retrofittesting.Activity.rest.APIClient;
import retrofittesting.ninehertz.com.retrofittesting.Activity.rest.ApiInterface;
import retrofittesting.ninehertz.com.retrofittesting.R;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private String api_type = "GETRESTAURANT";
    private String signature = "76a4a8b3b4952a6de0b035d920785376d23fb10b";

    private RecyclerView recyclerView;
    MainActivityAdaptr adapter;
    private List<Restaurant> restaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new MainActivityAdaptr(restaurants);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("type", api_type);
        map.put("signature", signature);

        JsonArray jsonArray = new JsonArray();
        JsonObject json_obj = new JsonObject();
        json_obj.addProperty("userid", "12");
        json_obj.addProperty("city", "jaipur");
        jsonArray.add(json_obj);
        map.put("data", jsonArray.toString());

        Call<RestaurantResponse> call = apiInterface.getRestaurantList(map);
        call.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
//                List<Restaurant> restaurants = response.body().getRestaurants();
//                Log.d(TAG, "response: " + response.body().getRestaurants());
                Log.w("2.0 getFeed > Full json", new Gson().toJson(response));
                restaurants = response.body().getRestaurants();
                Log.d(TAG, "Number of restaurants received: " + response.body().getStatus());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });



//        Call<MovieResponse> call = apiInterface.getTopRatedMoies(api_key);
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                List<Movie> movies = response.body().getResults();
//                Log.d(TAG, "Number of movies received: " + movies.get(0).getOverview());
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Log.e(TAG, t.toString());
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
