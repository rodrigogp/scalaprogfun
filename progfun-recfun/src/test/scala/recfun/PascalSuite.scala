package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0, 2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1, 2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1, 3) === 3)
  }

  test("pascal: col=2,row=5") {
    assert(pascal(2, 5) === 10)
  }

  test("pascal: col=5,row=10") {
    assert(pascal(5, 10) === 252)
  }

  test("pascal: col=6,row=20") {
    assert(pascal(6, 20) === 38760)
  }

  test("pascal: col=0,row=20") {
    assert(pascal(0, 20) === 1)
  }

  test("pascal: col=20,row=20") {
    assert(pascal(20, 20) === 1)
  }

  test("pascal: col=13,row=13") {
    assert(pascal(13, 13) === 1)
  }
}
