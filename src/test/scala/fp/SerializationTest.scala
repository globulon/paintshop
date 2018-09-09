package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class SerializationTest extends WordSpecLike with MustMatchers {
  "Serialize" should {
    "serialize solution with mixed fields" in {
      serialize(solution(gloss(1), matte(2), gloss(3), gloss(4), matte(5))) must be ("G M G G M")
    }

    "serialize safe solution with mixed fields" in {
      serialize(safe(solution(gloss(1), matte(2), gloss(3), gloss(4), matte(5)))) must be ("G M G G M")
    }

    "serialize failed solution with mixed fields" in {
      serialize(fp.fail[SafeResult[Solution]]("failed !!!")) must be ("failed !!!")
    }
  }
}
