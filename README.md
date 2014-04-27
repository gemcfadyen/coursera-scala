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




