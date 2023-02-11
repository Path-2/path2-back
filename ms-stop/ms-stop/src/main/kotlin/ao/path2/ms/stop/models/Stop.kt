package ao.path2.ms.stop.models

import org.locationtech.jts.geom.Point
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name = "TB_STOP")

class Stop {
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "gn_stop")
  @Id
  var id: Long = 0

  @NotNull
  var point: Point? = null

  @NotEmpty
  @NotEmpty
  @NotNull
  var name: String = ""

  var verified: Boolean = false
  var enabled: Boolean = true
  var createdAt: LocalDateTime = LocalDateTime.now()
  var updatedAt: LocalDateTime = LocalDateTime.now()
}