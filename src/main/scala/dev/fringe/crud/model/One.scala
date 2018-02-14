package  dev.fringe.crud.model
import javax.persistence._

@Entity
@Table(name = "ONE")
class One (username: String){

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  var id : Int = _
  var name : String = username
  def this() = this(null)
  override def toString = s"One($id, $name)"
}