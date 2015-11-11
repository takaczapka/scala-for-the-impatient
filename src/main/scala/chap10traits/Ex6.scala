package chap10traits

/**
 * 6. In the Java AWT library, we have a class Container, a subclass of Component that collects multiple components.
 * For example, a Button is a Component, but a Panel is a Container. That’s the composite pattern at work. Swing
 * has JComponent and JButton, but if you look closely, you will notice something strange. JComponent extends
 * Container, even though it makes no sense to add other components to, say, a JButton. The Swing designers would have
 * ideally preferred the design in Figure 10– 4.
 *
 * Component <\- Container
 * Component <|- JComponent
 * JComponent <|- JButton
 * JComponent <|- JContainer
 * Component <\- JContainer
 * JContainer <|- JPanel
 *
 * But that's not possible in Java. Explain why not. How could the design be executed in Scala with traits?
 */
object Ex6 {

  // ANSWER
  // There would be a multiple inheritance problem as JContainer would inherit from both Container and JComponent classes.
  // In Scala all high-level classes could be represented as traits, which would make the hierarchy a valid one.
}
