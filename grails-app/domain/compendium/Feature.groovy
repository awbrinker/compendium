package compendium

import java.io.Serializable

class Feature implements Serializable{

    String name
    String body
    String formula
    String source
    int charges
    int maxCharges
    boolean shortRest

    static constraints = {
        body(maxSize: 1024)
        formula(nullable: true)
        name(unique: true)
        shortRest(nullable: true)
    }

}