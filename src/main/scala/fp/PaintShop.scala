package fp

import scala.annotation.tailrec

protected[fp] trait PaintShop {
  final def process(colourNum: Int, input: Stream[Preference]): Option[Solution] = input match {
    case Stream.Empty             ⇒ None
    case Preference(colors) #:: _ ⇒ fill(colourNum)(generate(Set(Solution(colors)), input.drop(1)))
  }

  @tailrec
  private def generate(palette: Palette, input: Stream[Preference]): Palette = input match {
    case _ if palette.isEmpty ⇒ palette
    case Stream.Empty         ⇒ palette
    case pref #:: _           ⇒ generate(filter(pref)(palette), input.drop(1))
  }

  private def fill(padding: Int): Palette ⇒ Option[Solution] = {
    case p if p.isEmpty ⇒ None
    case p              ⇒ Some(Solution(p.map(_.lowerCost).colours)).map(padd(padding))
  }
}
