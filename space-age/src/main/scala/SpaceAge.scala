
object SpaceAge {
  val SECONDS_TO_YEAR: Double = 365.25 * 24 * 60 * 60
  
  def onEarth(age: Double): Double = age / (SECONDS_TO_YEAR * 1.0)

  def onVenus(age: Double): Double = age / (SECONDS_TO_YEAR * 0.61519726)

  def onMercury(age: Double): Double = age / (SECONDS_TO_YEAR * .2408467)

  def onMars(age: Double): Double = age / (SECONDS_TO_YEAR * 1.8808158)

  def onJupiter(age: Double): Double = age / (SECONDS_TO_YEAR * 11.862615)

  def onSaturn(age: Double): Double = age / (SECONDS_TO_YEAR * 29.447498)

  def onUranus(age: Double): Double = age / (SECONDS_TO_YEAR * 84.016846)

  def onNeptune(age: Double): Double = age / (SECONDS_TO_YEAR * 164.79132)
}
