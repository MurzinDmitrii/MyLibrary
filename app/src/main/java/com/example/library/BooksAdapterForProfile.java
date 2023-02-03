package com.example.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import java.util.List;
//Класс-адаптер для ListView в профиле
public class BooksAdapterForProfile extends ArrayAdapter<Books>{
    private LayoutInflater inflater;
    private int layout;
    private List<Books> books;
    public BooksAdapterForProfile(Context context, int resource, List<Books> books) {
        super(context, resource, books);
        this.books = books;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView photoView = view.findViewById(R.id.photo);
        TextView nameView = view.findViewById(R.id.name);
        TextView authorView = view.findViewById(R.id.author);
        TextView genreView = view.findViewById(R.id.genre);
        TextView statusView = view.findViewById(R.id.statusView);

        Books book = books.get(position);

        photoView.setImageResource(book.getPhoto());
        nameView.setText(book.getName());
        authorView.setText(book.getAuthor());
        genreView.setText(book.getGenre());
        if(book.getStatus() == true){
            statusView.setText("Взята");
        }
        else{
            statusView.setText("Забронирована");
        }

        return view;
    }
}