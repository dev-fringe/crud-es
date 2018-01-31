package dev.fringe.crud.service;

import java.util.HashSet
import java.util.Set

import dev.fringe.crud.event.Event
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.PersistenceContext

import dev.fringe.crud.model.{Course, One, Student}

@Service class CrudService @Autowired()(entityManagerFactory:EntityManagerFactory, publisher:ApplicationEventPublisher) {

    @PersistenceContext
    val em : EntityManager = null

    def service(){
        val s1 = em.getDelegate.asInstanceOf[Session].getSessionFactory.openStatelessSession()
        val one = new One("HDLEE")
        val oe = new Event(this, one)
        s1.insert(one)
        publisher.publishEvent(oe)
        s1.close()

        val s2 = em.getDelegate.asInstanceOf[Session].getSessionFactory.openSession()
        s2.beginTransaction()
        val courses: Set[Course] = new HashSet[Course]()
        courses.add(new Course("Maths"))
        courses.add(new Course("Computer Science"))

        val student1:Student = new Student("Eswar", courses)
        val student2:Student = new Student("Joe", courses)
        System.out.println(student1)
        s2.save(student1);
        s2.save(student2);
        s2.getTransaction().commit();
        s2.close();
    }
}
