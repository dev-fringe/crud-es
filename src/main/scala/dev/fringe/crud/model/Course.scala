package dev.fringe.crud.model

import javax.persistence._
import org.hibernate.envers.Audited

@Entity
@Table(name="COURSE")
@Audited
 class Course (cname : String){

    @Id
    @GeneratedValue
    @Column(name="COURSE_ID")
    var courseId : Long = _
    @Column(name="COURSE_NAME", nullable=false)
    var courseName: String = cname
    override def toString = s"Course($courseId, $courseName)"
}