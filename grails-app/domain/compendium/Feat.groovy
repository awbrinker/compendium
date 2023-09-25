package compendium

class Feat {

    String name
    String notes
    String tags
    String prereq
    String source

    String body

    static constraints = {
        body(maxSize: 2048)
        tags(nullable: true)
        prereq(nullable: true)
        name(unique: true)
    }
}
