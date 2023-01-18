package compendium

class Spell {

    String name
    String level
    String castingTime
    String range
    String[] components
    String duration
    String school
    String atk
    String save
    String[] dmgType
    String[] tags
    boolean concentration
    
    String formula
    String higherAddFormula

    String body
    String highText
    String compText

    String source

    String[] classes

    static constraints = {
        body(maxSize: 1024)
        name(unique: true)
        highText(nullable: true)
        compText(nullable: true)
        tags(nullable: true)
    }
}
