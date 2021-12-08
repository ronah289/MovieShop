package com.example.movieshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.available_movies) ListView allMovies;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.my_profile) Button Profile;
    private final String[] movies = new String[]{"To Kill a Mockingbird","The Godfather","Little Women","The Color Purple","The Wizard of Oz","The Remains of the Day","Sense and Sensibility","Forrest Gump","Hidden Figures","Schindler’s List","Harry Potter"};
    private final String[] authors = new String[]{"Harper Lee","Mario Puzo","Louisa May Alcott","Alice Walker","L. Frank Baum","Kazuo Ishiguro","Emma Thompson","Winston Groom","Margot Lee Shetterly","Thomas Keneally","J.K Rowling"};
    private final int[] yearPublished = new int[]{1962,1972,2019,1985,1939,1993,1995,1994,2016,1993,2002};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);
        Profile.setOnClickListener(this);
        allMovies = findViewById(R.id.available_movies);
        TextView userWelcome = findViewById(R.id.welcomeUser);
        MoviesArrayAdapter adapter = new MoviesArrayAdapter(this, android.R.layout.simple_list_item_1, movies,authors,yearPublished);
        allMovies.setAdapter(adapter);
        allMovies.setOnItemClickListener((adapterView, view, position, length) -> {
            String author = ((TextView)view).getText().toString();
            Toast details = Toast.makeText(MoviesActivity.this, author, Toast.LENGTH_SHORT);
            details.setGravity(Gravity.CENTER, 0, -200);
            details.show();
        });
        Intent usernameIntent = getIntent();
        String username = usernameIntent.getStringExtra("username");
        userWelcome.setText(String.format("Welcome %s", username));
    }
    @Override
    public void onClick(View view){
        if(view == Profile){
            Intent usernameIntent = getIntent();
            String username = usernameIntent.getStringExtra("username");
            Intent intent = new Intent(MoviesActivity.this, ProfileActivity.class);
            intent.putExtra("username",username);
            startActivity(intent);
        }
    }
}