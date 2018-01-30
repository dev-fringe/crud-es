package dev.fringe.crud.model

import java.util.Set
import javax.persistence._
import java.util.Set


@Entity
@Table(name = "STUDENT")
 class Student ( s : String, c : Set[Course]){

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    var studentId : Long = _
    @Column(name = "STUDENT_NAME", nullable = false, length = 100)
    var studentName : String = s
    @ManyToMany(cascade = Array(CascadeType.ALL))
    @JoinTable(name = "STUDENT_COURSE", joinColumns=Array(new JoinColumn(name="keyid")), inverseJoinColumns = Array( new JoinColumn(name = "COURSE_ID") ))
    var courses : Set[Course] = c

    override def toString = s"Student($studentId, $studentName, $courses)"
}