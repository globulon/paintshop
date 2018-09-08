package fp

protected[fp] trait Palettes { self: Colours ⇒
  type Palette = List[Solution]

  final def palette(n: Int): Palette = generateColors(n).map(solution)

  private def generateColors(n: Int): List[Colour] = {
    Range(1, n + 1).foldLeft(List.empty[Colour]) {
      case (cs, i) ⇒ matte(i) :: gloss(i) :: cs
    }
  }
}