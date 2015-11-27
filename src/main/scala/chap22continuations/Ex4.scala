package chap22continuations

import java.awt._
import java.awt.event._
import javax.swing._
import scala.util.continuations._

/**
  * 4. The example in Section 22.8, “Undoing Inversion of Control,” on page 329 is a bit unsightly— the application
  * programmer sees the reset statement. Move reset from the run method to the button listener.
  * Is the application programmer now blissfully unaware of continuations?
  */
object Ex4 extends App {

  // ANSWER
  // Not really, the code is poluted with CPS syntax anyway.


  val frame = new JFrame
  val button = new JButton("Next")

  setListener(button) {
    run()
  }

  val textField = new JTextArea(10, 40)
  textField.setEnabled(true)
  val label = new JLabel("Welcome to the demo app")
  frame.add(label, BorderLayout.NORTH)
  frame.add(textField)
  val panel = new JPanel
  panel.add(button)
  frame.add(panel, BorderLayout.SOUTH)
  frame.pack()

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setVisible(true)

  def run(): Unit @cps[Unit] = {
    val response1 = getResponse(" What is your first name?")
    val response2 = getResponse(" What is your last name?")

    process(response1, response2)
  }

  def process(s1: String, s2: String) {
    label.setText(" Hello, " + s1 + " " + s2)
  }

  var cont: Unit => Unit = null

  def getResponse(prompt: String): String@cps[Unit] = {
    label.setText(prompt)
    setListener(button) {
      cont()
    }
    shift { k: (Unit => Unit) =>
      cont = k
    }
    setListener(button) {}
    textField.getText
  }

  def setListener(button: JButton)(action: => Unit@cps[Unit]):Unit = {
    for (l <- button.getActionListeners) button.removeActionListener(l)
    button.addActionListener(new ActionListener {
      override def actionPerformed(event: ActionEvent) {
        reset {
          action
        }
      }
    })
  }
}
