coursera-scala
==============

Repository for the coursera scala course.

Tools
=====
SBT - Scala Build Tool

Download the sbt installer from here: http://scalasbt.artifactoryonline.com/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.12.4/sbt.msi
Run the installer and verify that sbt is installed correctly by opening the Command Prompt and type sbt sbt-version, you should see the version number of sbt (the first time you run it, sbt will download libraries from the internet). 


Sample Assignment
=================
coursera\scala\example

Implement two recursive methods - max and sum that can be applied on a list of integers.
Ensure that there are unit tests covering the logic, including edge cases.

Assignment 1
=============
coursera\scala\runrec

Exercise 1: Pascal’s Triangle

The following pattern of numbers is called Pascal’s triangle.

        1
      1   1
     1  2  1
    1  3  3 1

The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it. Write a function that computes the elements of Pascal’s triangle by means of a recursive process.Do this exercise by implementing the pascal function in Main.scala, which takes a column c and a row r, counting from 0 and returns the number at that spot in the triangle. For example, pascal(0,2)=1, pascal(1,2)=2 and pascal(1,3)=3.

def pascal(c: Int, r: Int): Int



Exercise 2: Parentheses Balancing

Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char]. For example, the function should return true for the following strings:

1:   (if (zero? x) max (/ 1 x))
2:   I told him (that it’s not (yet) done). (But he wasn’t listening)

The function should return false for the following strings:

1:   :-)
2:   ())(

The last example shows that it’s not enough to verify that a string contains the same number of opening and closing parentheses.

def balance(chars: List[Char]): Boolean

There are three methods on List[Char] that are useful for this exercise:

chars.isEmpty: Boolean returns whether a list is empty
chars.head: Char returns the first element of the list
chars.tail: List[Char] returns the list without the first element
Hint: you can define an inner function if you need to pass extra parameters to your function.

Testing: You can use the toList method to convert from a String to a List[Char]: e.g. "(just an) example".toList.


Assignment 2
============
coursera\scala\funsets

Introduction: 

Representation - We will work with sets of integers.

As an example to motivate our representation, how would you represent the set of all negative integers? You cannot list them all… one way would be so say: if you give me an integer, I can tell you whether it’s in the set or not: for 3, I say ‘no’; for -1, I say yes.

Mathematically, we call the function which takes an integer as argument and which returns a boolean indicating whether the given integer belongs to a set, the characteristic function of the set. For example, we can characterize the set of negative integers by the characteristic function (x: Int) => x < 0.

Therefore, we choose to represent a set by its characterisitc function and define a type alias for this representation:

type Set = Int => Boolean
Using this representation, we define a function that tests for the presence of a value in a set:

def contains(s: Set, elem: Int): Boolean = s(elem)


Exercise 1: Basic Functions on Sets

Let’s start by implementing basic functions on sets.

Define a function which creates a singleton set from one integer value: the set represents the set of the one given element. Its signature is as follows:

def singletonSet(elem: Int): Set


Define the functions union, intersect, and diff, which takes two sets, and return, respectively, their union, intersection and differences. diff(s, t) returns a set which contains all the elements of the set s that are not in the set t. These functions have the following signatures:

def union(s: Set, t: Set): Set
def intersect(s: Set, t: Set): Set
def diff(s: Set, t: Set): Set

Define the function filter which selects only the elements of a set that are accepted by a given predicate p. The filtered elements are returned as a new set. The signature of filter is as follows:

def filter(s: Set, p: Int => Boolean): Set

Exercise 2: Queries and Transformations on Sets

In this part, we are interested in functions used to make requests on elements of a set. The first function tests whether a given predicate is true for all elements of the set. This forall function has the following signature:

def forall(s: Set, p: Int => Boolean): Boolean

Note that there is no direct way to find which elements are in a set. contains only allows to know whether a given element is included. Thus, if we wish to do something to all elements of a set, then we have to iterate over all integers, testing each time whether it is included in the set, and if so, to do something with it. Here, we consider that an integer x has the property -1000 <= x <= 1000 in order to limit the search space.

Implement forall using linear recursion. For this, use a helper function nested in forall. Its structure is as follows (replace the ???):

def forall(s: Set, p: Int => Boolean): Boolean = {
 def iter(a: Int): Boolean = {
   if (???) ???
   else if (???) ???
   else iter(???)
 }
 iter(???)
}

Using forall, implement a function exists which tests whether a set contains at least one element for which the given predicate is true. Note that the functions forall and exists behave like the universal and existential quantifiers of first-order logic.

def exists(s: Set, p: Int => Boolean): Boolean
Finally, write a function map which transforms a given set into another one by applying to each of its elements the given function. map has the following signature:

def map(s: Set, f: Int => Int): Set




