package com.palmerlarson.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


/**
 * The type user
 *
 * @author palmerlarson
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "userName")
    private String userName;

    @Column(name = "gross_income")
    private int gross_income;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private Tool tool;

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
     * @param userName     the userName
     * @param gross_income the gross income
     */
    public User(String first_name, String last_name, String userName, int gross_income) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.userName = userName;
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
     * Gets userName.
     *
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets userName.
     *
     * @param userName the username
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
        return gross_income == user.gross_income && id == user.id && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, userName, gross_income, id);
    }
}
