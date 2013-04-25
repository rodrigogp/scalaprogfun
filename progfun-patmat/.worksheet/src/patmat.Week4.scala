package patmat

import patmat.Huffman._

object Week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("Welcome to the Scala worksheet");$skip(89); 

  val sampleTree = makeCodeTree(makeCodeTree(Leaf('x', 1), Leaf('e', 1)), Leaf('t', 2));System.out.println("""sampleTree  : patmat.Huffman.Fork = """ + $show(sampleTree ));$skip(34); 
  val chars = List('a', 'b', 'a');System.out.println("""chars  : List[Char] = """ + $show(chars ));$skip(45); val res$0 = 
  times(List('a', 'b', 'a','c','a','a','b'));System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(66); val res$1 = 

  chars.filter(c => chars.head == c).count(c => chars.head == c);System.out.println("""res1: Int = """ + $show(res$1));$skip(36); val res$2 = 
  chars.count(c => chars.head == c);System.out.println("""res2: Int = """ + $show(res$2));$skip(38); val res$3 = 
  chars.sortWith((c1, c2) => c1 < c2);System.out.println("""res3: List[Char] = """ + $show(res$3))}
}
