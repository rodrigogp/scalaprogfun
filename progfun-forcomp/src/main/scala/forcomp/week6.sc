package forcomp

import Anagrams._

object week6 {
  "predicate".groupBy((element: Char) => element) //> res0: scala.collection.immutable.Map[Char,String] = Map(e -> ee, t -> t, a -
                                                  //| > a, i -> i, p -> p, c -> c, r -> r, d -> d)

  "abcd".toLowerCase().groupBy((element: Char) => element).map(p => (p._1, p._2.length())).toList.sorted
                                                  //> res1: List[(Char, Int)] = List((a,1), (b,1), (c,1), (d,1))

  wordOccurrences(List("abcd", "e").mkString)     //> res2: forcomp.Anagrams.Occurrences = List((a,1), (b,1), (c,1), (d,1), (e,1))
                                                  //| 

  "abcd"                                          //> res3: String("abcd") = abcd

  val occurrences = List(('a', 2), ('b', 2))      //> occurrences  : List[(Char, Int)] = List((a,2), (b,2))

  val letterList = for (p <- occurrences; i <- 1 to p._2) yield p._1
                                                  //> letterList  : List[Char] = List(a, a, b, b)

  val listCombinations = for {
    c1 <- letterList
    c2 <- letterList
  } yield wordOccurrences(List(c1, c2).mkString)  //> listCombinations  : List[forcomp.Anagrams.Occurrences] = List(List((a,2)), L
                                                  //| ist((a,2)), List((a,1), (b,1)), List((a,1), (b,1)), List((a,2)), List((a,2))
                                                  //| , List((a,1), (b,1)), List((a,1), (b,1)), List((a,1), (b,1)), List((a,1), (b
                                                  //| ,1)), List((b,2)), List((b,2)), List((a,1), (b,1)), List((a,1), (b,1)), List
                                                  //| ((b,2)), List((b,2)))

  def combinations(occurrences: Occurrences): List[Occurrences] = {

    def comb1(occurrences: Occurrences): List[Occurrences] = {
      if (occurrences.isEmpty) List(Nil)
      else {
        for {
          rest <- comb1(occurrences.tail)
          occ <- 1 to occurrences.head._2
        } yield List((occurrences.head._1, occ)) ::: rest
      }
    }

    def comb2(occurrences: Occurrences): List[Occurrences] = {
      if (occurrences.isEmpty) List(Nil)
      else {
        for {
          occ <- occurrences
          occn <- 1 to occ._2
        } yield List((occ._1, occn))
      }
    }

    if (occurrences.isEmpty) List(Nil)
    else {
      comb1(occurrences) ::: comb2(occurrences) ::: List(List())
    }
  }                                               //> combinations: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagr
                                                  //| ams.Occurrences]

  combinations(occurrences)                       //> res4: List[forcomp.Anagrams.Occurrences] = List(List((a,1), (b,1)), List((a
                                                  //| ,2), (b,1)), List((a,1), (b,2)), List((a,2), (b,2)), List((a,1)), List((a,2
                                                  //| )), List((b,1)), List((b,2)), List())
  combinations(Nil)                               //> res5: List[forcomp.Anagrams.Occurrences] = List(List())

  occurrences.groupBy(p => p._1)                  //> res6: scala.collection.immutable.Map[Char,List[(Char, Int)]] = Map(b -> Lis
                                                  //| t((b,2)), a -> List((a,2)))

  occurrences.toMap                               //> res7: scala.collection.immutable.Map[Char,Int] = Map(a -> 2, b -> 2)

  occurrences.filter(p => p._1 == 'b')            //> res8: List[(Char, Int)] = List((b,2))

  def subtract2(x: Occurrences, y: Occurrences): Occurrences = {
    def deleteTerm(occs: Occurrences, occy: (Char, Int)): Occurrences = {
      {
        for (occx <- occs; if (occy._1 == occx._1 && occy._2 <= occx._2)) yield if (occx._2 - occy._2 == 0) occs.filter(p => p._1 != occx._1)
        else occs.updated(occs.indexOf(occx), (occx._1, occx._2 - occy._2))
      }.flatten
    }
    (y foldLeft x)(deleteTerm)
  }                                               //> subtract2: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrence
                                                  //| s)forcomp.Anagrams.Occurrences

  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    val xmap = x.toMap
    val ymap = y.toMap
    def deleteTerm(map: Map[Char, Int], occy: (Char, Int)): Map[Char, Int] = {
      val (y1, y2) = occy
      val x2 = map.apply(y1)
      if (x2 > y2)
        map.updated(y1, x2 - y2)
      else if (x2 == y2)
        (map - y1)
      else
        map
    }
    (ymap foldLeft xmap)(deleteTerm).toList
  }                                               //> subtract: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences
                                                  //| )forcomp.Anagrams.Occurrences

  val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> lard  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
  val r = List(('r', 1))                          //> r  : List[(Char, Int)] = List((r,1))
  val lad = List(('a', 1), ('d', 1), ('l', 1))    //> lad  : List[(Char, Int)] = List((a,1), (d,1), (l,1))
  subtract(lard, r)                               //> res9: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1))

  subtract(occurrences, List(('b', 1)))           //> res10: forcomp.Anagrams.Occurrences = List((a,2), (b,1))
}