package retrofittesting.ninehertz.com.retrofittesting.Activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import retrofittesting.ninehertz.com.retrofittesting.Activity.model.Restaurant;
import retrofittesting.ninehertz.com.retrofittesting.R;

/**
 * Created by Lenovo on 12-05-2016.
 */
public class MainActivityAdaptr extends RecyclerView.Adapter<MainActivityAdaptr.MyViewHolder> {

    private List<Restaurant> arraylist;
    private Context context;

    public MainActivityAdaptr(List<Restaurant> list) {
//        this.context = context;
        this.arraylist = list;

    } // MainActivityAdaptr ------------------------------------------


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    } // MyViewHolder -------------------------------------------------


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


}
