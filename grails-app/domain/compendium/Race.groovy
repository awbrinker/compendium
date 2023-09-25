package compendium

class Race {

    String name

    String quote
    String attribution

    String[] descriptionNames
    String[] descriptionTexts

    String[] traitNames
    String[] traitTexts

    static hasMany = [subraces: Subrace]

    static constraints = {
    }
}
