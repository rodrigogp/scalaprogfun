package patmat

import patmat.Huffman._

object Week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("Welcome to the Scala worksheet");$skip(89); 

  val sampleTree = makeCodeTree(makeCodeTree(Leaf('x', 1), Leaf('e', 1)), Leaf('t', 2));System.out.println("""sampleTree  : patmat.Huffman.Fork = """ + $show(sampleTree ));$skip(35); 

  val chars = List('a', 'b', 'c');System.out.println("""chars  : List[Char] = """ + $show(chars ));$skip(61); 
  val freqs = times(List('a', 'b', 'a', 'c', 'a', 'a', 'b'));System.out.println("""freqs  : List[(Char, Int)] = """ + $show(freqs ));$skip(60); val res$0 = 

  times(List('a', 'b', 'a', 'c', 'a', 'a', 'b', 'a', 'c'));System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(194); val res$1 = 

  //times(List(('a',5), ('a',3), ('k',2), ('b',2), ('r',2), ('a',1)))
  //did not equal List((a,5), (b,4), (r,3), (k,2), (d,1))
  chars.filter(c => chars.head == c).count(c => chars.head == c);System.out.println("""res1: Int = """ + $show(res$1));$skip(36); val res$2 = 
  chars.count(c => chars.head == c);System.out.println("""res2: Int = """ + $show(res$2));$skip(38); val res$3 = 
  chars.sortWith((c1, c2) => c1 < c2);System.out.println("""res3: List[Char] = """ + $show(res$3));$skip(40); 

  val sortedFreqs = freqs.sortBy(_._2);System.out.println("""sortedFreqs  : List[(Char, Int)] = """ + $show(sortedFreqs ));$skip(59); 
  val sortedLeafs = sortedFreqs.map(p => Leaf(p._1, p._2));System.out.println("""sortedLeafs  : List[patmat.Huffman.Leaf] = """ + $show(sortedLeafs ));$skip(30); 
  val chars2 = List('a', 'b');System.out.println("""chars2  : List[Char] = """ + $show(chars2 ));$skip(49); 
  val trees = makeOrderedLeafList(times(chars2));System.out.println("""trees  : List[patmat.Huffman.Leaf] = """ + $show(trees ));$skip(19); val res$4 = 
  singleton(trees);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(38); 

  val combinedTrees = combine(trees);System.out.println("""combinedTrees  : List[patmat.Huffman.CodeTree] = """ + $show(combinedTrees ));$skip(21); val res$5 = 
  combinedTrees.size;System.out.println("""res5: Int = """ + $show(res$5));$skip(28); val res$6 = 

  singleton(combinedTrees);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(20); val res$7 = 

  singleton(trees);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(23); val res$8 = 
  combine(sortedLeafs);System.out.println("""res8: List[patmat.Huffman.CodeTree] = """ + $show(res$8));$skip(64); 
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4));System.out.println("""leaflist  : List[patmat.Huffman.Leaf] = """ + $show(leaflist ));$skip(20); val res$9 = 
  combine(leaflist);System.out.println("""res9: List[patmat.Huffman.CodeTree] = """ + $show(res$9));$skip(76); 
  val hw = List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd');System.out.println("""hw  : List[Char] = """ + $show(hw ));$skip(21); val res$10 = 
  createCodeTree(hw);System.out.println("""res10: patmat.Huffman.CodeTree = """ + $show(res$10));$skip(33); 
val code = createCodeTree(chars);System.out.println("""code  : patmat.Huffman.CodeTree = """ + $show(code ));$skip(30); val res$11 = 
 decode(code,List(0,0,0,1,1));System.out.println("""res11: List[Char] = """ + $show(res$11));$skip(37); val res$12 = 
 
 encode(code)(List('a', 'b', 'c'));System.out.println("""res12: List[patmat.Huffman.Bit] = """ + $show(res$12));$skip(17); val res$13 = 
 
 convert(code);System.out.println("""res13: patmat.Huffman.CodeTable = """ + $show(res$13));$skip(40); val res$14 = 
 quickEncode(code)(List('a', 'b', 'c'));System.out.println("""res14: List[patmat.Huffman.Bit] = """ + $show(res$14));$skip(30); val res$15 = 
 
 decode(frenchCode, secret);System.out.println("""res15: List[Char] = """ + $show(res$15));$skip(65); 
 
  val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5);System.out.println("""t1  : patmat.Huffman.Fork = """ + $show(t1 ));$skip(26); val res$16 = 
  encode(t1)("ab".toList);System.out.println("""res16: List[patmat.Huffman.Bit] = """ + $show(res$16));$skip(34); val res$17 = 
  
  quickEncode(t1)("ab".toList);System.out.println("""res17: List[patmat.Huffman.Bit] = """ + $show(res$17))}
  
}
