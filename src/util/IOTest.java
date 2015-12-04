/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.util.ArrayList;
import java.util.List;
import logic.Test;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class IOTest {

    public IOTest() {
    }
    /**
     * Получить весь список записей
     * @return  список записей
     */
    public List<Test> getListTest()
    {
        List<Test> ls = new ArrayList<Test>();
        Session sess;
        sess = HibernateUtil.getSessionFactory().openSession();   
        ls = sess.createCriteria(Test.class).list();        
        sess.close();        
        return ls;
    }
    
    public void sageTest()
    {
        Session sess;
        sess = HibernateUtil.getSessionFactory().openSession();   
        sess.beginTransaction();
        Test t;
        for(int i=0;i<100;i++)
        {
            t = new Test();
            t.setId(null);
            t.setName("Name + "+i);
            sess.saveOrUpdate(t);
        }
        sess.beginTransaction().commit();
        sess.close();
    }
}
