package compendium

class MagicItem {

    String name
    String rarity

    String type
    String subtype
    boolean attunement

    String attuneNotes
    String notes
    String body

    String source

    static constraints = {
        name(unique: true)
        body(maxSize: 4096)
        subtype(nullable: true)
        attuneNotes(nullable: true)
        notes(nullable: true)
    }
}
