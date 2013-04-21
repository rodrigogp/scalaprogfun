package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
      assert(!contains(s1, 2), "Singleton")
      assert(contains(s2, 2), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")

      val sUs1s2 = union(s1, s2)
      val sUs1s3 = union(s1, s3)
      val sU = union(sUs1s2, sUs1s3)

      assert(contains(sU, 1), "Union 1")
      assert(contains(sU, 2), "Union 2")
      assert(contains(sU, 3), "Union 3")

      printSet(sUs1s2)
      printSet(sUs1s3)
      printSet(sU)
    }
  }

  test("intersection contains shared elements") {
    new TestSets {
      val sUs1s2 = union(s1, s2)
      val sUs1s3 = union(s1, s3)
      val sI = intersect(sUs1s2, sUs1s3)
      assert(contains(sI, 1), "Intersection 1")
      assert(!contains(sI, 2), "Intersection 2")
      assert(!contains(sI, 3), "Intersection 3")

      printSet(sI)
    }
  }

  test("diff contains not shared elements") {
    new TestSets {
      val sUs1s2 = union(s1, s2)
      val sUs1s3 = union(s1, s3)
      val sD = diff(sUs1s2, sUs1s3)
      assert(!contains(sD, 1), "diff 1")
      assert(contains(sD, 2), "diff 2")
      assert(!contains(sD, 3), "diff 3")

      printSet(sD)
    }
  }

  test("filter test") {
    new TestSets {
      val sUs1s2 = union(s1, s2)
      val sUs1s3 = union(s1, s3)
      val sU = union(sUs1s2, sUs1s3)

      val sF = filter(sU, y => y % 2 == 0)
      assert(!contains(sF, 1), "filter 1")
      assert(contains(sF, 2), "filter 2")
      assert(!contains(sF, 3), "filter 3")

      printSet(sU)
      printSet(sF)
    }
  }

  test("forall test") {
    new TestSets {
      val sUs1s2 = union(s1, s2)
      val sUs1s3 = union(s1, s3)
      val sU = union(sUs1s2, sUs1s3)

      assert(forall(sU, x => x / x == 1), "forall x/x==1")
      assert(!forall(sU, x => x / 2 == 1), "forall x/2==1")
      assert(!forall(sU, x => x % 2 == 0), "forall x%2==0")

      printSet(sU)
    }
  }

  test("exists test") {
    new TestSets {
      val sUs1s2 = union(s1, s2)
      val sUs1s3 = union(s1, s3)
      val sU = union(sUs1s2, sUs1s3)

      assert(exists(sU, x => x == 1), "exists x==1")
      assert(exists(sU, x => x / 2 == 1), "exists x/2==1")
      assert(exists(sU, x => x % 2 == 0), "exists x%2==0")
      assert(!exists(sU, x => x == 4), "exists x==4")

      println("exists")
      printSet(sU)
    }
  }

  test("map test") {
    new TestSets {
      val sUs1s2 = union(s1, s2)
      val sUs1s3 = union(s1, s3)
      val sU = union(sUs1s2, sUs1s3)

      val sM = map(sU, x => x * 3)

      assert(contains(sM, 3), "map x*3 contains 3")
      assert(contains(sM, 6), "map x*3 contains 6")
      assert(contains(sM, 9), "map x*3 contains 9")

      println("Map")
      printSet(sU)
      printSet(sM)
    }
  }
}