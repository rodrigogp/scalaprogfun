package worksheets

object rationals {
  val x = new Rational(1, 3)                      //> x  : worksheets.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : worksheets.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : worksheets.Rational = 3/2
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  x + y                                           //> res2: worksheets.Rational = 22/21
  x - y - z                                       //> res3: worksheets.Rational = -79/42
  y + y                                           //> res4: worksheets.Rational = 10/7
  x < y                                           //> res5: Boolean = true
  x max y                                         //> res6: worksheets.Rational = 5/7
  new Rational(2)                                 //> res7: worksheets.Rational = 2/1
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