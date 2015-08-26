import org.viz.lightning._
import scala.util.Random

val lgn = Lightning()

val connections = Array.fill(50)(Array.fill(50)(Random.nextDouble()).map{ d =>
	if (d < 0.98) {
		d
	} else {
		0.0
	}
})

val g1 = Array.fill(50)(Random.nextInt() * 3)
val g2 = Array.fill(50)(Random.nextInt() * 3)
val group = g1 + g2

lgn.circle(connections, group=group)