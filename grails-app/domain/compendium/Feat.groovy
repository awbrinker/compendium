package compendium

class Feat {

    String name
    String notes
    String tags
    String prereq
    String source

    String body

    static constraints = {
        body(maxSize: 1024)
        prereq(nullable: true)
        name(unique: true)
    }
}
