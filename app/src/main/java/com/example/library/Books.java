package com.example.library;
//класс для книги
public class Books {
    private String name;
    private String author;
    private String genre;
    private int photo;
    private Boolean status;
    private int id;
    public Books(int id, String name, String uthor, String genre, int photo, Boolean status){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.photo = photo;
        this.status = status;//false - бронь, true - взята. Подтягивается из другой страницы
    }//конструктор для "книги в профиле"
    public Books(int id, String name, String author, String genre, int photo){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.photo = photo;
    }//конструктор для "книги на главной странице"
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String name){
        this.author = author;
    }
    public String getGenre(){
        return this.genre;
    }
    public void setGenre(String name){
        this.genre = genre;
    }
    public int getPhoto(){
        return this.photo;
    }
    public void setPhoto(){
        this.photo = photo;
    }
    public Boolean getStatus(){
        return this.status;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }
    public int getId(){
        return this.id;
    }
    public void setId(){
        this.id = id;
    }
}
