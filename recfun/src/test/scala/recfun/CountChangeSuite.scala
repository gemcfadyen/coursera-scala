package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {

  import Main.countChange
  import Main.getListOfChangeCombinations
  test("should return one combination if there is only 1's available") {
    assert(countChange(100, List(1)) === 1)
  }

  test("should return one combination if there is only an even coin available for an even number") {
    assert(countChange(100, List(1)) === 1)
  }

  test("should return zero combination if there is only an even coin available for an odd number") {
    assert(countChange(3, List(2)) === 0)
  }

  test("if you have no coins then you have no combinations of change") {
    assert(countChange(4, List()) === 0)
  }

  test("if you have no money then there are no combinations of change") {
    assert(countChange(0, List(1, 2, 4)) === 0)
  }

  test("countChange: example given in instructions") {
    assert(countChange(4, List(1, 2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300, List(5, 10, 20, 50, 100, 200, 500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301, List(5, 10, 20, 50, 100, 200, 500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300, List(500, 5, 50, 100, 20, 200, 10)) === 1022)
  }
}
