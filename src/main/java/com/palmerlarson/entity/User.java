package com.palmerlarson.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * The type user
 * @author palmerlarson
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "gross_income")
    private int gross_income;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    /**
     * Instantiates a new Author.
     */
    public User() {

    }

    /**
     * Instantiates a new user.
     *
     * @param first_name   the first name
     * @param last_name    the last name
     * @param user_email   the user email
     * @param gross_income the gross income
     */
    public User(String first_name, String last_name, String user_email, int gross_income) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_email = user_email;
        this.gross_income = gross_income;
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Sets first name.
     *
     * @param first_name the first name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Sets last name.
     *
     * @param last_name the last name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * Sets user email.
     *
     * @param user_email the user email
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * Gets gross income.
     *
     * @return the gross income
     */
    public int getGross_income() {
        return gross_income;
    }

    /**
     * Sets gross income.
     *
     * @param gross_income the gross income
     */
    public void setGross_income(int gross_income) {
        this.gross_income = gross_income;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return gross_income == user.gross_income && id == user.id && first_name.equals(user.first_name) && last_name.equals(user.last_name) && user_email.equals(user.user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, user_email, gross_income, id);
    }
}
