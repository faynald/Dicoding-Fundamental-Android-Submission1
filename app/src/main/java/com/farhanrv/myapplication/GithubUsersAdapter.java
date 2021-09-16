package com.farhanrv.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.farhanrv.myapplication.databinding.ItemGithubUsersBinding;

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
        ItemGithubUsersBinding binding = ItemGithubUsersBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        GithubUsers githubUsers = listGithubUsers.get(position);
        Glide.with(holder.itemView.getContext())
                .load(githubUsers.getAvatar())
                .apply(new RequestOptions().override(60,60))
                .into(holder.binding.imgItemPhoto);
        holder.binding.tvItemName.setText(githubUsers.getName());
        holder.binding.tvItemDetail.setText(githubUsers.getLocation());

        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(listGithubUsers
                .get(holder.getBindingAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listGithubUsers.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ItemGithubUsersBinding binding;

        public ListViewHolder(ItemGithubUsersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(GithubUsers data);
    }
}
