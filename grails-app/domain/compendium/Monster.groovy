package compendium

class Monster {

    String name
    String size
    String type
    String subtype
    String alignment

    String environment
    String tags

    int ac
    String actext

    int hp
    String hpformula
    String speed

    int[] stats
    int[] saves

    String[] skills
    int[] skillBonus

    String[] resistances
    String[] immunities
    String[] vulnerabilities
    String[] conditionImmunities

    String senses
    String languages

    String cr
    int prof

    String[] attributes
    String[] attributeFormulas
    String[] actions
    String[] actionFormulas
    String[] bonusActions
    String[] bonusActionFormulas
    String[] reactions
    String[] reactionFormulas
    String[] legendaryActions
    String[] legendaryActionFormulas

    String source

    static constraints = {
        name(unique: true)
        subtype(nullable: true)
        environment(nullable: true)
        tags(nullable: true)
        actext(nullable: true)
        saves(nullable: true)
        skills(nullable: true)
        skillBonus(nullable: true)
        resistances(nullable: true)
        immunities(nullable: true)
        vulnerabilities(nullable: true)
        conditionImmunities(nullable: true)
        attributes(nullable: true, maxSize: 2048000)
        attributeFormulas(nullable: true, maxSize: 2048000)
        actions(maxSize: 2048000)
        bonusActions(nullable: true, maxSize: 2048000)
        bonusActionFormulas(nullable: true, maxSize: 2048000)
        reactions(nullable: true, maxSize: 2048000)
        reactionFormulas(nullable: true, maxSize: 2048000)
        legendaryActions(nullable: true, maxSize: 2048000)
        legendaryActionFormulas(nullable: true)
    }

    static mapping = {
        actions(column: "actions", sqlType: "varbinary(2000)")
        bonusActions(column: "bonusActions", sqlType: "varbinary(2000)")
        reactions(column: "reactions", sqlType: "varbinary(2000)")
        attributes(column: "attributes", sqlType: "varbinary(2000)")
        legendaryActions(column: "legendaryActions", sqlType: "varbinary(2000)")
    }
}
