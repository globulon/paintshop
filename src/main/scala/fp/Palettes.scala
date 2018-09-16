package fp

protected[fp] trait Palettes { self: Colours ⇒
  type Palette = Set[Solution]

  implicit class RichPalette(p: Palette) {
    def colours: Set[Colour] = for {
      s ← p
      c ← s.colors
    } yield c
  }
}