package u02

object HigherOrderFunctions extends App:

  // non-higher-order, i.e., "first order"
  val f = (x: Int, y: Int) => x + y
  // higher-order function: some input/ouput is a function itself
  val h: (Int, Int, (Int, Int) => Int) => Int = (a, b, f) => f(a, b)

  println(h(10, 5, _ * _)) // 50
  println(h(10, 5, (a, b) => a + b )) // 15
  println(h(10, 5, f)) // 15

  val i: (Int, Int => Int, Int => Int) => Int =
    (n, f1, f2) => f1(f2(n))

  println(i(10, _ + 1, _ * 2)) // 21

  val l: (Int => Int) => (Int => Int) =
    f => (i => f(f(i))) // without parens: f => i => f(f(i))

  println(l(_ + 1)(10)) // 12, see currying next..

  val positive: Int => String = _ match
      case x if x >= 0 => "positive"
      case x if x < 0 => "negative"

  println(positive(-22))

  def empty: String => Boolean = _ == ""

  println(empty(""))

  def neg(f: String => Boolean): String => Boolean = x => !f(x)

  def genericNeg[A](f: A => Boolean): A => Boolean = x => !f(x)
//  def negEmpty(x: String): Boolean = neg(empty(x))

  def notEmpty = neg(empty)

  def genericNotEmpty = genericNeg(empty)

  println(empty(""))
  println(empty("w"))
  println(notEmpty(""))
  println(notEmpty("w"))
  println(genericNotEmpty(""))
  println(genericNotEmpty("w"))