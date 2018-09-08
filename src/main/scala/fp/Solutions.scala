package fp

protected[fp] trait Solutions {
  final def extend: Solution ⇒ Colour ⇒ Solution = {
    case Solution(colours) ⇒ c ⇒ Solution((c::colours).distinct).sorted
  }

  final def solution(c: Colour) = Solution(List(c))

  final def solution(c: Colour, c2: Colour, cs: Colour*) = Solution(c::c2::cs.toList)

  implicit class RichSolution(s: Solution) {
    def sorted: Solution = Solution(s.colors.sorted)
  }

  implicit def sortSolution: Ordering[Solution] =
    (x: Solution, y: Solution) ⇒ implicitly[Ordering[Int]].compare(weight(x), weight(y))

  private def weight: Solution ⇒ Int = _.colors.count(_.nuance == Gloss)
}