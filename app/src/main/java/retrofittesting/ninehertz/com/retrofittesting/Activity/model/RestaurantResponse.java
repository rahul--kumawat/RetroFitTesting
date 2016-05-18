package retrofittesting.ninehertz.com.retrofittesting.Activity.model;

import java.util.ArrayList;

/**
 * Created by Lenovo on 10-05-2016.
 */
public class RestaurantResponse {

    public ArrayList<Restaurant> getRestaurants() {
        return Restaurant;
    }

    public void setRestaurants(ArrayList<Restaurant> Restaurants) {
        this.Restaurant = Restaurants;
    }

    ArrayList<Restaurant> Restaurant;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal_records() {
        return total_records;
    }

    public void setTotal_records(String total_records) {
        this.total_records = total_records;
    }

    public String total_records;
    String status;
}
