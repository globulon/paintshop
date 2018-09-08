package fp

trait Serialization {
  final def serialize: Solution ⇒ String =
    _.sorted.colors.map(_.nuance).map(_.toString.head).mkString(" ")
}
