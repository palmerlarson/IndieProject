package com.palmerlarson.persistence;

import com.palmerlarson.entity.User;

import com.palmerlarson.testUtils.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type user dao test.
 * @author palmerlarson
 */
public class UserDaoTest {

    /**
     * The Dao.
     */
    UserDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

       dao = new UserDao();
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrieveUser = dao.getById(1);
        assertEquals(dao.getById(1), retrieveUser);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Tim", "Timmy", "tim@gmail.com", 10000);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        User userToUpdate = dao.getById(1);
        userToUpdate.setFirst_name("Billy");
        userToUpdate.setLast_name("Bob");
        dao.saveOrUpdate(userToUpdate);
        User userAfterUpdate = dao.getById(1);
        assertEquals(userToUpdate, userAfterUpdate);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<User> Users = dao.getAll();
        assertEquals(3, Users.size());
    }


}
