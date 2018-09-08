package fp


sealed trait Nuance
case object Gloss extends Nuance
case object Matte extends Nuance

case class Solution(colors: List[Colour])
case class ColorIndex(value: Int)
case class Colour(idx: ColorIndex, nuance: Nuance)
case class Preference(colors: List[Colour])

trait PaintShop {
  final protected def solve(palette: Palette, input: List[Preference]):List[List[Colour]] = List.empty
}
