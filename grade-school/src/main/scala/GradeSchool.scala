class School {
  type DB = Map[Int, Seq[String]]

  private var _db: DB = Map()

  def add(name: String, g: Int) = _db = db.get(g) match {
    case Some(seq) => db + (g -> (seq :+ name))
    case None      => db + (g -> Seq(name))
  }

  def db: DB = _db

  def grade(g: Int): Seq[String] = db.get(g) match {
    case None => Seq()
    case _    => db(g)
  }

  def sorted: DB = db
    .mapValues { _.sorted }
    .toSeq
    .sortBy { case (k, _) => k }
    .toMap
}
