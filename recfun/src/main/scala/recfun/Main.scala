package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    if (c < 0) {
      0
    }
    else if (r <= 1 && c <= r) {
      1
    }
    else if (r == c) {
      1
    }
    else {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  }

  /**
   * Exercise 2
   */

  def balance(chars: List[Char]): Boolean = {

    def getIncrement(element: Char): Int = {
      if (element == '(')
        1
      else if (element == ')')
        -1
      else
        0
    }

    @tailrec
    def balanceCount(list: List[Char], count: Int): Boolean = {
      if (count < 0)
        false

      else if (list.isEmpty)
        (count == 0)

      else
        balanceCount(list.tail, count + getIncrement(list.head))
    }

    balanceCount(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def calculateCombinationsOfCoins(total: Int, change: List[Int], noOfWays: Int): Int = {
      if (total == 0) {
        noOfWays + 1
      }

      else if (change.isEmpty) {
        noOfWays
      }

      else if (total < 0) {
        noOfWays
      }
      else {
        calculateCombinationsOfCoins(total - change.head, change, noOfWays) + calculateCombinationsOfCoins(total, change.tail, noOfWays)
      }
    }

    if (money == 0) {
      0
    }
    else {
      calculateCombinationsOfCoins(money, coins, 0)
    }
  }

}
