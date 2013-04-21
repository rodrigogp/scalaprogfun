package worksheets

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); 
  val x = new Rational(1, 3);System.out.println("""x  : worksheets.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : worksheets.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : worksheets.Rational = """ + $show(z ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(8); val res$2 = 
  x + y;System.out.println("""res2: worksheets.Rational = """ + $show(res$2));$skip(12); val res$3 = 
  x - y - z;System.out.println("""res3: worksheets.Rational = """ + $show(res$3));$skip(8); val res$4 = 
  y + y;System.out.println("""res4: worksheets.Rational = """ + $show(res$4));$skip(8); val res$5 = 
  x < y;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(10); val res$6 = 
  x max y;System.out.println("""res6: worksheets.Rational = """ + $show(res$6));$skip(18); val res$7 = 
  new Rational(2);System.out.println("""res7: worksheets.Rational = """ + $show(res$7))}
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be non zero")
  //require(y > 0, "denominator must be postive") => IllegalArgumentException
  //assert(x > 0) => assertion error

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def numer = x
  def denom = y
  //def numer = x / gcd(x,y)
  //def denom = y / gcd(x,y)
  //val numer = x / gcd(x,y)
  //val denom = y / gcd(x,y)

  def +(r: Rational) =
    new Rational(numer * r.denom + r.numer * denom,
      denom * r.denom)

  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this < that) that else this

  def unary_- : Rational = new Rational(-numer, denom)

  def -(that: Rational) = this + -that

  //however is better to do the gcd before so we avoid/delay potential arithmetics overflows
  override def toString = {
    val g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }

}
