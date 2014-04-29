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
    @tailrec
    def balanceCount(list: List[Char], count: Int): Boolean = {
      if (count < 0)
        false

      else if (list.isEmpty)
        (count == 0)

      else if (list.head == '(')
        balanceCount(list.tail, count + 1)

      else if (list.head == ')')
        balanceCount(list.tail, count - 1)

      else
        balanceCount(list.tail, count)

    }

    balanceCount(chars, 0)
  }


  def lengthList(chars: List[Char]): Int = {
    def length(list: List[Char], size: Integer): Int = {
      if (list.isEmpty) {
        size
      }
      else {
        length(list.tail, size + 1)
      }
    }

    length(chars, 0)
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = 1
}
