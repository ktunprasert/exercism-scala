object Bearing extends Enumeration {
  type Bearing = Value
  val North = Value("N")
  val East = Value("E")
  val South = Value("S")
  val West = Value("W")
}

case class Robot(bearing: Bearing.Bearing = Bearing.North, coordinates: (Int, Int) = (0, 0)) {
  def turnRight = bearing match {
    case Bearing.North => copy(bearing = Bearing.East)
    case Bearing.East => copy(bearing = Bearing.South)
    case Bearing.South => copy(bearing = Bearing.West)
    case Bearing.West => copy(bearing = Bearing.North)
  }

  def turnLeft = bearing match {
    case Bearing.North => copy(bearing = Bearing.West)
    case Bearing.East => copy(bearing = Bearing.North)
    case Bearing.South => copy(bearing = Bearing.East)
    case Bearing.West => copy(bearing = Bearing.South)
  }

  def advance = bearing match {
    case Bearing.North => copy(coordinates = (coordinates._1, coordinates._2 + 1))
    case Bearing.East => copy(coordinates = (coordinates._1 + 1, coordinates._2))
    case Bearing.South => copy(coordinates = (coordinates._1, coordinates._2 - 1))
    case Bearing.West => copy(coordinates = (coordinates._1 - 1, coordinates._2))
  }

  def simulate(instructions: String) = instructions.foldLeft(this) {
    case (robot, 'L') => robot.turnLeft
    case (robot, 'R') => robot.turnRight
    case (robot, 'A') => robot.advance
    case (robot, _) => robot
  }
}
