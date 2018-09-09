package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class ParsingTest extends WordSpecLike with MustMatchers with Parsing {
  "Parsing" should {
    "successfuly parse preference" in {
      expect(parse(pref, "1 M")) {
        _ must be (matte(1))
      }
    }

    "successfully parse 1 M 3 G 5 G" in {
      expect(parse(preferences, "1 M 3 G 5 G")) {
        _ must be (List(matte(1), gloss(3), gloss(5)))
      }
    }
  }

  private def expect[A](r: ParseResult[Any])(f: Any ⇒ A): A = r match {
    case Success(result, _) ⇒ f(result)
    case _                  ⇒ fail("Expected successful parsing")
  }
}
