package dev.fringe.crud.service;

import dev.fringe.crud.event.Event;
import dev.fringe.crud.model.*;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Service
public class CrudService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private ApplicationEventPublisher publisher;

    public void service(){
        StatelessSession session = ((Session) em.getDelegate()).getSessionFactory().openStatelessSession();
        One one = new One("HDLEE");
        Event oe = new Event(this, one);
        session.insert(one);
        publisher.publishEvent(oe);
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
    }
}
