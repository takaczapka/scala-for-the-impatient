package chap10traits

import java.awt.Point
import java.beans.{PropertyChangeEvent, PropertyChangeListener}

import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5._

  test("change listener support on Point") {

    val p = new Point(4, 1) with PropertyChangeSupport {
      override def setLocation(x: Int, y: Int): Unit = {
        firePropertyChange("x", getX.toInt, x)
        firePropertyChange("y", getY.toInt, y)

        super.setLocation(x, y)
      }
    }

    val status: collection.mutable.ListBuffer[String] = collection.mutable.ListBuffer()

    p.addPropertyChangeListener(new PropertyChangeListener {
      override def propertyChange(evt: PropertyChangeEvent): Unit = {
        status += s"changed from ${evt.getOldValue} to ${evt.getNewValue}"
      }
    })

    p.setLocation(5, 1)

    status should be (List("changed from 4 to 5"))

    status.clear()

    p.setLocation(6, 7)
    status should be (List("changed from 5 to 6", "changed from 1 to 7"))
  }
}
