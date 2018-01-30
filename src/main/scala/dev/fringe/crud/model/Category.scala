package dev.fringe.crud.model

import javax.persistence._
import java.util.Set

@Entity
@Table(name = "CATEGORY")
class Category (cname : String){

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue
    var id : Long = _
    var name : String = cname

    @OneToMany(mappedBy = "category", cascade = Array(CascadeType.ALL))
    var products : Set[Product] = _

    override def toString = s"Category($id, $name, $products)"
}