package com.palmerlarson.persistence;

import com.palmerlarson.entity.Tool;
import com.palmerlarson.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToolDaoTest {

    ToolDao dao;

    @BeforeEach
    void setUp() {
        com.palmerlarson.testUtils.Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new ToolDao();
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        Tool retrieveTool = dao.getById(1);
        assertEquals(dao.getById(1), retrieveTool);
    }


}
