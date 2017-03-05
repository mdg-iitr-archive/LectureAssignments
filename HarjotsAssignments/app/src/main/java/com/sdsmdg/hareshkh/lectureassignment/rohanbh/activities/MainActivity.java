package com.sdsmdg.hareshkh.lectureassignment.rohanbh.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.hareshkh.lectureassignment.rohanbh.adapters.MoviesAdapter;
import com.sdsmdg.hareshkh.lectureassignment.rohanbh.modelclasses.MovieClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MovieClass> myMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMovies.add(new MovieClass("The Dark Knight Rises", "2012", "@drawable/batman"));
        myMovies.add((new MovieClass("Dragon Ball Z: Battle of Gods", "2013", "@drawable/battleofgods")));
        myMovies.add(new MovieClass("Captain America: Civil War", "2016", "@drawable/civilwar"));
        myMovies.add(new MovieClass("Furious 7", "2015", "@drawable/furious"));
        myMovies.add(new MovieClass("Harry Potter and the Deathly Hallows – Part 2", "2011", "@drawable/harrypotter"));
        myMovies.add(new MovieClass("Kung Fu Panda 3", "2016", "@drawable/panda"));
        myMovies.add(new MovieClass("Dragon Ball Z: Resurrection ‘F’", "2015", "@drawable/revivalf"));
        myMovies.add(new MovieClass("The Amazing Spider-Man 2", "2014", "@drawable/amazing"));
        myMovies.add(new MovieClass("Avatar", "2009", "@drawable/avatar"));
        myMovies.add(new MovieClass("The Dark Knight", "2008", "@drawable/dark"));
        myMovies.add(new MovieClass("Deadpool", "2016", "@drawable/deadpool"));
        myMovies.add(new MovieClass("Star Wars: The Force Awakens", "2015", "@drawable/star"));
        myMovies.add(new MovieClass("Titanic", "1997", "@drawable/titanic"));
        myMovies.add(new MovieClass("Avengers: Age of Ultron", "2015", "@drawable/ultron"));


        RecyclerView movieList = (RecyclerView) findViewById(R.id.my_recycler_view);
        MoviesAdapter adapter = new MoviesAdapter(myMovies, this);
        movieList.setAdapter(adapter);
        movieList.setLayoutManager(new LinearLayoutManager(this));
        movieList.setHasFixedSize(true);
    }
}
