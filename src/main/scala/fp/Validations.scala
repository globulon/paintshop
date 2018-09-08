package fp

protected[fp] trait Validations {
  type Validate = Solution ⇒ Boolean

  final def checkNuance: Validate = !_.colors.groupBy(_.idx).exists(_._2.size > 1)
}