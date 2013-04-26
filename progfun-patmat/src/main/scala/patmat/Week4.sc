package patmat

import patmat.Huffman._

object Week4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val sampleTree = makeCodeTree(makeCodeTree(Leaf('x', 1), Leaf('e', 1)), Leaf('t', 2))
                                                  //> sampleTree  : patmat.Huffman.Fork = Fork(Fork(Leaf(x,1),Leaf(e,1),List(x, e)
                                                  //| ,2),Leaf(t,2),List(x, e, t),4)

  val chars = List('a', 'b', 'c')                 //> chars  : List[Char] = List(a, b, c)
  val freqs = times(List('a', 'b', 'a', 'c', 'a', 'a', 'b'))
                                                  //> freqs  : List[(Char, Int)] = List((a,4), (b,2), (c,1))

  times(List('a', 'b', 'a', 'c', 'a', 'a', 'b', 'a', 'c'))
                                                  //> res0: List[(Char, Int)] = List((a,5), (b,2), (c,2))

  //times(List(('a',5), ('a',3), ('k',2), ('b',2), ('r',2), ('a',1)))
  //did not equal List((a,5), (b,4), (r,3), (k,2), (d,1))
  chars.filter(c => chars.head == c).count(c => chars.head == c)
                                                  //> res1: Int = 1
  chars.count(c => chars.head == c)               //> res2: Int = 1
  chars.sortWith((c1, c2) => c1 < c2)             //> res3: List[Char] = List(a, b, c)

  val sortedFreqs = freqs.sortBy(_._2)            //> sortedFreqs  : List[(Char, Int)] = List((c,1), (b,2), (a,4))
  val sortedLeafs = sortedFreqs.map(p => Leaf(p._1, p._2))
                                                  //> sortedLeafs  : List[patmat.Huffman.Leaf] = List(Leaf(c,1), Leaf(b,2), Leaf(a
                                                  //| ,4))
  val chars2 = List('a', 'b')                     //> chars2  : List[Char] = List(a, b)
  val trees = makeOrderedLeafList(times(chars2))  //> trees  : List[patmat.Huffman.Leaf] = List(Leaf(a,1), Leaf(b,1))
  singleton(trees)                                //> res4: Boolean = false

  val combinedTrees = combine(trees)              //> combinedTrees  : List[patmat.Huffman.CodeTree] = List(Fork(Leaf(a,1),Leaf(b,
                                                  //| 1),List(a, b),2))
  combinedTrees.size                              //> res5: Int = 1

  singleton(combinedTrees)                        //> res6: Boolean = true

  singleton(trees)                                //> res7: Boolean = false
  combine(sortedLeafs)                            //> res8: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(c,1),Leaf(b,2),List(c, 
                                                  //| b),3), Leaf(a,4))
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
                                                  //> leaflist  : List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,4
                                                  //| ))
  combine(leaflist)                               //> res9: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(e,1),Leaf(t,2),List(e,
                                                  //|  t),3), Leaf(x,4))
  val hw = List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd')
                                                  //> hw  : List[Char] = List(h, e, l, l, o, ,,  , w, o, r, l, d)
  createCodeTree(hw)                              //> res10: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Fork(Fork(Fork(Fork(Le
                                                  //| af( ,1),Leaf(,,1),List( , ,),2),Leaf(d,1),List( , ,, d),3),Leaf(e,1),List( 
                                                  //| , ,, d, e),4),Leaf(h,1),List( , ,, d, e, h),5),Leaf(r,1),List( , ,, d, e, h
                                                  //| , r),6),Leaf(w,1),List( , ,, d, e, h, r, w),7),Leaf(o,2),List( , ,, d, e, h
                                                  //| , r, w, o),9),Leaf(l,3),List( , ,, d, e, h, r, w, o, l),12)
val code = createCodeTree(chars)                  //> code  : patmat.Huffman.CodeTree = Fork(Fork(Leaf(a,1),Leaf(b,1),List(a, b),
                                                  //| 2),Leaf(c,1),List(a, b, c),3)
 decode(code,List(0,0,0,1,1))                     //> res11: List[Char] = List(a, b, c)
 
 encode(code)(List('a', 'b', 'c'))                //> res12: List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 1)
 
 convert(code)                                    //> res13: patmat.Huffman.CodeTable = List((a,List(0, 0)), (b,List(0, 1)), (c,L
                                                  //| ist(1)))
 quickEncode(code)(List('a', 'b', 'c'))           //> res14: List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 1)
 
 decode(frenchCode, secret)                       //> res15: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
 
  val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  encode(t1)("ab".toList)                         //> res16: List[patmat.Huffman.Bit] = List(0, 1)
  
  quickEncode(t1)("ab".toList)                    //> res17: List[patmat.Huffman.Bit] = List(0, 1)
  
}