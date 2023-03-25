class School {
  type DB = Map[Int, Seq[String]]

  private var _db: DB = Map()

  def add(name: String, g: Int) = _db = _db.updated(g, grade(g) :+ name)

  def db: DB = _db

  def grade(g: Int): Seq[String] = _db.getOrElse(g, Seq())

  def sorted: DB =
    Map(_db.toSeq.sortBy(_._1): _*) // _* variadic the sorted Map into itself
      .mapValues(_.sorted)
      .toMap
}
