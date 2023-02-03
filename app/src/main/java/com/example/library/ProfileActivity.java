package com.example.library;
//Страница профиля
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    ArrayList<Books> books = new ArrayList<Books>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Определение темы
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                imageView.setImageResource(R.drawable.img_dark);
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                imageView.setImageResource(R.drawable.img_light);
                break;
        }
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        ListView booksList = findViewById(R.id.booksList);
        // создаем адаптер
        BooksAdapterForProfile booksAdapter = new BooksAdapterForProfile(this, R.layout.list_item_for_profile, books);
        // устанавливаем адаптер
        booksList.setAdapter(booksAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Books selectedBook = (Books)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedBook.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        booksList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){
        //Тестовые данные
        books.add(new Books (1,"Тест1", "ТестАвтора1","ТестЖанра1", R.drawable.img,false));
        books.add(new Books (2,"Тест2", "ТестАвтора2","ТестЖанра2", R.drawable.img_1,true));
        books.add(new Books (3,"Тест1", "ТестАвтора1","ТестЖанра1", R.drawable.img,false));
        books.add(new Books (4,"Тест2", "ТестАвтора2","ТестЖанра2", R.drawable.img_1, false));
        books.add(new Books (5,"Тест1", "ТестАвтора1","ТестЖанра1", R.drawable.img, true));
        books.add(new Books (6,"Тест2", "ТестАвтора2","ТестЖанра2", R.drawable.img_1, true));
    }
}