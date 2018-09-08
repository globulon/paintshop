package fp

import scala.annotation.tailrec


sealed trait Nuance
case object Gloss extends Nuance
case object Matte extends Nuance

case class Solution(colors: List[Colour])
case class Preference(colors: List[Colour])

case class ColorIndex(value: Int)
case class Colour(idx: ColorIndex, nuance: Nuance)

trait PaintShop {
  final def process(colourNum: Int, input: Stream[Preference]): Option[Solution] =
    optimal(colourNum)(generate(palette(colourNum), input))

  @tailrec
  private def generate(palette: Palette, input: Stream[Preference]): Palette = input match {
    case Stream.Empty ⇒ palette
    case pref #:: _   ⇒ generate(merge(checkNuance)(palette)(pref), input.drop(1))
  }

  private def optimal(padding: Int): Palette ⇒ Option[Solution] = {
    case Nil  ⇒ None
    case sols ⇒ Some(sols.max).map(padd(padding))
  }

}
