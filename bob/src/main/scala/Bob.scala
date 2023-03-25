import scala.util.matching.Regex

object Bob {
  def response(statement: String): String = statement.trim match {
    case s if s.isEmpty => "Fine. Be that way!"
    case s if shouting(s) && questioning(s) => "Calm down, I know what I'm doing!"
    case s if shouting(s) => "Whoa, chill out!"
    case s if questioning(s) => "Sure."
    case _ => "Whatever."
  }

  def shouting(statement: String): Boolean = statement.toUpperCase == statement && statement.toLowerCase.exists(('a' to 'z').toSet.contains(_))

  def questioning(statement: String): Boolean = statement.last == '?'
}
