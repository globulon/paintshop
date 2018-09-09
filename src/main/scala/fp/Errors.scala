package fp

import scalaz.{-\/, \/, \/-}

import scala.util.Try

final case class ApplicationError(msg: String)

protected[fp] trait Errors {

  type SafeResult[A] = ApplicationError \/ A

  final def safe[A](a: ⇒ A): SafeResult[A] = Try(a) match {
    case scala.util.Success(value) ⇒ \/-(value)
    case scala.util.Failure(ex)    ⇒ -\/(ApplicationError(ex.getMessage))
  }

  final def fail[A](msg: String): SafeResult[A] = -\/(ApplicationError(msg))

}
