package compendium

class EquipmentLibrary {

    static void overload() {
        for(int i = 0; i < 400; i++){
            def arrows = new Equipment(
            name: "Arrows"+i,
            type: "Ammunition",
            cost: "0.05 gp",
            weight: "0.05 lbs",
            attributes: "",
            notes: "Combat, Damage",
            damage: "",
            body: "Arrows are used with a weapon that has the ammunition property to make a ranged attack. Each time you attack with the weapon, you expend one piece of ammunition. Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield."
        ).save(flush: true)
        }
    }

    static void initialize() {
        
        // Adventuring Gear
        def abacus = new Equipment(
            name: "Abacus",
            type: "Adventuring Gear",
            cost: "2 gp",
            weight: "2 lbs",
            attributes: "",
            notes: "Utility",
            damage: "",
            body: "A standard tool used to make calculations."
        ).save(flush: true)

        // Tool
        def alchemistSupplies = new Equipment(
            name: "Alchemist's Supplies",
            type: "Tool",
            cost: "50 gp",
            weight: "8 lbs",
            attributes: "",
            notes: "Utility",
            damage: "",
            body: "These special tools include the items needed to pursue a craft or trade. Proficiency with a set of artisan's tools lets you add your proficiency bonus to any ability checks you make using the tools in your craft. Each type of artisan's tools requires a separate proficiency."
        ).save(flush: true)

        // Gemstone
        def alexandrite = new Equipment(
            name: "Alexandrite",
            type: "Gemstone",
            cost: "500 gp",
            weight: "--",
            attributes: "",
            notes: "",
            damage: "",
            body: "A transparent dark green gemstone worth 500 gold pieces."
        ).save(flush: true)

        // Holy Symbol
        def amulet = new Equipment(
            name: "Amulet",
            type: "Holy Symbol",
            cost: "5 gp",
            weight: "1 lb",
            attributes: "",
            notes: "Utility",
            damage: "",
            body: "A holy symbol is a representation of a god or pantheon. A cleric or paladin can use a holy symbol as a spellcasting focus, as described in the Spellcasting section. To use the symbol in this way, the caster must hold it in hand, wear it visibly, or bear it on a shield."
        ).save(flush: true)

        // Weapon
        def battleaxe = new Equipment(
            name: "Battleaxe",
            type: "Martial Melee Weapon",
            cost: "10 gp",
            weight: "4 lbs",
            attributes: "Slashing",
            notes: "Combat, Damage",
            damage: "1d8 Slashing",
            body: "Proficiency with a battleaxe allows you to add your proficiency bonus to the attack roll for any attack you make with it."
        ).save(flush: true)

        // Ammunition
        def arrows = new Equipment(
            name: "Arrows",
            type: "Ammunition",
            cost: "0.05 gp",
            weight: "0.05 lbs",
            attributes: "",
            notes: "Combat, Damage",
            damage: "",
            body: "Arrows are used with a weapon that has the ammunition property to make a ranged attack. Each time you attack with the weapon, you expend one piece of ammunition. Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield."
        ).save(flush: true)
    }

}