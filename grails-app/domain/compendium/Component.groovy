package compendium

class Component {

    String name

    String[] attributes
    String[] formulas

    static constraints = {
        name(unique: true)
        attributes(maxSize: 2048000)
    }

    static mapping = {
        attributes(column: "attributes", sqlType: "varbinary(2000)")
    }
}
