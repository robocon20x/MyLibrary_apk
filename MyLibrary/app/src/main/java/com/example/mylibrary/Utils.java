package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEY= "all_books";
    private static final String ALREADY_READ_BOOKS ="already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_book";

    private static Utils instance;
    private SharedPreferences sharedPreferences;

//    private static ArrayList<Book> allBooks;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyBooks;
//    private static ArrayList<Book> favoriteBooks;




    private Utils (Context context){
        sharedPreferences = context.getSharedPreferences("alternate_db",Context.MODE_PRIVATE);

        if(getAllBooks() == null){
            initData();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if(getAlreadyReadBooks() == null){
           editor.putString(ALREADY_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
           editor.commit();
        }
        if(null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getCurrentlyBooks()){
            editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getFavoriteBooks()){
            editor.putString(FAVORITE_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {
        ArrayList<Book> books = new ArrayList<>();
        String longdesc = "Duong's story in 2021"+ "\n"+
                "He is an introversion and he just like a kid too." +"\n" +
                "Cound't find purpose of life, playing game with friend, join in some crazy party day by day." +"\n" +
                "After all, the only thing he had just loneliness & stress." +"\n" +
                "But now he find his purpose in a day of september." +"\n" +
                "Let see what can he do and will his 2021 be better."+ "\n"+
                "Can you continue the story with him?";
        books.add(new Book(1,"My story in 2021","TruongDuong and...",1,"https://i.postimg.cc/2SM3fx0r/1-png.jpg","useless",longdesc));
        books.add(new Book(2,"OnePiece","Oda",16,"https://images6.alphacoders.com/606/thumb-1920-606263.jpg","king","Long desc"));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new  Gson();
        editor.putString(ALL_BOOKS_KEY,gson.toJson(books));
        editor.commit();

    }


    public static Utils getInstance(Context context) {
        if(instance == null){
            instance = new Utils(context);
        }
        return instance;
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY,null),type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEY= "all_books";
    private static final String ALREADY_READ_BOOKS ="already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_book";

    private static Utils instance;
    private SharedPreferences sharedPreferences;

//    private static ArrayList<Book> allBooks;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyBooks;
//    private static ArrayList<Book> favoriteBooks;




    private Utils (Context context){
        sharedPreferences = context.getSharedPreferences("alternate_db",Context.MODE_PRIVATE);

        if(getAllBooks() == null){
            initData();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if(getAlreadyReadBooks() == null){
           editor.putString(ALREADY_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
           editor.commit();
        }
        if(null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getCurrentlyBooks()){
            editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getFavoriteBooks()){
            editor.putString(FAVORITE_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {
        ArrayList<Book> books = new ArrayList<>();
        String longdesc = "Duong's story in 2021"+ "\n"+
                "He is an introversion and he just like a kid too." +"\n" +
                "Cound't find purpose of life, playing game with friend, join in some crazy party day by day." +"\n" +
                "After all, the only thing he had just loneliness & stress." +"\n" +
                "But now he find his purpose in a day of september." +"\n" +
                "Let see what can he do and will his 2021 be better."+ "\n"+
                "Can you continue the story with him?";
        books.add(new Book(1,"My story in 2021","TruongDuong and...",1,"https://i.postimg.cc/2SM3fx0r/1-png.jpg","useless",longdesc));
        books.add(new Book(2,"OnePiece","Oda",16,"https://images6.alphacoders.com/606/thumb-1920-606263.jpg","king","Long desc"));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new  Gson();
        editor.putString(ALL_BOOKS_KEY,gson.toJson(books));
        editor.commit();

    }


    public static Utils getInstance(Context context) {
        if(instance == null){
            instance = new Utils(context);
        }
        return instance;
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY,null),type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS,null),type);
        return books;
    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS,null),type);
        return books;
    }

    public ArrayList<Book> getCurrentlyBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS,null),type);
        return books;
    }

    public ArrayList<Book> getFavoriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS,null),type);
        return books;
    }

    public Book getBookById(int id){
        ArrayList<Book> books= getAllBooks();
        if(null != books){
            for(Book b: books){
                if(b.getId() == id) return b;
            }
        }

        return null;
    }

    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToFavorite(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book){
       ArrayList<Book> books = getAlreadyReadBooks();
       if(null != books){
           for(Book b:books){
               if(b.getId() == book.getId()){
                   if(books.remove(book)){
                       Gson gson = new Gson();
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.remove(ALREADY_READ_BOOKS);
                       editor.putString(ALREADY_READ_BOOKS,gson.toJson(books));
                       editor.commit();
                       return true;
                   }
               }
           }
       }
       return false;
    }
    public boolean removeFromWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(null != books){
            for(Book b:books){
                if(b.getId() == book.getId()){
                    if(books.remove(book)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyBooks();
        if(null != books){
            for(Book b:books){
                if(b.getId() == book.getId()){
                    if(books.remove(book)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromFavorite(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if(null != books){
            for(Book b:books){
                if(b.getId() == book.getId()){
                    if(books.remove(book)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
