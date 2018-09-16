package fp

protected[fp] trait Preferences {
  final def preference() = Preference(Set.empty)

  final def preference(cs: Set[Colour]) = Preference(cs)

  final def preference(c: Colour) = Preference(Set(c))

  final def preference(c: Colour, c2: Colour, cs: Colour*) = Preference(Set(c,c2) .union(cs.toSet))

  implicit class RichPreference(p: Preference) {
    def invert: Preference = Preference(p.colors.map(_.invert))
  }
}