object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] =
    scoreMap.flatMap { case (k, seq) => seq.map(v => (v.toLowerCase, k)) }
}
