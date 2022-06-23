package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.databinding.ItemContactBinding;

import java.util.ArrayList;

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<ContactModel> list;
    ItemClick listener;

    public ContactAdapter(ArrayList<ContactModel> list,ItemClick listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContactBinding binding = ItemContactBinding.inflate(LayoutInflater.from(parent.
                getContext()),parent,false);
        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(v ->
                listener.itemClick(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        ItemContactBinding binding;

        public ContactViewHolder(ItemContactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ContactModel contactModel) {
            Glide.with(binding.avatarImg).load(contactModel.avatar).circleCrop().into(binding.avatarImg);
            binding.nameTv.setText(contactModel.name);
            binding.surnameTv.setText(contactModel.surname);
            binding.postTv.setText(contactModel.post);
        }
    }
    interface ItemClick {
        void itemClick(ContactModel model);
    }
}
