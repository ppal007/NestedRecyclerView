package com.ppal007.nestedrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ppal007.nestedrecyclerview.Model.RVModel;
import com.ppal007.nestedrecyclerview.R;

import java.util.ArrayList;

public class ParendRVAdapter extends RecyclerView.Adapter<ParendRVAdapter.ParentViewHolder> {

    private Context context;
    private ArrayList<String> groupList;

    private String[] teamName;
    private int[] teamLogo;

    public ParendRVAdapter(Context context, ArrayList<String> groupList, String[] teamName, int[] teamLogo) {
        this.context = context;
        this.groupList = groupList;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parent_rv_sample, parent, false);

        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

//        set title text...................................................................
        holder.textViewParentTitle.setText(groupList.get(position));

//        initialize child recycler view..............................................
        ArrayList<RVModel> models = new ArrayList<>();
        for (int i = 0; i < teamLogo.length; i++) {
            RVModel model = new RVModel(teamName[i], teamLogo[i]);
            models.add(model);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.recyclerViewChild.setLayoutManager(linearLayoutManager);
        holder.recyclerViewChild.setItemAnimator(new DefaultItemAnimator());
//        get parent item name......................................................................
        String parentName = groupList.get(position);

        ChildRVAdapter childRVAdapter = new ChildRVAdapter(context, models, parentName);
        holder.recyclerViewChild.setAdapter(childRVAdapter);


    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewParentTitle;
        private RecyclerView recyclerViewChild;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewParentTitle = itemView.findViewById(R.id.textViewRVParent_id);
            recyclerViewChild = itemView.findViewById(R.id.recyclerViewChild_id);
        }
    }
}
