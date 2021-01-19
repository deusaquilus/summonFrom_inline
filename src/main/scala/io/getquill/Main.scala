package io.getquill

object Main {
  def main(args: Array[String]): Unit = {
    import Foo._

    println( Example.run[Foo](123) )

    // This works
    //println( Example.runUsing[Foo](123) )
  }
}