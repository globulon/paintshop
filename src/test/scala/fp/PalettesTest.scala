package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class PalettesTest extends WordSpecLike with MustMatchers {
  "palette" should {
    "create empty list" in {
      palette(0) must be (List.empty)
    }

    "create singleton list" in {
      palette(1) must be (List(List(matte(1)), List(gloss(1))))
    }
  }
}
