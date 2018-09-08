package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class PaintshopTest extends WordSpecLike with MustMatchers with Paintshop {
  "find solution" should {
    "not find solution" in {
      solve(palette(1), List(Preference(List(matte(1))), Preference(List(gloss(1))))) must be (List.empty)
    }

    "not find solution changing preference order" in {
      solve(palette(1), List(Preference(List(matte(1))), Preference(List(gloss(1))))) must be (List.empty)
    }
  }
}
