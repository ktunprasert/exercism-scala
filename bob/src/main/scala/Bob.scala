import scala.util.matching.Regex

object Bob {
  def response(statement: String): String = {
    val stripped = statement.replaceAll(raw"\s", "")
    if (stripped.length == 0) return "Fine. Be that way!"

    val alpha = statement.replaceAll(raw"[^a-zA-Z]", "")
    val isQuestion = stripped.last == '?'

    val upcase = "[A-Z]".r.findAllIn(statement).toList
    (isQuestion, alpha.length == upcase.length && upcase.length > 0) match {
      case (true, true) => "Calm down, I know what I'm doing!"
      case (false, true) => "Whoa, chill out!"
      case (true, false) => "Sure."
      case _ => "Whatever."
    }
  }
}
