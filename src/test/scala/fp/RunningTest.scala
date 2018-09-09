package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class RunningTest extends WordSpecLike with MustMatchers with Running {
  "run" should {
    "return a valid solution" in {
      run(Array("samples/5colours.txt")) must be (safe(solution(gloss(1), gloss(2), gloss(3), gloss(4), matte(5))))
    }

    "notify missing file parameter" in {
      run(Array()) must be (fp.fail("please specify a file location"))
    }

    "notify invalid file location" in {
      run(Array("blah")) must be (fp.fail("file blah not found"))
    }
  }
}
