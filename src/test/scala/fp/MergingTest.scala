package fp

import org.scalatest.{MustMatchers, WordSpecLike}

final class MergingTest extends WordSpecLike with MustMatchers with Merging {
 "merge" should {
   "merge " in {
     merge(checkNuance)(palette(1))(preference(matte(1))) must be (List(solution(matte(1))))
   }
 }
}