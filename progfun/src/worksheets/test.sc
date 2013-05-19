package worksheets

object test {
  val problem = new Pouring(Vector(4, 9, 19))     //> problem  : worksheets.Pouring = worksheets.Pouring@2adb1d4
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with wo
                                                  //| rksheets.test.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0), F
                                                  //| ill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Pour(
                                                  //| 2,1))
  problem.solutions(17)                           //> res1: Stream[worksheets.test.problem.Path] = Stream(Fill(0) Pour(0,2) Fill(0
                                                  //| ) Pour(0,2) Fill(1) Pour(1,2)--> Vector(0, 0, 17), ?)

}