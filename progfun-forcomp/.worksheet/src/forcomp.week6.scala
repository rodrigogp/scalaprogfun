package forcomp

import Anagrams._

object week6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); val res$0 = 
  "predicate".groupBy((element: Char) => element);System.out.println("""res0: scala.collection.immutable.Map[Char,String] = """ + $show(res$0));$skip(106); val res$1 = 

  "abcd".toLowerCase().groupBy((element: Char) => element).map(p => (p._1, p._2.length())).toList.sorted;System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(47); val res$2 = 

  wordOccurrences(List("abcd", "e").mkString);System.out.println("""res2: forcomp.Anagrams.Occurrences = """ + $show(res$2));$skip(10); val res$3 = 

  "abcd";System.out.println("""res3: String("abcd") = """ + $show(res$3));$skip(46); 

  val occurrences = List(('a', 2), ('b', 2));System.out.println("""occurrences  : List[(Char, Int)] = """ + $show(occurrences ));$skip(70); 

  val letterList = for (p <- occurrences; i <- 1 to p._2) yield p._1;System.out.println("""letterList  : List[Char] = """ + $show(letterList ));$skip(123); 

  val listCombinations = for {
    c1 <- letterList
    c2 <- letterList
  } yield wordOccurrences(List(c1, c2).mkString);System.out.println("""listCombinations  : List[forcomp.Anagrams.Occurrences] = """ + $show(listCombinations ));$skip(725); 

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
  };System.out.println("""combinations: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(29); val res$4 = 

  combinations(occurrences);System.out.println("""res4: List[forcomp.Anagrams.Occurrences] = """ + $show(res$4));$skip(20); val res$5 = 
  combinations(Nil);System.out.println("""res5: List[forcomp.Anagrams.Occurrences] = """ + $show(res$5));$skip(34); val res$6 = 

  occurrences.groupBy(p => p._1);System.out.println("""res6: scala.collection.immutable.Map[Char,List[(Char, Int)]] = """ + $show(res$6));$skip(21); val res$7 = 

  occurrences.toMap;System.out.println("""res7: scala.collection.immutable.Map[Char,Int] = """ + $show(res$7));$skip(40); val res$8 = 

  occurrences.filter(p => p._1 == 'b');System.out.println("""res8: List[(Char, Int)] = """ + $show(res$8));$skip(423); 

  def subtract2(x: Occurrences, y: Occurrences): Occurrences = {
    def deleteTerm(occs: Occurrences, occy: (Char, Int)): Occurrences = {
      {
        for (occx <- occs; if (occy._1 == occx._1 && occy._2 <= occx._2)) yield if (occx._2 - occy._2 == 0) occs.filter(p => p._1 != occx._1)
        else occs.updated(occs.indexOf(occx), (occx._1, occx._2 - occy._2))
      }.flatten
    }
    (y foldLeft x)(deleteTerm)
  };System.out.println("""subtract2: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)forcomp.Anagrams.Occurrences""");$skip(418); 

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
  };System.out.println("""subtract: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)forcomp.Anagrams.Occurrences""");$skip(59); 

  val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1));System.out.println("""lard  : List[(Char, Int)] = """ + $show(lard ));$skip(25); 
  val r = List(('r', 1));System.out.println("""r  : List[(Char, Int)] = """ + $show(r ));$skip(47); 
  val lad = List(('a', 1), ('d', 1), ('l', 1));System.out.println("""lad  : List[(Char, Int)] = """ + $show(lad ));$skip(20); val res$9 = 
  subtract(lard, r);System.out.println("""res9: forcomp.Anagrams.Occurrences = """ + $show(res$9));$skip(41); val res$10 = 

  subtract(occurrences, List(('b', 1)));System.out.println("""res10: forcomp.Anagrams.Occurrences = """ + $show(res$10))}
}
