package streams

object week7 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 

  val levelVector = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'));System.out.println("""levelVector  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(levelVector ));$skip(91); val res$0 = 

  levelVector.isDefinedAt(0) && levelVector(0).isDefinedAt(1) && levelVector(0)(1) != '-';System.out.println("""res0: Boolean = """ + $show(res$0));$skip(53); val res$1 = 

  levelVector.indexWhere(x => x.indexOf('T') != -1);System.out.println("""res1: Int = """ + $show(res$1));$skip(79); val res$2 = 

  levelVector(levelVector.indexWhere(x => x.indexOf('T') != -1)).indexOf('T');System.out.println("""res2: Int = """ + $show(res$2));$skip(69); 

  val v = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9));System.out.println("""v  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Int]] = """ + $show(v ));$skip(14); 
  val num = 4;System.out.println("""num  : Int = """ + $show(num ));$skip(24); val res$3 = 

  v.map(_ indexOf num);System.out.println("""res3: scala.collection.immutable.Vector[Int] = """ + $show(res$3));$skip(36); val res$4 = 
  v.map(_ indexOf num).zipWithIndex;System.out.println("""res4: scala.collection.immutable.Vector[(Int, Int)] = """ + $show(res$4));$skip(52); val res$5 = 
  v.map(_ indexOf num).zipWithIndex.find(_._1 > -1);System.out.println("""res5: Option[(Int, Int)] = """ + $show(res$5));$skip(78); 

  val Some((posY, posX)) = v.map(_ indexOf num).zipWithIndex.find(_._1 > -1);System.out.println("""posY  : Int = """ + $show(posY ));System.out.println("""posX  : Int = """ + $show(posX ));$skip(148); 

val level =
      """ooo-------
        |oSoooo----
        |ooooooooo-
        |-ooooooooo
        |-----ooToo
        |------ooo-""".stripMargin;System.out.println("""level  : String = """ + $show(level ));$skip(59); val res$6 = 
 Vector(level.split("\n").map(str => Vector(str: _*)): _*);System.out.println("""res6: scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(res$6))}
}
