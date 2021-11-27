package id.ac.umn.jophoto.HomeSegment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.umn.jophoto.R;

public class HomeImageViewAdapter extends RecyclerView.Adapter<HomeImageViewAdapter.MyViewHolder> {

    private final Context currentContext;
    private final ArrayList<Integer> listImage;

    public HomeImageViewAdapter(Context context, ArrayList<Integer> list) {
        this.currentContext = context;
        this.listImage = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(currentContext).inflate(R.layout.home_image_view_item, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_image_view_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.image.setImageResource(listImage.get(position));
        holder.image.setImageResource(listImage.get(position));
        Log.d("heroism", listImage.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return listImage.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image = itemView.findViewById(R.id.iv_item_home);
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
