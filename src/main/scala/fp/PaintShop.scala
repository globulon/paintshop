package fp

import scala.annotation.tailrec

protected[fp] trait PaintShop {
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
