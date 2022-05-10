package com.palmerlarson.persistence;

import com.palmerlarson.entity.Tool;
import com.palmerlarson.entity.User;
import com.palmerlarson.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToolDaoTest {

    ToolDao dao;
    UserDao uDao;

    @BeforeEach
    void setUp() {
        com.palmerlarson.testUtils.Database database = Database.getInstance();
//        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new ToolDao();
        uDao = new UserDao();
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        Tool retrieveTool = dao.getById(1);
        assertEquals(dao.getById(1), retrieveTool);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User retrieveUser = uDao.getById(2);
        Tool newTool = new Tool(10, 3, retrieveUser);
        int id = dao.insert(newTool);
        assertNotEquals(0, id);
        Tool insertedTool = dao.getById(id);
        assertEquals(newTool, insertedTool);
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        Tool toolToUpdate = dao.getById(1);
        toolToUpdate.setPositive_asset(300);
        toolToUpdate.setNegative_asset(1);
        dao.saveOrUpdate(toolToUpdate);
        Tool toolAfterUpdate = dao.getById(1);
        assertEquals(toolToUpdate, toolAfterUpdate);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        Tool retrieveTool = dao.getById(3);
        dao.delete(retrieveTool);
        assertNull(dao.getById(3));
    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<Tool> Tools = dao.getAll();
        assertEquals(4, Tools.size());
    }



}
