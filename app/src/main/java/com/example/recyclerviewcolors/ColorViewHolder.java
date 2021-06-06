package com.example.recyclerviewcolors;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ColorViewHolder extends RecyclerView.ViewHolder {
    TextView tv;
    Context context;

    public ColorViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.color);
        context = itemView.getContext();
        // создать объекты интерфейса и
        // повешать обработчики событий
    }
    void bindTo(Integer color) {
        // заполнить объекты интерфейса значениями (данными)
        // TODO: задать цвет у текстового поля
        // TODO: написать название цвета в текстовом поле
        tv.setText("color:" + color);
        tv.setBackgroundColor(color);
    }

    String matchColor(int colorValue) {
        ArrayList<Integer> keyVals = MainActivity.colorsValues;
        //т.к. порядок названия соответствует порядку кодировки цвета, программа выводит заданый цвет с его названием
        for (int i = 0; i < keyVals.size(); i++) {
            if (keyVals.get(i) == color_code) {
                return MainActivity.color_name.get(i);
            }
        }
        return "";
    }

}
