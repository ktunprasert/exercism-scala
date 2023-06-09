object Leap {
  def leapYear(year: Int): Boolean = year match {
    case y if y % 100 == 0 => y % 400 == 0
    case y if y % 4 == 0 => true
    case _ => false
  }
}
