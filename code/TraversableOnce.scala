trait GenTraversableOnce[+A] extends Any {
  ...
  def isTraversableAgain: Boolean
  ...
}

trait TraversableOnce[+A] extends Any with GenTraversableOnce[A] {
  ...
  def size: Int = {
    var result = 0
    for (x <- self) result += 1
    result
  }
  ...
  def toArray[B >: A : ClassTag]: Array[B] = {
    if (this.isTraversableAgain) {
      val result = new Array[B](this.size)
      this.copyToArray(result, 0)
      result
    }
    else this.toBuffer.toArray
  }
  ...
}

trait Iterator[+A] extends TraversableOnce[A] {
  ...
  def isTraversableAgain = false
  ...
}

/** A template trait for traversable collections of type `Traversable[A]`.
    ...
 */
trait TraversableLike[+A, +Repr] extends Any
                                    with HasNewBuilder[A, Repr]
                                    with FilterMonadic[A, Repr]
                                    with TraversableOnce[A]
                                    with GenTraversableLike[A, Repr]
                                    with Parallelizable[A, ParIterable[A]]
{
  ...
  final def isTraversableAgain: Boolean = true
  ...
}
