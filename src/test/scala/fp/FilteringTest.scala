package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class FilteringTest extends WordSpecLike with MustMatchers {
  "Filter " should {
    "retain no solution" in {
      filter(preference(matte(1)))(Set(solution(gloss(1)))) must be(Set.empty)
    }

    "retain optimal solution with 2 lines" in {
      filter(preference(matte(1)))(Set(solution(gloss(1), matte(2)))) must be (Set(solution(matte(2)), solution(matte(1))))
    }

    "retain optimal solution with 5 lines" in {
      filter(preference(gloss(2), matte(3), gloss(4)))(Set(solution(matte(1), gloss(3), gloss(5)))) must be (
        Set(solution(gloss(2), gloss(4)), solution(matte(1), gloss(3), gloss(5))))
    }

    "retain final result with 5 lines" in {
      filter(preference(matte(5)))(Set(solution(gloss(2), gloss(4)), solution(matte(1), gloss(5)))) must be (
        Set(solution(gloss(2), gloss(4)), solution(matte(1)), solution(matte(5))))
    }

  }
}