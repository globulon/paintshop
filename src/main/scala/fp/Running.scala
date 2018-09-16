package fp

import java.io.File

import scala.io.Source

protected[fp] trait Running extends Parsing {
  final protected def run(args: Array[String]): SafeResult[Solution] = for {
    name ← extractFile(args)
    _    ← checkFile(name)
    s    ← processFile(name)
  } yield s

  private def checkFile(name: String): SafeResult[String] =
    if (new File(name).exists()) safe(name) else fail(s"file $name not found")

  private def extractFile(args: Array[String]): SafeResult[String] = args.headOption match {
    case Some(name) ⇒ safe(name)
    case _          ⇒ fail[String]("""please specify a file location""")
  }

  private def stage: Stream[String] ⇒ Stream[Preference] =
    _.map(parse(preferences, _)).filter(_.successful).map(_.get).map(cs ⇒ Preference(cs.toSet))

  private def processFile(name: String): SafeResult[Solution] = fromFile(name) {
    case Stream.Empty ⇒ fail[Solution]("Empty file")
    case head #:: tail ⇒ process(head.toInt, stage(tail)) match {
      case None ⇒ fail[Solution]("No solution exists")
      case Some(s) ⇒ safe(s)
    }
  }

  private def fromFile[A](name: String)(f: Stream[String] ⇒ A ) = f(Source.fromFile(name).getLines().toStream)
}
