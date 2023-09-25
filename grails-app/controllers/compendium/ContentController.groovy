package compendium
import grails.util.Holders
import grails.gorm.transactions.*

class ContentController {

    def index() { 
        render(view: "index")
    }

    def sentinel(){
        render(view: "sentinel")
    }

    def rivaan(){
        render(view: "rivaan")
    }

    def valakhad(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        def NAME = "Valakhad"
        def RACECLASS = "Kalashtar Rogue 2"

        def XP = 300
        def NEXTXP = 900

        def STR = 11
        def DEX = 18
        def CON = 17
        def INT = 13
        def WIS = 14
        def CHA = 14

        def PROF = 2
        def SPEED = 30

        def INSP = false

        def HP = 19
        def MAXHP = 19
        def TEMPHP = 0
        def SUCCESSES = 0
        def FAILURES = 0

        def SAVES = [0, 1, 0, 1, 0, 0]
        def SAVENOTES = ["Adv. on Wis"]

        def SENSES = ""

        def ARMOR = "Light Armor"
        def WEAPONS = "Hand Crossbow, Longsword, Rapier, Shortsword, Simple Weapons"
        def TOOLS = "Disguise Kit, Thieves' Tools*, Tinker's Tools"
        def LANGUAGES = "Common, Elvish, Quori, Thieves' Cant"

        def SKILLS = [1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 2, 0]

        def INITBONUS = 0
        def AC = 15

        def DEFENCES = "Psychic resistance"
        def CONDITIONS = "None"

        def SPELLCASTER = false

        def ACTIONS = [
            new Action(
                name: "Dagger",
                type: "Attack",
                range: "20 (60)",
                hit: "6",
                damage: "1d4+4",
                dmgtype: "Piercing",
                notes: "Simple, Finesse, Light, Thrown, Range (20/60)"
            ),
            new Action(
                name: "Dagger (Sneak Attack)",
                type: "Attack",
                range: "20 (60)",
                hit: "6",
                damage: "1d4+1d6+4",
                dmgtype: "Piercing",
                notes: "Simple, Finesse, Light, Thrown, Range (20/60)"
            ),
            new Action(
                name: "Dagger (Off Hand)",
                type: "Attack",
                range: "20 (60)",
                hit: "6",
                damage: "1d4",
                dmgtype: "Piercing",
                notes: "Simple, Finesse, Light, Thrown, Range (20/60)"
            ),
            new Action(
                name: "Mind Link Response",
                type: "Action",
                body: "When you’re using Mind Link to speak telepathically to a creature, you can use your action to give that creature the ability to speak telepathically with you for 1 hour or until you end this effect as an action. To use this ability, the creature must be able to see you and must be within 20 ft.\n\nYou can give this ability to only one creature at a time; giving it to a creature takes it away from another creature who has it."    
            ),
            new Action(
                name: "Cunning Action",
                type: "Bonus Action",
                body: "You can take a bonus action on each of your turns to take the Dash, Disengage, or Hide action."
            )
        ]

        def INVENTORY = [
            new InventoryItem(
                name: 'Dagger',
                active: true,
                weight: '1 lb.',
                qty: 2,
                cost: '2',
                notes: 'Simple, Finesse, Light, Thrown, Range (20/60)',
                body: 'Finesse, Light, Thrown (20/60)\n1d4 Piercing\nProficiency with a dagger allows you to add your proficiency bonus to the attack roll for any attack you make with it.',
                attunable: false,
                attuned: false,
            ),
            new InventoryItem(
                name: 'Clothes, Common',
                active: true,
                weight: '3 lb.',
                qty: 1,
                cost: '0.5',
                notes: 'Social, Outerwear',
                body: 'This set of clothes could consist of a loose shirt and baggy breeches, or a loose shirt and skirt or overdress. Cloth wrappings are used for shoes.',
                attunable: false,
                attuned: false,
            ),
            new InventoryItem(
                name: 'Arrows',
                active: true,
                weight: '1 lb.',
                qty: 20,
                cost: '1',
                notes: 'Damage, Combat',
                body: 'Arrows are used with a weapon that has the ammunition property to make a ranged attack. Each time you attack with the weapon, you expend one piece of ammunition. Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield.',
                attunable: false,
                attuned: false,
            ),
            new InventoryItem(
                name: 'Leather Armor',
                active: true,
                weight: '10 lb.',
                qty: 1,
                cost: '10',
                notes: 'AC 11',
                body: 'The breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.',
                attunable: false,
                attuned: false,
            ),
            new InventoryItem(
                name: 'Rapier',
                active: false,
                weight: '2 lb.',
                qty: 1,
                cost: '25',
                notes: 'Martial, Finesse',
                body: 'Finesse\n1d8 Piercing\nProficiency with a rapier allows you to add your proficiency bonus to the attack roll for any attack you make with it.',
                attunable: false,
                attuned: false,
            ),
            new InventoryItem(
                name: 'Shortbow',
                active: true,
                weight: '2 lb.',
                qty: 1,
                cost: '25',
                notes: 'Simple, Ammunition, Range (80/320), Two-Handed',
                body: 'Ammunition, Range (80/320), Two-Handed\n1d6 Piercing\nProficiency with a shortbow allows you to add your proficiency bonus to the attack roll for any attack you make with it.',
                attunable: false,
                attuned: false,
            ),
            new InventoryItem(
                name: 'Thieves\' Tools',
                active: false,
                weight: '21 lb.',
                qty: 1,
                cost: '25',
                notes: 'Utility, Exploration',
                body: 'This set of tools includes a small file, a set of lock picks, a small mirror mounted on a metal handle, a set of narrow-bladed scissors, and a pair of pliers. Proficiency with these tools lets you add your proficiency bonus to any ability checks you make to disarm traps or open locks.',
                attunable: false,
                attuned: false,
            ),
        ]

        render(view: "valakhad", model: [hook: springSecurityService.currentUser.defaultHook,
                                        name: NAME,
                                        xp: XP,
                                        nextxp: NEXTXP,
                                        raceclass: RACECLASS,
                                        stats: [STR, DEX, CON, INT, WIS, CHA], 
                                        prof: PROF, 
                                        speed: SPEED,
                                        insp: INSP,
                                        hp: HP,
                                        maxhp: MAXHP,
                                        temphp: TEMPHP,
                                        successes: SUCCESSES,
                                        failures: FAILURES,
                                        saves: SAVES,
                                        savenotes: SAVENOTES,
                                        senses: SENSES,
                                        armor: ARMOR,
                                        weapons: WEAPONS,
                                        tools: TOOLS,
                                        languages: LANGUAGES,
                                        skills: SKILLS,
                                        initbonus: INITBONUS,
                                        ac: AC,
                                        defences: DEFENCES,
                                        conditions: CONDITIONS,
                                        spellcaster: SPELLCASTER,
                                        actions: ACTIONS,
                                        inventory: INVENTORY])
    }

}
