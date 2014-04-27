package recfun

import common._

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
      var total = 0;
      total = pascal(c - 1, r - 1) + pascal(c, r - 1)
      total
    }
  }

  /**
   * Exercise 2
   */
  // def balance(chars: List[Char]): Boolean = ???

  /**
   * Exercise 3
   */
  // def countChange(money: Int, coins: List[Int]): Int = ???
}
