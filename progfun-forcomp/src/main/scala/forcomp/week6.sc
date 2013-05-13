package forcomp

import Anagrams._

object week6 {
  val occurrences = List(('a', 2), ('b', 2))      //> occurrences  : List[(Char, Int)] = List((a,2), (b,2))
  val occs3 = List(('a', 2), ('b', 2), ('c', 1))  //> occs3  : List[(Char, Int)] = List((a,2), (b,2), (c,1))
  val sentence = List("Linux", "rulez")           //> sentence  : List[String] = List(Linux, rulez)
  val soc = sentenceOccurrences(sentence)         //> soc  : forcomp.Anagrams.Occurrences = List((e,1), (i,1), (l,2), (n,1), (r,1)
                                                  //| , (u,2), (x,1), (z,1))

  val sentence2 = List("Yes", "man")              //> sentence2  : List[String] = List(Yes, man)
  val soc2 = sentenceOccurrences(sentence2)       //> soc2  : forcomp.Anagrams.Occurrences = List((a,1), (e,1), (m,1), (n,1), (s,1
                                                  //| ), (y,1))
  
combinations(occurrences)                         //> res0: List[forcomp.Anagrams.Occurrences] = List(List(), List((a,1)), List((a
                                                  //| ,2)), List((b,1)), List((b,2)), List((a,1), (b,1)), List((a,2), (b,1)), List
                                                  //| ((a,1), (b,2)), List((a,2), (b,2)))
                                                  
combinations(occs3)                               //> res1: List[forcomp.Anagrams.Occurrences] = List(List(), List((a,1)), List((a
                                                  //| ,2)), List((b,1)), List((b,2)), List((c,1)), List((a,1), (b,1)), List((a,2),
                                                  //|  (b,1)), List((a,1), (b,2)), List((a,2), (b,2)), List((a,1), (c,1)), List((a
                                                  //| ,2), (c,1)), List((b,1), (c,1)), List((b,2), (c,1)), List((a,1), (b,1), (c,1
                                                  //| )), List((a,2), (b,1), (c,1)), List((a,1), (b,2), (c,1)), List((a,2), (b,2),
                                                  //|  (c,1)))

                                        
combinations(soc2)                                //> res2: List[forcomp.Anagrams.Occurrences] = List(List(), List((e,1)), List((m
                                                  //| ,1)), List((s,1)), List((n,1)), List((a,1)), List((y,1)), List((e,1), (m,1))
                                                  //| , List((e,1), (s,1)), List((e,1), (n,1)), List((a,1), (e,1)), List((e,1), (y
                                                  //| ,1)), List((m,1), (s,1)), List((m,1), (n,1)), List((a,1), (m,1)), List((m,1)
                                                  //| , (y,1)), List((n,1), (s,1)), List((a,1), (s,1)), List((s,1), (y,1)), List((
                                                  //| a,1), (n,1)), List((n,1), (y,1)), List((a,1), (y,1)), List((e,1), (m,1), (s,
                                                  //| 1)), List((e,1), (m,1), (n,1)), List((a,1), (e,1), (m,1)), List((e,1), (m,1)
                                                  //| , (y,1)), List((e,1), (n,1), (s,1)), List((a,1), (e,1), (s,1)), List((e,1), 
                                                  //| (s,1), (y,1)), List((a,1), (e,1), (n,1)), List((e,1), (n,1), (y,1)), List((a
                                                  //| ,1), (e,1), (y,1)), List((m,1), (n,1), (s,1)), List((a,1), (m,1), (s,1)), Li
                                                  //| st((m,1), (s,1), (y,1)), List((a,1), (m,1), (n,1)), List((m,1), (n,1), (y,1)
                                                  //| ), List((a,1), (m,1), (y,1)), List((a,1), (n,1), (s,1)), List((n,1), (s,1), 
                                                  //| (y,1)), List((a,1), (s,1
                                                  //| Output exceeds cutoff limit.



}