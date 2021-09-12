package com.farhanrv.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GithubUsersAdapter extends RecyclerView.Adapter<GithubUsersAdapter.ListViewHolder> {
    private final ArrayList<GithubUsers> listGithubUsers;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public GithubUsersAdapter(ArrayList<GithubUsers> list) {
        this.listGithubUsers = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_github_users, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        GithubUsers githubUsers = listGithubUsers.get(position);
        Glide.with(holder.itemView.getContext())
                .load(githubUsers.getAvatar())
                .apply(new RequestOptions().override(60,60))
                .into(holder.imgPhoto);
        holder.tvName.setText(githubUsers.getName());
        holder.tvDetail.setText(githubUsers.getLocation());

        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(listGithubUsers
                .get(holder.getBindingAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listGithubUsers.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(GithubUsers data);
    }
}
