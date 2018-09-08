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
  @tailrec
  final def process(palette: Palette, input: Stream[Preference]): Palette = input match {
    case Stream.Empty ⇒ palette
    case pref #:: _   ⇒ process(merge(checkNuance)(palette)(pref), input.drop(1))
  }
}
