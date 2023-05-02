package controller;

import model.DBContextMovie;
import model.DBContextUser;
import model.Movie;
import model.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import view.AdministratorView;
import view.EmployeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeController {
    private EmployeeView employeeView;
    private User employee;
    private static final DBContextMovie dbContextMovie = new DBContextMovie();

    public EmployeeController(User user) {
        this.employee = user;
        this.employeeView = new EmployeeView(employee);
        this.employeeView.setVisible(true);

        employeeView.addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilterAndViewController filterAndViewController = new FilterAndViewController();
            }
        });

        employeeView.addCreateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = employeeView.getMovieFromCreateTable(employee.getID());
                dbContextMovie.insert(movie);
            }
        });

        employeeView.addReadButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = employeeView.getNameFromReadTextField();
                if(!name.equals("")) {
                    employeeView.setMovieToReadTable(dbContextMovie.findMovie(dbContextMovie.createFindQueryByName(name)));
                }
                else {
                    String id = employeeView.getIDFromReadTextField();
                    if(!id.equals("")) {
                        employeeView.setMovieToReadTable(dbContextMovie.findMovie(dbContextMovie.createFindQueryByID(Integer.parseInt(id))));
                    }
                    else {
                        employeeView.showMessage("Please enter a valid name or id");
                    }
                }
            }
        });

        employeeView.addDeleteButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = employeeView.getNameFromDeleteTextField();
                if(!name.equals("")) {
                    dbContextMovie.deleteMovie(dbContextMovie.createDeleteQueryByName(name));
                }
                else {
                    String id = employeeView.getIDFromDeleteTextField();
                    if (!id.equals("")) {
                        try {
                            dbContextMovie.deleteMovie(dbContextMovie.createDeleteQueryByID(Integer.parseInt(id)));
                        }catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Cannot delete this movie");
                        }
                    }
                    else {
                        employeeView.showMessage("Please enter a valid name or id");
                    }
                }
            }
        });

        employeeView.addUpdateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Movie movie = dbContextMovie.findMovie(dbContextMovie.createFindQueryByID(employeeView.getIDFromUpdateTextField()));
                    int id_creator = movie.getIdCreator();

                    DBContextUser dbContextUser = new DBContextUser();
                    User userObserver = dbContextUser.findUser(dbContextUser.createFindQueryByID(id_creator));

                    dbContextMovie.updateMovie(employeeView.getIDFromUpdateTextField(), employeeView.getNameFromUpdateTable(), employeeView.getTypeFromUpdateTable(), employeeView.getCategoryFromUpdateTable(), employeeView.getYearFromUpdateTable());

                    movie.addObserver(userObserver);
                    movie.setUpdate();
                } catch (Exception exp) {
                    employeeView.showMessage("Cannot update this movie");
                }
            }
        });

        employeeView.addChartButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> movies = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());// your list of movies

                // count the number of movies released each year
                Map<Integer, Integer> yearCounts = new HashMap<>();
                for (Movie movie : movies) {
                    int year = movie.getYear();
                    yearCounts.put(year, yearCounts.getOrDefault(year, 0) + 1);
                }

                // create a dataset for the chart
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int year : yearCounts.keySet()) {
                    int count = yearCounts.get(year);
                    dataset.addValue(count, "Movies", Integer.toString(year));
                }

                // create the chart
                JFreeChart chart = ChartFactory.createBarChart(
                        "Movies Released by Year",
                        "Year",
                        "Movies",
                        dataset
                );

                // display the chart in a window
                ChartFrame frame = new ChartFrame("Movies Released by Year", chart);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
