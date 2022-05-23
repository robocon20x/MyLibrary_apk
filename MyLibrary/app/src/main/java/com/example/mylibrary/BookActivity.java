package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private Button btnAddToCurrentlyReading, btnAddToWantToReadList,btnAddToAlreadyReadList,btnAddToFavorites;
    private TextView bookNameText,nameAuthorText,numberPagesText,txtDecription;
    private ImageView bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String longDesc = "Miusov, as a man man of breeding and deilcacy \n could not but feel some inwrd qualms,\n when he reached the Father Superior's with Ivan: he felt ashamed of havin \nlost his temper. He felt that he ought to have disdaimed that despicable wretch, \nFyodor Pavlovitch, too much to have been upset by him in Father Zossima's cell, \nand so to have forgotten himself. Teh monks were not to blame, in any case, he reflceted, on the steps. And if they're decent people here (and the Father Superior, I understand, is a nobleman) why not be friendly and courteous withthem? I won't argue, I'll fall in with everything, I'll win them by politness, and show them that I've nothing to do with that Aesop, thta buffoon, that Pierrot, and have merely been takken in over this affair, just as they have.";
//
//        //TODO: Get the data from recycler in here
//        Book book = new Book(1,"Naruto","Kishi",16,"https://kenh14cdn.com/thumb_w/640/pr/2020/1607432797539-0-111-669-1181-crop-1607432803997-63743074283293.jpg","orphaned",longDesc);
        Intent intent  = getIntent();
        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if(null != incomingBook){
                    setData(incomingBook);

                   package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private Button btnAddToCurrentlyReading, btnAddToWantToReadList,btnAddToAlreadyReadList,btnAddToFavorites;
    private TextView bookNameText,nameAuthorText,numberPagesText,txtDecription;
    private ImageView bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String longDesc = "Miusov, as a man man of breeding and deilcacy \n could not but feel some inwrd qualms,\n when he reached the Father Superior's with Ivan: he felt ashamed of havin \nlost his temper. He felt that he ought to have disdaimed that despicable wretch, \nFyodor Pavlovitch, too much to have been upset by him in Father Zossima's cell, \nand so to have forgotten himself. Teh monks were not to blame, in any case, he reflceted, on the steps. And if they're decent people here (and the Father Superior, I understand, is a nobleman) why not be friendly and courteous withthem? I won't argue, I'll fall in with everything, I'll win them by politness, and show them that I've nothing to do with that Aesop, thta buffoon, that Pierrot, and have merely been takken in over this affair, just as they have.";
//
//        //TODO: Get the data from recycler in here
//        Book book = new Book(1,"Naruto","Kishi",16,"https://kenh14cdn.com/thumb_w/640/pr/2020/1607432797539-0-111-669-1181-crop-1607432803997-63743074283293.jpg","orphaned",longDesc);
        Intent intent  = getIntent();
        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if(null != incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBook(incomingBook);
                }
            }
        }


    }
    private void handleFavoriteBook(Book book){
        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoriteBooks();
        boolean existFavoriteBooks = false;

        for( Book b : favoriteBooks){
            if(b.getId() == book.getId()){
                existFavoriteBooks = true;
            }
        }
        //Enable btnAddtoAlreadyReadList
        //Add a book to AlreadyReadBooks;
        if(existFavoriteBooks){
            btnAddToFavorites.setEnabled(false);
        }
        else{
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).addToFavorite(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO:  navigive the user
                        Intent intent = new Intent(BookActivity.this,FavoriteActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyBooks();
        boolean existCurrentlyReadingBook = false;

        for( Book b : currentlyReadingBooks){
            if(b.getId() == book.getId()){
                existCurrentlyReadingBook = true;
            }
        }
        //Enable btnAddtoAlreadyReadList
        //Add a book to AlreadyReadBooks;
        if(existCurrentlyReadingBook){
            btnAddToCurrentlyReading.setEnabled(false);
        }
        else{
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).addToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO:  navigive the user
                        Intent intent = new Intent(BookActivity.this,CurentlyReadingActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book){
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();
        boolean existWantToReadBooks = false;

        for( Book b : wantToReadBooks){
            if(b.getId() == book.getId()){
                existWantToReadBooks = true;
            }
        }
        //Enable btnAddtoAlreadyReadList
        //Add a book to AlreadyReadBooks;
        if(existWantToReadBooks){
            btnAddToWantToReadList.setEnabled(false);
        }
        else{
            btnAddToWantToReadList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).addToWantToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO:  navigive the user
                        Intent intent = new Intent(BookActivity.this,WantToReadActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();
        boolean existInAlreadyReadBooks = false;

        for( Book b : alreadyReadBooks){
            if(b.getId() == book.getId()){
                existInAlreadyReadBooks = true;
            }
        }
        //Enable btnAddtoAlreadyReadList
        //Add a book to AlreadyReadBooks;
        if(existInAlreadyReadBooks){
            btnAddToAlreadyReadList.setEnabled(false);
        }
        else{
            btnAddToAlreadyReadList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO:  navigive the user
                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book){

        bookNameText.setText(book.getName());
        nameAuthorText.setText(book.getAuthor());
        numberPagesText.setText(String.valueOf(book.getPages()));
        txtDecription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageURL())
                .into(bookImage);
    }

    private void initViews() {
        bookNameText = findViewById(R.id.bookNameText);
        nameAuthorText = findViewById(R.id.nameAuthorText);
        numberPagesText = findViewById(R.id.numberPagesText);
        txtDecription = findViewById(R.id.txtDecription);

        btnAddToCurrentlyReading = findViewById(R.id.btnAddtoCurrentlyReading);
        btnAddToWantToReadList = findViewById(R.id.btnAddToWantToReadList);
        btnAddToAlreadyReadList = findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);

        bookImage = findViewById(R.id.bookImage);
    }
}