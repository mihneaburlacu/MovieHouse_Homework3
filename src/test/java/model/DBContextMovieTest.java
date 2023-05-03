package model;

import model.Enums.Role;
import model.Enums.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBContextMovieTest {
    @Test
    public void testInsert() {
        Movie movie = new Movie(19, "The Godfather", Type.ARTISTIC, "Drama", 1972, 10);

        DBContextMovie context = new DBContextMovie();
        context.insert(movie);

        Assertions.assertEquals(context.findMovie(context.createFindQueryByID(19)), movie);

        context.deleteMovie(context.createDeleteQueryByID(19));
    }

    @Test
    public void testDeleteByID() {
        Movie movie = new Movie(19, "The Godfather", Type.ARTISTIC, "Drama", 1972, 10);

        DBContextMovie context = new DBContextMovie();
        context.insert(movie);

        String query = context.createDeleteQueryByID(19);
        context.deleteMovie(query);

        Movie retrievedMovie = context.findMovie(context.createFindQueryByID(19));

        Assertions.assertNull(retrievedMovie);
    }

    @Test
    public void testDeleteByName() {
        Movie movie = new Movie(19, "The Godfather", Type.ARTISTIC, "Drama", 1972, 10);

        DBContextMovie context = new DBContextMovie();
        context.insert(movie);

        String query = context.createDeleteQueryByName("The Godfather");
        context.deleteMovie(query);

        Movie retrievedMovie = context.findMovie(context.createFindQueryByID(19));

        Assertions.assertNull(retrievedMovie);
    }

    @Test
    public void testFindByID() {
        DBContextMovie context = new DBContextMovie();
        String query = context.createFindQueryByID(0);
        Movie movie = context.findMovie(query);

        Movie wantMovie = new Movie(0, "Titanic", Type.ARTISTIC, "Romantic", 1999, 10);
    }

    @Test
    public void testFindByName() {
        DBContextMovie context = new DBContextMovie();
        String query = context.createFindQueryByName("Titanic");
        Movie movie = context.findMovie(query);

        Movie wantMovie = new Movie(0, "Titanic", Type.ARTISTIC, "Romantic", 1999, 10);
    }


    @Test
    public void testFindByCategory() {
        DBContextMovie context = new DBContextMovie();
        String query = context.createFindByCategoryQuery("Comedy");
        List<Movie> movies = context.findAllMovies(query);

        Movie wantedMovie = new Movie(70, "Young Sheldon", Type.SERIES, "Comedy", 2014, 10);
        List<Movie> wantedMovies = new ArrayList<>();
        wantedMovies.add(wantedMovie);

        Assertions.assertEquals(movies, movies);
    }

    @Test
    public void testFindByYear() {
        DBContextMovie context = new DBContextMovie();
        String query = context.createFindByYearQuery(2014);
        List<Movie> movies = context.findAllMovies(query);

        Movie wantedMovie = new Movie(70, "Young Sheldon", Type.SERIES, "Comedy", 2014, 10);
        List<Movie> wantedMovies = new ArrayList<>();
        wantedMovies.add(wantedMovie);

        Assertions.assertEquals(movies, movies);
    }

}