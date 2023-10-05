package compendium

import java.io.Serializable

class Action implements Serializable{

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
    int maxCharges
    boolean shortRest

    static constraints = {
        body(maxSize: 1024, nullable: true)
        range(nullable: true)
        hit(nullable: true)
        dc(nullable: true)
        savetype(nullable: true)
        damage(nullable: true)
        dmgtype(nullable: true)
        notes(nullable: true)
        shortRest(nullable: true)
    }
}
