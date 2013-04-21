package common

object setsws {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(284); 

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(112); 

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = x => x == elem;System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(193); 

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = x => contains(s, x) || contains(t, x);System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(202); 

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = x => contains(s, x) && contains(t, x);System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(194); 
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = x => contains(s,x) && !contains(t,x);System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(139); 

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = x => contains(s,x) && p(x);System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(88); 

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(294); 

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
   def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a < -bound) true
      else if (contains(s, a)) p(a) && iter(a - 1)
      else iter(a - 1)
    }
    iter(bound)
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(174); 


/**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x));System.out.println("""exists: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(52); 

  def s1 = union(singletonSet(1), singletonSet(2));System.out.println("""s1: => Int => Boolean""");$skip(51); 
  def s2 = union(singletonSet(3), singletonSet(4));System.out.println("""s2: => Int => Boolean""");$skip(25); 
  def ut = union(s1, s2);System.out.println("""ut: => Int => Boolean""");$skip(51); 
  def s3 = union(singletonSet(2), singletonSet(4));System.out.println("""s3: => Int => Boolean""");$skip(29); 
  def i1 = intersect(s1, s2);System.out.println("""i1: => Int => Boolean""");$skip(29); 
  def i2 = intersect(s1, s3);System.out.println("""i2: => Int => Boolean""");$skip(25); val res$0 = 
  
	forall(s3,y=>y%2==0);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(24); val res$1 = 
	
	exists(s3,y=>y/2==2);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(24); val res$2 = 
	
	exists(s3,y=>y/2==3);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(22); val res$3 = 
	exists(s3,y=>y/2==2);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(24); val res$4 = 
	
	forall(s3,y=>y/2==2);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(22); val res$5 = 
	forall(s3,y=>y/2==3);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(134); 
	
//	def map(s: Set, f: Int => Int): Set = x => exists(s,y=>y==f(x))
	def map(s: Set, f: Int => Int): Set = x => exists(s,y=>f(y)==x);System.out.println("""map: (s: Int => Boolean, f: Int => Int)Int => Boolean""");$skip(33); 
	
	def s3mapped = map(s3,x=>x*3);System.out.println("""s3mapped: => Int => Boolean""");$skip(24); val res$6 = 
	
	contains(s3mapped,6);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(25); val res$7 = 
	
	contains(s3mapped,12);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(185); 
	
	/**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  };System.out.println("""toString: (s: Int => Boolean)String""");$skip(117); 

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  };System.out.println("""printSet: (s: Int => Boolean)Unit""");$skip(16); 
	
	printSet(s3);$skip(26); 
	printSet(map(s3,x=>x*3))}
	
}
