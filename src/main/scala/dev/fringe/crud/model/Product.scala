package dev.fringe.crud.model;

import javax.persistence._

@Entity
@Table(name = "PROD")
class Product (cname : String, cate : Category ){
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue
    var id : Long = _
    var name: String = cname

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    var category : Category = cate

    override def toString = s"Product($name, $id, $category)"
}