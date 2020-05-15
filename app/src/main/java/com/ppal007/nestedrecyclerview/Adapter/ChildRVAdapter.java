package com.ppal007.nestedrecyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ppal007.nestedrecyclerview.GalleryActivity;
import com.ppal007.nestedrecyclerview.Model.RVModel;
import com.ppal007.nestedrecyclerview.R;

import java.util.ArrayList;

public class ChildRVAdapter extends RecyclerView.Adapter<ChildRVAdapter.ChildViewHolder> {

    private Context context;
    private ArrayList<RVModel> rvModels;
    private String parentName;

    public ChildRVAdapter(Context context, ArrayList<RVModel> rvModels, String parentName) {
        this.context = context;
        this.rvModels = rvModels;
        this.parentName = parentName;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_rv_sample, parent, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, final int position) {

//        set title and image in child.......................................................
        holder.textViewChild.setText(rvModels.get(position).getTeamName());
        holder.imageViewChild.setImageResource(rvModels.get(position).getTeamLogo());

//        click listener.................................................................
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int path = rvModels.get(position).getTeamLogo();

                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("ex_name", rvModels.get(position).getTeamName());
                intent.putExtra("ex_logo", path);
                intent.putExtra("ex_parent_name", parentName);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return rvModels.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewChild;
        private ImageView imageViewChild;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewChild = itemView.findViewById(R.id.tv_recycler_sample);
            imageViewChild = itemView.findViewById(R.id.imageview_recycler_sample);

        }
    }
}
