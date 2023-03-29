import scala.util.Random

object Factory {
  var robotNames: Set[String] = Set()
  val random = new Random()
  val letters = 'A' to 'Z'
}

class Robot {
  var name: String = genName()

  def genName() = {
    val name = Stream
      .from(1)
      .map(_ => {
        (1 to 2)
          .map(_ =>
            Factory.letters(Factory.random.nextInt(Factory.letters.length))
          )
          .mkString + (1 to 3).map(_ => Factory.random.nextInt(10)).mkString
      })
      .filterNot(Factory.robotNames.contains)
      .head

    Factory.robotNames += name
    name
  }

  def reset() = {
    Factory.robotNames -= name
    name = genName()
  }
}
