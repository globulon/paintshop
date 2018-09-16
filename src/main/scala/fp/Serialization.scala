package fp

import scalaz.{-\/, \/-}

protected trait Serializer[A] {
  def serialize: A ⇒  String
}

protected[fp] trait Serialization {
  final def serialize[A: Serializer](a: A): String = implicitly[Serializer[A]].serialize(a)
}

protected[fp] trait Serializers {
  implicit def serializeSolution: Serializer[Solution] = new Serializer[Solution] {
    override def serialize: Solution ⇒ String = _.colors.toList.sorted.map(_.nuance).map(_.toString.head).mkString(" ")
  }

  implicit def serializeSafeResult[A : Serializer]: Serializer[SafeResult[A]] = new Serializer[SafeResult[A]] {
    override def serialize: fp.SafeResult[A] ⇒ String = {
      case \/-(a)                     ⇒ implicitly[Serializer[A]].serialize(a)
      case -\/(ApplicationError(msg)) ⇒ msg
    }
  }
}