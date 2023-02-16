package org.example;

import org.example.model.Movie;
import org.example.model.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).
                addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = new Director("Alya Kopaeva", 23);

            director.addMovie(new Movie("My sweet babysitter", 2003));
            director.addMovie(new Movie("Kitchen", 2012));
            director.addMovie(new Movie("Jopa popa", 2023));

            session.save(director);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
