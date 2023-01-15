package compendium

class Equipment {

    String name
    String type
    String cost
    String weight
    String attributes
    String notes

    String damage

    String body
    String source = "Basic Rules"

    static constraints = {
        body(maxSize: 1024)
        attributes(nullable: true)
        notes(nullable: true)
        damage(nullable: true)
        name(unique: true)
    }
}
