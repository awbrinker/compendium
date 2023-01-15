package compendium

class Background {

    String name
    String featureName
    String featureText

    String tags

    String skills
    String languages
    String tools
    String equipment

    String body
    String characteristics

    String source

    static constraints = {
        body(maxSize: 1024)
        featureText(maxSize: 1024)
        characteristics(maxSize: 1024)
        tools(nullable: true)
        name(unique: true)
    }
}
