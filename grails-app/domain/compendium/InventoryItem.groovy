package compendium

import java.io.Serializable

class InventoryItem implements Serializable{

    String name
    boolean active
    String weight
    int qty
    String cost
    String notes
    String body
    boolean attunable
    boolean attuned

    static constraints = {
        body(maxSize: 1024)
        notes(nullable: true)
    }

}
