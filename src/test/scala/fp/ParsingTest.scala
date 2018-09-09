package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class ParsingTest extends WordSpecLike with MustMatchers with Parsing {
  "Parsing" should {
    "successfuly parse preference" in {
      parse(pref, "1 M").get must be (matte(1))
    }

    "successfully parse 1 M 3 G 5 G" in {
      parse(preferences, "1 M 3 G 5 G").get must be (List(matte(1), gloss(3), gloss(5)))
    }
  }
}
