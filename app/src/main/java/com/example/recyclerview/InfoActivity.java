package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.recyclerview.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {
    ActivityInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater()); 
        setContentView(binding.getRoot());
        setUi();
    }

    private void setUi() {
        if (getIntent() != null) {
            ContactModel model = (ContactModel) getIntent().getSerializableExtra("key");
          Glide.with(binding.imgAvater).load(model.avatar).circleCrop().into(binding.imgAvater);
            binding.tvName.setText(model.name);
            binding.tvAnimeName.setText(model.post);
            binding.tvDescription.setText(model.description);
        }
    }
}
