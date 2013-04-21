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
    if (c == r || c == 0 || r == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def calculateBalanceValue(balanceValue: Int, character: Char): Int =
      if (character == '(') balanceValue + 1
      else if (character == ')') balanceValue - 1
      else balanceValue

    def recursiveBalance(balanceValue: Int, chars: List[Char]): Boolean =
      if (balanceValue == 0 && chars.isEmpty) true
      else if (balanceValue < 0 || chars.isEmpty) false
      else recursiveBalance(calculateBalanceValue(balanceValue, chars.head), chars.tail)

    recursiveBalance(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def recursiveCountChange(money: Int, coins: List[Int]): Int = {
      if (money > 0 && !coins.isEmpty) recursiveCountChange(money - coins.head, coins) + recursiveCountChange(money, coins.tail)
      else if (money == 0) 1
      else 0
    }
    recursiveCountChange(money, coins)
  }
}
