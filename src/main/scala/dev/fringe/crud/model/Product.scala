package dev.fringe.crud.model;

import javax.persistence._

@Entity
@Table(name = "PROD")
class Product (n : String, c : Category ){
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue
    var id : Long = _
    var name: String = n

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    var category : Category = c

    override def toString = s"Product($name, $id, $category)"
}