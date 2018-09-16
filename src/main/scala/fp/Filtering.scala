package fp

import scalaz.Scalaz._

protected[fp] trait Filtering {
  final def filter(p: Preference): Palette ⇒ Palette = _.foldLeft((p, Set.empty[Solution])) {
    case ((Preference(cs), _), _)   if cs.isEmpty                       ⇒ (preference(), Set.empty)
    case ((pref, acc), s) ⇒ select(pref, s).fold { case (filtered, sol) ⇒ (filtered, acc + sol) }
  }.fold { merge }

  @inline
  private def merge: (Preference, Palette) ⇒ Palette = {
    case (Preference(cs), _) if cs.isEmpty       ⇒ Set.empty
    case (Preference(colours), palette: Palette) ⇒ palette + solution(colours)
  }

  private def select(p: Preference, s: Solution): (Preference, Solution) = p.invert.colors.intersect(s.colors) match {
    case common if common.isEmpty ⇒ (p, s)
    case common if common.size == s.colors.size && common.size == p.colors.size ⇒ (preference(), solution())
    case common if common.size == s.colors.size && common.size < p.colors.size ⇒ (preference(p.colors -- common.map(_.invert)), s)
    case common if common.size == p.colors.size && common.size < s.colors.size ⇒ (p, solution(s.colors -- common))
    case common                   ⇒  (preference(p.colors -- common.map(_.invert).filter(_.matte)), solution(s.colors -- common.filter(_.matte)))
  }
}
