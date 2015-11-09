package chap6objects

/**
 * 8. Write an enumeration describing the eight corners of the RGB color cube.
 * As IDs, use the color values (for example, 0xff0000 for Red).
 */
object Ex8 {

  object RgbColorCube extends Enumeration {

    type RgbColorCube = Value

    val Red = Value(0xff0000)

    val Blue = Value(0x0000ff)
    val Magenta = Value(0xff00ff)
    val White = Value(0xffffff)
    val Cyan = Value(0x00ffff)
    val Green = Value(0x008000)
    val Yellow = Value(0xffff00)
    val Black = Value(0x000000)
  }

}
