package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class PaintShopTest extends WordSpecLike with MustMatchers with PaintShop {
  "process" should {
    "not find solution" in {
      process(palette(1), impPrefs1) must be (List.empty)
    }

    "not find solution changing preference order" in {
      process(palette(1), impPrefs2) must be (List.empty)
    }

    "find solution with 2 colours" in {
      process(palette(2), possPrefs1) must be (List(solution(matte(1), matte(2))))
    }
  }

  private def impPrefs1: Stream[Preference] = preference(matte(1)) #:: preference(gloss(1)) #:: Stream.empty[Preference]
  private def impPrefs2 = preference(gloss(1)) #:: preference(matte(1)) #:: Stream.empty[Preference]

  private def possPrefs1 = preference(gloss(1), matte(2)) #:: preference(matte(1)) #:: Stream.empty[Preference]
}