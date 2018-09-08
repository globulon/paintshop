package fp

protected[fp] trait Preferences {
  final def preference(c: Colour) = Preference(List(c))
}