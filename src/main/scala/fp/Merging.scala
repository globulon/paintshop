package fp

protected[fp] trait Merging {
  final def merge(valid: Validate): Palette ⇒ Preference ⇒ Palette = sols ⇒ pref ⇒
    (for {
      solution    ← sols
      preferences ← pref.colors.permutations
    } yield generate(solution, preferences)).flatten.filter(valid)

  private def generate(solution: Solution, preferences: List[Colour]): List[Solution] =
    preferences.map(extend(solution))
}