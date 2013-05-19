package worksheets

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  val problem = new Pouring(Vector(4, 9, 19));System.out.println("""problem  : worksheets.Pouring = """ + $show(problem ));$skip(16); val res$0 = 
  problem.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with worksheets.test.problem.Move] = """ + $show(res$0));$skip(24); val res$1 = 
  problem.solutions(17);System.out.println("""res1: Stream[worksheets.test.problem.Path] = """ + $show(res$1))}

}
