package fp

protected[fp] trait Solutions {
  final def padd(n : Int): Solution ⇒ Solution = s ⇒ Range(1, n + 1).toSet.diff(s.colors.map(_.idx.value)).foldLeft(s) {
    case (Solution(colors), i) ⇒ solution(colors +  gloss(i))
  }

  final def solution() = Solution(Set.empty)

  final def solution(cs: Set[Colour]) = Solution(cs)

  final def solution(c: Colour) = Solution(Set(c))

  final def solution(c: Colour, c2: Colour, cs: Colour*) = Solution(Set(c, c2) ++ cs.toSet)

  implicit class RichSolution(s: Solution) {
    def lowerCost: Solution = s.colors.find(_.nuance == Gloss).map { solution }.getOrElse(s)
  }
}