package com.example.restaurantfinder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantfinder.Models.Reviews;
import com.example.restaurantfinder.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.Holder> {
private Context context;
private List<Reviews> reviews;

public CommentAdapter(Context context, List<Reviews> reviews) {
        this.context = context;
        this.reviews = reviews;
        }

//@NonNull
//@Override
//public CommentAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
   // View v = LayoutInflater.from(context).inflate(R.layout.comment_list, viewGroup, false);
    //return new .Holder(v);
    {

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder (@NonNull CommentAdapter.Holder holder,int i){
        final Reviews review = reviews.get(i);
        holder.tv_cmts.setText(review.getReview());

    }

    @Override
    public int getItemCount () {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private Button btn_cmts;
        private TextView tv_cmts;


        public Holder(@NonNull View itemView) {
            super(itemView);
            btn_cmts.findViewById(R.id.btnComment);
            tv_cmts.findViewById(R.id.tvComment);
        }
    }
}


