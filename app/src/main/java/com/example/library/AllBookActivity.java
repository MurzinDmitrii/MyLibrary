package com.example.library;
//Главная страница со всеми книгами
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class AllBookActivity extends AppCompatActivity {
    ArrayList<Books> books = new ArrayList<Books>();
    ListView booksList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_book);
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
        booksList = findViewById(R.id.booksList);
        // создаем адаптер
        BooksAdapter booksAdapter = new BooksAdapter(this, R.layout.list_item_books, books);
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
        Button button = (Button)findViewById(R.id.profileButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AllBookActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setInitialData(){
        //Тестовые данные
        books.add(new Books (1,"Тест1", "ТестАвтора1","ТестЖанра1", R.drawable.img));
        books.add(new Books (2,"Тест2", "ТестАвтора2","ТестЖанра2", R.drawable.img_1));
        books.add(new Books (3,"Тест1", "ТестАвтора1","ТестЖанра1", R.drawable.img));
        books.add(new Books (4,"Тест2", "ТестАвтора2","ТестЖанра2", R.drawable.img_1));
        books.add(new Books (5,"Тест1", "ТестАвтора1","ТестЖанра1", R.drawable.img));
        books.add(new Books (6,"Тест2", "ТестАвтора2","ТестЖанра2", R.drawable.img_1));
    }
}