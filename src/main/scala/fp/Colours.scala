package fp

protected[fp] trait Colours {
  final def colour(i: Int, n: Nuance): Colour = Colour(ColorIndex(i), n)

  final def matte(i: Int): Colour = colour(i, Matte)
  final def gloss(i: Int): Colour = colour(i, Gloss)

  implicit def sortColour: Ordering[Colour] =
    (x: Colour, y: Colour) ⇒ implicitly[Ordering[Int]].compare(x.idx.value, y.idx.value)
}
