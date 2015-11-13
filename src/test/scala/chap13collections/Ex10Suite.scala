package chap13collections

import org.scalatest.{FunSuite, Matchers}

class Ex10Suite extends FunSuite with Matchers {

  test("aggregate string frequencies") {

    // vry long string
    val str = "Anyway, I keep picturing all these little kids playing some game in this big field of rye and all. " +
      "Thousands of little kids, and nobody's around - nobody big, I mean - except me. And I'm standing on the edge " +
      "of some crazy cliff. What I have to do, I have to catch everybody if they start to go over the cliff - I mean " +
      "if they're running and they don't look where they're going I have to come out from somewhere and catch them. " +
      "That's all I do all day. I'd just be the catcher in the rye and all. I know it's crazy, but that's the only " +
      "thing I'd really like to be."

    val r = str.aggregate(Map[Char, Int]())({ (m, c) =>
      m.updated(c, m.getOrElse(c, 0) + 1)
    }, { (map1, map2) =>
      map1 ++ map2.map { case (k, v) => k -> (v + map1.getOrElse(k, 0)) }
    })

    println(r)
  }
}
