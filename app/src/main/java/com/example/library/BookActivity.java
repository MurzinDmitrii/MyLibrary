package com.example.library;
//Страница с конкретной книгой
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                imageView.setImageResource(R.drawable.img_dark);
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                imageView.setImageResource(R.drawable.img_light);
                break;
        }
    }
}