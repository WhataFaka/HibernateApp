package org.example.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int director_id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Movie> movies;

    public Director() {
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getItems() {
        return movies;
    }

    public void setItems(List<Movie> movies) {
        this.movies = movies;
    }

    public Director(String name, int age) {
        this.director_id = director_id;
        this.name = name;
        this.age = age;
    }

    public void addMovie(Movie movie) {
        if (this.movies == null) {
            this.movies = new ArrayList<>();
        }

        this.movies.add(movie);
        movie.setOwner(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + director_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
