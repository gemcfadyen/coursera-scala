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

  test("pascal: col=0,row=0") {
    assert(pascal(0, 0) === 1)
  }

  test("pascal: col=1,row=1") {
    assert(pascal(1, 1) === 1)
  }

  test("pascal: col=4, row=4") {
    assert(pascal(4, 4) === 1)
  }

  test("pascal: col=3, row=3") {
    assert(pascal(3, 3) === 1)
  }

 /* test("pascal: col=40, row=2000") {
    assert(pascal(40, 2000) === 1095651)
  }*/

  test("should throw an exception when the column index is outside permittable range") {
    intercept[StackOverflowError] {
      pascal(1, 0)
    }
  }
}
