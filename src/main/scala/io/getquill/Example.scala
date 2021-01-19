package io.getquill

import scala.quoted._
import scala.compiletime._

trait Foo
object Foo {
  inline given DoStuff[Foo] with {
    inline def stuff(input: Int): String = "foo:" + input
  }
}

trait DoStuff[T] {
  inline def stuff(input: Int): String
}

object Example {
  inline def summonStuff[T] = summonFrom {
    case ds: DoStuff[T] => ds
  }

  inline def run[T](i: Int) = {
    summonStuff[T].stuff(i)
  }

  // This will work
  //inline def runUsing[T](i: Int)(using doStuff: DoStuff[T]) = doStuff.stuff(i)
}