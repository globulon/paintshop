package fp

protected[fp] trait Colours {
  final def colour(i: Int, n: Nuance): Colour = Colour(ColorIndex(i), n)

  final def matte(i: Int): Colour = colour(i, Matte)
  final def gloss(i: Int): Colour = colour(i, Gloss)

  implicit def sortColour: Ordering[Colour] =
    (x: Colour, y: Colour) ⇒ implicitly[Ordering[Int]].compare(x.idx.value, y.idx.value)

  implicit class RichColour(c: Colour) {
    def invert: Colour = c match {
      case Colour(idx, Matte) ⇒ Colour(idx, Gloss)
      case Colour(idx, Gloss) ⇒ Colour(idx, Matte)
    }

    def gloss: Boolean = c.nuance == Gloss
    def matte: Boolean = !gloss
  }
}
