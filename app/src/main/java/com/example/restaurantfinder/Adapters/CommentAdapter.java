package com.example.restaurantfinder.Adapters;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.Holder> {
private Context context;
private List<Reviews> reviews;

public CommentAdapter(Context context, List<Reviews> reviews) {
        this.context = context;
        this.reviews = reviews;
        }

@NonNull
@Override
public CommentAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.comment_list, viewGroup, false);
        return new Holder(v); {

}
