package patmat

import patmat.Huffman._

object Week4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val sampleTree = makeCodeTree(makeCodeTree(Leaf('x', 1), Leaf('e', 1)), Leaf('t', 2))
                                                  //> sampleTree  : patmat.Huffman.Fork = Fork(Fork(Leaf(x,1),Leaf(e,1),List(x, e)
                                                  //| ,2),Leaf(t,2),List(x, e, t),4)
  val chars = List('a', 'b', 'a')                 //> chars  : List[Char] = List(a, b, a)
  times(List('a', 'b', 'a','c','a','a','b'))      //> res0: List[(Char, Int)] = List((a,4), (b,2), (c,1))

  chars.filter(c => chars.head == c).count(c => chars.head == c)
                                                  //> res1: Int = 2
  chars.count(c => chars.head == c)               //> res2: Int = 2
  chars.sortWith((c1, c2) => c1 < c2)             //> res3: List[Char] = List(a, a, b)
}