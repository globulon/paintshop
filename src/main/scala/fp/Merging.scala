package fp

protected[fp] trait Merging {
  final protected def merge(valid: Validate): List[Solution] ⇒ Preference ⇒ List[Solution] = sols ⇒ pref ⇒
    (for {
      solution    ← sols
      preferences ← pref.colors.permutations
    } yield generate(solution, preferences)).flatten.filter(valid)

  private def generate(solution: Solution, preferences: List[Colour]): List[Solution] =
    preferences.map(extend(solution))
}