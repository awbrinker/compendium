package compendium

class Action {

    String name
    String type

    String range
    String hit
    String dc
    String savetype
    String damage
    String dmgtype
    String notes

    String body
    int charges
    


    static constraints = {
        body(maxSize: 1024)
        range(nullable: true)
        hit(nullable: true)
        dc(nullable: true)
        savetype(nullable: true)
        damage(nullable: true)
        dmgtype(nullable: true)
        name(unique: true)
    }
}
