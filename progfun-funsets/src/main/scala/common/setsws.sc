package common

object setsws {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = x => x == elem
                                                  //> singletonSet: (elem: Int)Int => Boolean

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = x => contains(s, x) || contains(t, x)
                                                  //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = x => contains(s, x) && contains(t, x)
                                                  //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = x => contains(s,x) && !contains(t,x)
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = x => contains(s,x) && p(x)
                                                  //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000                                //> bound  : Int = 1000

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
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean


/**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))
                                                  //> exists: (s: Int => Boolean, p: Int => Boolean)Boolean

  def s1 = union(singletonSet(1), singletonSet(2))//> s1: => Int => Boolean
  def s2 = union(singletonSet(3), singletonSet(4))//> s2: => Int => Boolean
  def ut = union(s1, s2)                          //> ut: => Int => Boolean
  def s3 = union(singletonSet(2), singletonSet(4))//> s3: => Int => Boolean
  def i1 = intersect(s1, s2)                      //> i1: => Int => Boolean
  def i2 = intersect(s1, s3)                      //> i2: => Int => Boolean
  
	forall(s3,y=>y%2==0)                      //> res0: Boolean = true
	
	exists(s3,y=>y/2==2)                      //> res1: Boolean = true
	
	exists(s3,y=>y/2==3)                      //> res2: Boolean = false
	exists(s3,y=>y/2==2)                      //> res3: Boolean = true
	
	forall(s3,y=>y/2==2)                      //> res4: Boolean = false
	forall(s3,y=>y/2==3)                      //> res5: Boolean = false
	
//	def map(s: Set, f: Int => Int): Set = x => exists(s,y=>y==f(x))
	def map(s: Set, f: Int => Int): Set = x => exists(s,y=>f(y)==x)
                                                  //> map: (s: Int => Boolean, f: Int => Int)Int => Boolean
	
	def s3mapped = map(s3,x=>x*3)             //> s3mapped: => Int => Boolean
	
	contains(s3mapped,6)                      //> res6: Boolean = true
	
	contains(s3mapped,12)                     //> res7: Boolean = true
	
	/**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: Int => Boolean)String

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: Int => Boolean)Unit
	
	printSet(s3)                              //> {2,4}
	printSet(map(s3,x=>x*3))                  //> {6,12}
	
}