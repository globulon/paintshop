package fp

protected[fp] trait Palettes { self: Colors ⇒
  final def palette(n: Int): Palette = Palette(generateColors(n))

  private def generateColors(n: Int): List[Colour] = {
    Range(1, n + 1).foldLeft(List.empty[Colour]) {
      case (cs, i) ⇒ matte(i) :: gloss(i) :: cs
    }
  }
}

protected[fp] trait Colors {
  final def colour(i: Int, n: Nuance): Colour = Colour(ColorIndex(i), n)

  final def matte(i: Int): Colour = colour(i, Matte)
  final def gloss(i: Int): Colour = colour(i, Gloss)
}