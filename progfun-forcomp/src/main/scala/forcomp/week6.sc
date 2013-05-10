package forcomp

import Anagrams._

object week6 {
  "predicate".groupBy((element: Char) => element) //> res0: scala.collection.immutable.Map[Char,String] = Map(e -> ee, t -> t, a -
                                                  //| > a, i -> i, p -> p, c -> c, r -> r, d -> d)

  "abcd".toLowerCase().groupBy((element: Char) => element).map(p => (p._1, p._2.length())).toList.sorted
                                                  //> res1: List[(Char, Int)] = List((a,1), (b,1), (c,1), (d,1))

  wordOccurrences(List("abcd", "e").mkString)     //> res2: forcomp.Anagrams.Occurrences = List((a,1), (b,1), (c,1), (d,1), (e,1))
                                                  //| 

  List("abcd", "e").mkString                      //> res3: String = abcde

  "abcd"                                          //> res4: String("abcd") = abcd
}