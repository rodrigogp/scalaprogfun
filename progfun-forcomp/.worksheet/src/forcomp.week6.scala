package forcomp

import Anagrams._

object week6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); val res$0 = 
  "predicate".groupBy((element: Char) => element);System.out.println("""res0: scala.collection.immutable.Map[Char,String] = """ + $show(res$0));$skip(106); val res$1 = 

  "abcd".toLowerCase().groupBy((element: Char) => element).map(p => (p._1, p._2.length())).toList.sorted;System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(47); val res$2 = 

  wordOccurrences(List("abcd", "e").mkString);System.out.println("""res2: forcomp.Anagrams.Occurrences = """ + $show(res$2));$skip(30); val res$3 = 

  List("abcd", "e").mkString;System.out.println("""res3: String = """ + $show(res$3));$skip(10); val res$4 = 

  "abcd";System.out.println("""res4: String("abcd") = """ + $show(res$4))}
}
