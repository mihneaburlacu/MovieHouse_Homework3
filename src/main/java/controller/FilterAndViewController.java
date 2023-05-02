package controller;

import com.google.gson.Gson;
import model.Comparators.MovieComparator;
import model.DBContextMovie;
import model.Movie;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import view.ViewAndFilterView;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FilterAndViewController {
    private ViewAndFilterView viewAndFilterView;
    private static final DBContextMovie dbContextMovie = new DBContextMovie();

    public FilterAndViewController() {
        this.viewAndFilterView = new ViewAndFilterView();
        viewAndFilterView.setVisible(true);

        viewAndFilterView.addXmlButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.newDocument();

                    Element root = document.createElement("Movies");
                    document.appendChild(root);

                    for (Movie movie : list) {
                        Element c = document.createElement("Movie");
                        root.appendChild(c);

                        Element id = document.createElement("ID");
                        id.appendChild(document.createTextNode(movie.getID() + ""));
                        c.appendChild(id);

                        Element name = document.createElement("Name");
                        name.appendChild(document.createTextNode(movie.getName()));
                        c.appendChild(name);

                        Element type = document.createElement("Type");
                        type.appendChild(document.createTextNode(movie.getType().toString()));
                        c.appendChild(type);

                        Element category = document.createElement("Category");
                        category.appendChild(document.createTextNode(movie.getCategory()));
                        c.appendChild(category);

                        Element year = document.createElement("Year");
                        year.appendChild(document.createTextNode(movie.getYear() + ""));
                        c.appendChild(year);

                        Element idCreator = document.createElement("IDCreator");
                        idCreator.appendChild(document.createTextNode(movie.getIdCreator() + ""));
                        c.appendChild(idCreator);

                    }

                    File xmlFile = new File("Movies.xml");
                    javax.xml.transform.TransformerFactory transformerFactory= javax.xml.transform.TransformerFactory.newInstance();
                    javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
                    javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
                    javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    transformer.transform(source, result);

                } catch (ParserConfigurationException | TransformerException exp) {
                    exp.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot create XML file");
                }
            }
        });

        viewAndFilterView.addTxtButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

                FileWriter fileWriter;
                try {
                    fileWriter = new FileWriter("Movies.txt");

                    for(Movie movie : list) {
                        fileWriter.write(movie.toString() + "\n");
                    }

                    fileWriter.close();
                }catch (Exception exp) {
                    System.out.println("Error while creating .txt file for movies");
                }
            }
        });

        viewAndFilterView.addCSVButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

                FileWriter fileWriter;
                try {
                    fileWriter = new FileWriter("Movies.csv");

                    fileWriter.append("id,name,type,category,year,id_creator\n");

                    for(Movie movie : list) {
                        fileWriter.append(movie.getID() + ",");
                        fileWriter.append(movie.getName() + ",");
                        fileWriter.append(movie.getType() + ",");
                        fileWriter.append(movie.getCategory() + ",");
                        fileWriter.append(movie.getYear() + ",");
                        fileWriter.append(movie.getIdCreator() + "\n");
                    }

                    fileWriter.close();
                }catch (Exception exp) {
                    System.out.println("Error while creating .csv file for movies");
                }
            }
        });

        viewAndFilterView.addJSONButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> movies = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

                try{
                    FileWriter fileWriter = new FileWriter("Movies.json");
                    Gson gson = new Gson();

                    for(Movie movie : movies) {
                        gson.toJson(movie, fileWriter);
                        fileWriter.append("\n");
                    }

                    fileWriter.close();
                }catch(Exception exp) {
                    System.out.println("Error while creating .json file");
                }
            }
        });

        viewAndFilterView.addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAndFilterView.resetTable();

                List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

                System.out.println(list);

                list.sort(new MovieComparator());

                int nr = 1;
                for(Movie m : list) {
                    viewAndFilterView.setMovieInTable(nr, m);
                    nr++;
                }

                viewAndFilterView.designTables();
            }
        });

        viewAndFilterView.addFilterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAndFilterView.resetTable();

                String select = viewAndFilterView.getFilterFromComboBox();
                String got = viewAndFilterView.getFilterTextField();
                List<Movie> list = new ArrayList<>();

                if(select == "TYPE") {
                    list = dbContextMovie.findAllMovies(dbContextMovie.createFindByTypeQuery(got));
                }
                else if(select == "CATEGORY"){
                    list = dbContextMovie.findAllMovies(dbContextMovie.createFindByCategoryQuery(got));
                }
                else {
                    list = dbContextMovie.findAllMovies(dbContextMovie.createFindByYearQuery(Integer.parseInt(got)));
                }

                int nr = 1;
                for(Movie m : list) {
                    viewAndFilterView.setMovieInTable(nr, m);
                    nr++;
                }

                viewAndFilterView.designTables();
            }
        });
    }
}
