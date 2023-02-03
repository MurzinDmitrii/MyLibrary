package com.example.library;
//Страница авторизации
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBookActivity.class);
                startActivity(intent);
            }
        });
    }
}