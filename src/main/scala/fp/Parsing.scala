package fp

import scala.util.parsing.combinator._

protected[fp] trait Parsing extends RegexParsers {
  private def number: Parser[Int] = """(0|[1-9]\d*)""".r ^^ { _.toInt }

  private def gloss: Parser[Nuance] = """G""".r ^^ { _⇒ Gloss }

  private def matte: Parser[Nuance] = """M""".r ^^ { _⇒ Matte }

  final def pref: Parser[Colour] = number ~ (gloss ||| matte) map {
    case i ~ n ⇒ Colour(ColorIndex(i), n)
  }

  final def preferences: Parser[List[Colour]] = pref*
}
