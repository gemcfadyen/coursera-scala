package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {

  import Main.balance

  test("should balance when there is only one opening and one closing bracket") {
    assert(balance("()".toList) === true)
  }

  test("should balance if there are no bracket") {
    assert(balance("".toList) === true)
  }

  test("should not balance if there is only one bracket present") {
    assert(balance("abc(def".toList) === false)
  }

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  test("should not balance when there are brackets out of order") {
    assert(!balance(")()(".toList))
  }
}
