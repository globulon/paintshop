package fp

import org.scalatest.{MustMatchers, WordSpecLike}
import scalaz.{-\/, \/-}

final class ErrorsTest extends WordSpecLike with MustMatchers {
  "safe" should {
    "return safe value" in {
      safe(17) must be (\/-(17))
    }

    "return unsafe value" in {
      safe(throw new Exception("boom")) must be (-\/(ApplicationError("boom")))
    }
  }
}
