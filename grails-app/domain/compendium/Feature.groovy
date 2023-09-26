package compendium

class Feature {

    String name
    String body
    String formula
    String source
    int charges
    int maxCharges

    static constraints = {
        body(maxSize: 1024)
        formula(nullable: true)
        name(unique: true)
    }

}