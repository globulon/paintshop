package fp

protected[fp] trait Preferences {
  final def preference(c: Colour) = Preference(List(c))

  final def preference(c: Colour, c2: Colour, cs: Colour*) = Preference(c::c2::cs.toList)
}