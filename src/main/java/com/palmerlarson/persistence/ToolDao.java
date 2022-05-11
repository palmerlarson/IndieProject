package com.palmerlarson.persistence;


import com.palmerlarson.entity.Tool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ToolDao {

    public ToolDao() {
    }

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets by id.
     *
     * @param tool_id the id
     * @return the by id
     */
    public Tool getById(int tool_id) {
        Session session = sessionFactory.openSession();
        Tool tool = session.get( Tool.class, tool_id );
        session.close();
        return tool;
    }


    /**
     * Save or update.
     *
     * @param tool the user
     */
    public void saveOrUpdate(Tool tool) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(tool);
        transaction.commit();
        session.close();
    }


    /**
     * Insert int.
     *
     * @param tool the user
     * @return the int
     */
    public int insert(Tool tool) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(tool);
        transaction.commit();
        session.close();
        return id;
    }


    /**
     * Delete.
     *
     * @param tool the user
     */
    public void delete(Tool tool) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(tool);
        transaction.commit();
        session.close();
    }


    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Tool> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tool> query = builder.createQuery( Tool.class );
        Root<Tool> root = query.from( Tool.class );
        List<Tool> tools = session.createQuery( query ).getResultList();

        logger.debug("The list of users " + tools);
        session.close();

        return tools;
    }

}
