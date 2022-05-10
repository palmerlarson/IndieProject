package com.palmerlarson.persistence;


import com.palmerlarson.entity.Tool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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


//    /**
//     * Save or update.
//     *
//     * @param user the user
//     */
//    public void saveOrUpdate(User user) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(user);
//        transaction.commit();
//        session.close();
//    }
//
//
//    /**
//     * Insert int.
//     *
//     * @param user the user
//     * @return the int
//     */
//    public int insert(User user) {
//        int id = 0;
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        id = (int)session.save(user);
//        transaction.commit();
//        session.close();
//        return id;
//    }
//
//
//    /**
//     * Delete.
//     *
//     * @param user the user
//     */
//    public void delete(User user) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(user);
//        transaction.commit();
//        session.close();
//    }
//
//
//    /**
//     * Gets all.
//     *
//     * @return the all
//     */
//    public List<User> getAll() {
//
//        Session session = sessionFactory.openSession();
//
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery( User.class );
//        Root<User> root = query.from( User.class );
//        List<User> users = session.createQuery( query ).getResultList();
//
//        logger.debug("The list of users " + users);
//        session.close();
//
//        return users;
//    }
}
