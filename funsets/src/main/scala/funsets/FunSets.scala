package funsets

import common._
import scala.annotation.tailrec

/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = Set(elem)

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = {
    (x: Int) => contains(s, x) || contains(t, x)
  }

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = {
    (x: Int) => contains(s, x) && contains(t, x)
  }

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = {
    (x: Int) => contains(s, x) && !contains(t, x)
  }

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = {
    (x: Int) => contains(s, x) && p(x)
  }

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 5

  def withinBounds(x: Int): Boolean = {
    (x <= bound || x <= -bound)
  }

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (!withinBounds(a)) true
      else if (contains(s, a) && !p(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = {
     !forall(s, (x: Int) => !p(x))
//    def iter(a: Int): Boolean = {
//      if (!withinBounds(a)) false // !forall would make this true if all items satisfy the original predicate, inline with the original forall
//      else if (contains(s, a) && p(a)) true //!p(a) would mean this would return true if there was an item that DIDNT match p. !forall would make this return false
//      else if (contains(s, a) && !p(a)) iter(a + 1) // !p(x) would mean this would be matched if the original p is satisfied, so we fall out of the loop only when out of bounds, or there is an item which does not satisfy the original predicate.
//      else iter(a + 1)
//    }
//    iter(-bound)
  }

  //  So using !forall(s, (x:Int)=>!p(x))  actually creates the predicate condition
  //  else if (contains(s, a) && p(a)) true
  //  else if (contains(s, a) && !p(a)) false

   /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = {
    @tailrec
    def iter(a: Int, temporarySet: Set): Set = {
      if (!withinBounds(a)) temporarySet
      else if (contains(s, a)) iter(a + 1, union(temporarySet, singletonSet(f(a))))
      else iter(a + 1, temporarySet)
    }
    iter(-bound, Set())
  }

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}