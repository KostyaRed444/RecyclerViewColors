package com.example.recyclerviewcolors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rview;
    // TODO: создать массив с цветами (которые заданы в ресурсах)
    public static ArrayList<Integer> color_code = new ArrayList<>();
    public static ArrayList<String> color_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //создаём массив значений кода для цветов и получаем его из файла в ресурсах
        int[] colors_raw = getResources().getIntArray(R.array.color_object);
        for (int c : colors_raw) {
            //полученное значение вносим в массив в кодами
            color_code.add(c);
        }
        //получаем название цвета
        color_names = new ArrayList<String>(
                Arrays.asList(getResources().getStringArray(R.array.color_names)));

        rview = findViewById(R.id.rview);

        ColorAdapter adapter = new ColorAdapter(getLayoutInflater());
        adapter.submitList(color_code);

        rview.setLayoutManager(new LinearLayoutManager(this));
        // задаём оформление
        rview.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rview.setAdapter(adapter);

    }
}