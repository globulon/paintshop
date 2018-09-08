package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class PaintShopTest extends WordSpecLike with MustMatchers with PaintShop {
  "process" should {
    "not find solution" in {
      process(palette(1), impPrefs1) must be (None)
    }

    "not find solution changing preference order" in {
      process(palette(1), impPrefs2) must be (None)
    }

    "find solution with 2 colours" in {
      process(palette(2), twoPrefs) must be (Some(solution(matte(1), matte(2))))
    }

    "find solution with 5 colours" in {
      process(palette(5), fivePrefs) must be (Some(solution(gloss(1), gloss(2), gloss(3), gloss(4), matte(5))))
    }
  }

  private def impPrefs1: Stream[Preference] =
    preference(matte(1)) #:: preference(gloss(1)) #:: Stream.empty[Preference]
  private def impPrefs2: Stream[Preference] =
    preference(gloss(1)) #:: preference(matte(1)) #:: Stream.empty[Preference]
  private def twoPrefs: Stream[Preference] =
    preference(gloss(1), matte(2)) #:: preference(matte(1)) #:: Stream.empty[Preference]
  private def fivePrefs: Stream[Preference] =
    preference(matte(1), gloss(3), gloss(5)) #:: preference(gloss(2), matte(3), gloss(4)) #:: preference(matte(5)) #:: Stream.empty[Preference]
}