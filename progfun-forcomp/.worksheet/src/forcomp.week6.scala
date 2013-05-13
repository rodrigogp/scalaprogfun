package forcomp

import Anagrams._

object week6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  val occurrences = List(('a', 2), ('b', 2));System.out.println("""occurrences  : List[(Char, Int)] = """ + $show(occurrences ));$skip(49); 
  val occs3 = List(('a', 2), ('b', 2), ('c', 1));System.out.println("""occs3  : List[(Char, Int)] = """ + $show(occs3 ));$skip(40); 
  val sentence = List("Linux", "rulez");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(42); 
  val soc = sentenceOccurrences(sentence);System.out.println("""soc  : forcomp.Anagrams.Occurrences = """ + $show(soc ));$skip(38); 

  val sentence2 = List("Yes", "man");System.out.println("""sentence2  : List[String] = """ + $show(sentence2 ));$skip(44); 
  val soc2 = sentenceOccurrences(sentence2);System.out.println("""soc2  : forcomp.Anagrams.Occurrences = """ + $show(soc2 ));$skip(29); val res$0 = 
  
combinations(occurrences);System.out.println("""res0: List[forcomp.Anagrams.Occurrences] = """ + $show(res$0));$skip(71); val res$1 = 
                                                  
combinations(occs3);System.out.println("""res1: List[forcomp.Anagrams.Occurrences] = """ + $show(res$1));$skip(61); val res$2 = 

                                        
combinations(soc2);System.out.println("""res2: List[forcomp.Anagrams.Occurrences] = """ + $show(res$2))}



}
