package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ItemClick {
    ContactAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
    }

    private void initAdapter() {
        ArrayList<ContactModel> list = new ArrayList<>();
        list.add(new ContactModel
                ("https://i.ibb.co/XZN7y6j/Gojo-Satoru.png",
                        "Сатору", "Годжо", "наставник",
                        "Из аниме Магическая Битва (24серии)." +
                                "Главный герой Итадори Юджи(он является учеником Сатору)"));
        list.add(new ContactModel
                ("https://shikimori.one/system/characters/original/18769.jpg",
                        "Куроко", "Тэцуя", "Призрачный Шестой Игрок ",
                        "Из аниме Баскетбол Куроко(76серри и 4 фильма).Главный герой Курока Тэцуя"));
        list.add(new ContactModel("https://i.pinimg.com/750x/c4/bc/08/c4bc086314cf27cc69da228490a73d9f.jpg",
                "Ериичи", "Цугикуни", "Охотник на демонов",
                "Из Аниме Клинок рассекающий демонов(26серий).Главный герой Камадо Танджиро"));
        list.add(new ContactModel("https://slovnet.ru/wp-content/uploads/2018/11/11-14.jpg",
                "Бокуто", "Котаро", "ас и капитан волейбольной команды",
                "Из Аниме Волейбол(98серий и 2 фильма).Главный герой Хината"));

        adapter = new ContactAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

    }

    @Override
    public void itemClick(ContactModel model) {
        Toast.makeText(this, model.name, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("key", model);
        startActivity(intent);
       }
}