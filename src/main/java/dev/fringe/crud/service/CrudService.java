package dev.fringe.crud.service;

import dev.fringe.crud.event.Event;
import dev.fringe.crud.model.*;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import scala.collection.JavaConversions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Service
public class CrudService {

    /*    @Autowired private SessionFactory sessionFactory;*/

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void service(){
         /*       Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new One("HDLEE"));
        session.getTransaction().commit();
        System.out.println(this.sessionFactory.openSession().createQuery("from One").list());

        Category category = new Category("Computer");
        Product pc = new Product("DELL PC",  category);
        Product laptop = new Product("MacBook", category);
        Product phone = new Product("iPhone 5",  category);
        Product tablet = new Product("iPad 3", category);

        session.beginTransaction();
        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);
        category.setProducts(products);
        session.save(category);
        session.getTransaction().commit();
        session.close();

        System.out.println(this.sessionFactory.openSession().createQuery("from Category").list());*/
        StatelessSession session = ((Session) em.getDelegate()).getSessionFactory().openStatelessSession();
        One one = new One("HDLEE");
        Event oe = new Event(this, one);
        session.insert(one);
        applicationEventPublisher.publishEvent(oe);
        session.close();

        Category category = new Category("Computer");
        Product pc = new Product("DELL PC",  category);
        Product laptop = new Product("MacBook", category);
        Product phone = new Product("iPhone 5",  category);
        Product tablet = new Product("iPad 3", category);

        Session s = ((Session) em.getDelegate()).getSessionFactory().openSession();
        s.beginTransaction();
        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);
        category.products_$eq(products);
        s.save(category);
        s.getTransaction().commit();
        s.close();


        Session s2 = ((Session) em.getDelegate()).getSessionFactory().openSession();
        s2.beginTransaction();
        Set<Course> courses = new HashSet<Course>();
        courses.add(new Course("Maths"));
        courses.add(new Course("Computer Science"));

        Student student1 = new Student("Eswar", courses);
        Student student2 = new Student("Joe", courses);
        s2.save(student1);
        s2.save(student2);
        s2.getTransaction().commit();
        s2.close();

   //    System.out.println(((Session) em.getDelegate()).getSessionFactory().openSession().createQuery("from Course").list());
    }
}
