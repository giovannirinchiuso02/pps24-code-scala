package u02

object Currying extends App :

  // standard function with no currying
  def mult(x: Double, y: Double): Double = x * y

  // function with currying
  // curriedMult has actually type: Double => (Double => Double)
  def curriedMult(x: Double)(y: Double): Double = x * y

  def div(x: Double, y: Double): Double = x / y

  def carriedDiv(x: Double)(y: Double): Double = x / y

  // slightly different syntax at the call side..
  println(mult(10, 2)) // 20
  println(curriedMult(10)(2)) // 20

  // curriedMult can be partially applied!
  val twice: Double => Double = curriedMult(2)

  println(twice(10)) // 20
  val first = curriedMult(2)
  println(first)
  val second = first(100)
  println(second)

  // => is right-associative, hence it is equal to:
  //val curr...: Double => (Double => Double) = x => (y => x*y)
  val curriedMultAsFunction: Double => Double => Double = x => y => x * y

  println(curriedMultAsFunction(10)(2)) // 20
  println(div(10, 2))
  val firs = carriedDiv(10)
  println(firs)
  val secon = firs(3)
  println(secon)
  println(curriedMultAsFunction) // u02.Currying$$$Lambda$7/...
  println(curriedMultAsFunction(10)) // u02.Currying$$$Lambda$12/...