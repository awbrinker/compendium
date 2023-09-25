package compendium

class InventoryItem {

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
        name(unique: true)
    }

}
