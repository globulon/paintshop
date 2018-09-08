package fp

protected[fp] trait Solutions {
  final def extend: Solution ⇒ Colour ⇒ Solution = {
    case Solution(colours) ⇒ c ⇒ Solution((c::colours).distinct)
  }

  final def solution(c: Colour) = Solution(List(c))

  final def solution(c: Colour, c2: Colour, cs: Colour*) = Solution(c::c2::cs.toList)
}