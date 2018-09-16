package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class SolutionsTest extends WordSpecLike with MustMatchers {
  "rich solution" must {
    "provide cheaper solution" in {
      solution(matte(1), gloss(3), gloss(5)).lowerCost.colors must not contain matte(1)
    }

    "provide self as cheaper solution" in {
      solution(matte(1)).lowerCost must be (solution(matte(1)))
    }
  }
}
