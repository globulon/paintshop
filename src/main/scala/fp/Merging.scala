package fp

protected[fp] trait Merging {
  final def merge(valid: Validate): Palette ⇒ Preference ⇒ Palette = sols ⇒ pref ⇒
    (for {
      solution ← sols
      color ← pref.colors
    } yield extend(solution)(color)).filter(valid).distinct
}