package fp

object Main extends Running {
  def main(args: Array[String]): Unit =
    println(implicitly[Serializer[SafeResult[Solution]]].serialize(run(args)))
}