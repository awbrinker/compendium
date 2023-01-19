package compendium

class Vehicle {

    String name
    String size
    String sizetext
    String crew
    String cargo
    String pace

    int[] stats

    String[] actions
    String[] actionFormulas

    String[][] components
    String[][] compFormulas

    static constraints = {
        name(unique: true)
        actions(maxSize: 2048000)
        components(maxSize: 2048000)
    }

    static mapping = {
        actions(column: "actions", sqlType: "varbinary(2000)")
        components(column: "components", sqlType: "varbinary(2000)")
        compFormulas(column: "compFormulas", sqlType: "varbinary(2000)")
    }
}
