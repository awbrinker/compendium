package compendium
import grails.util.Holders
import grails.gorm.transactions.*

class ContentController {

    def index() { 
        render(view: "index")
    }

    def sentinel(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        def NAME = "Sentinel"
        def RACECLASS = "Warforged Cleric 2"

        def XP = 300
        def NEXTXP = 900

        def STR = 13
        def DEX = 11
        def CON = 14
        def INT = 11
        def WIS = 15
        def CHA = 12

        def PROF = 2
        def SPEED = 30

        def INSP = false

        def HP = 17
        def MAXHP = 17
        def TEMPHP = 0
        def SUCCESSES = 0
        def FAILURES = 0

        def SAVES = [0, 0, 0, 0, 1, 1]
        def SAVENOTES = ["Adv. against being Poisoned"]

        def SENSES = ""

        def ARMOR = "Light Armor, Medium Armor, Heavy Armor, Shields"
        def WEAPONS = "Simple Weapons"
        def TOOLS = "Tinker's Tools"
        def LANGUAGES = "Common, Dwarvish, Elvish, Gnomish"

        def SKILLS = [0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0]

        def INITBONUS = 0
        def AC = 19

        def DEFENCES = "Poison resistance; Immunity to Disease and Magical Sleep"
        def CONDITIONS = "None"

        def ACTIONS = []

        def SPELLCASTER = true
        def SPELLSTAT = 4
        def MAXSPELLLEVEL = 1
        def SPELLS = [
            Spell.findByName('Healing Word'),
            Spell.findByName('Guiding Bolt')
        ]

        println(SPELLS[0].level)

        def INVENTORY = []

        def FEATURES = []

        def BACKGROUND = "Azorius Functionary"
        def BACKGROUNDFEATURENAME = "Legal Authority"
        def BACKGROUNDFEATUREBODY = "You have the authority to enforce the laws of Ravnica, and that status inspires a certain amount of respect and even fear in the populace. People mind their manners in your presence and avoid drawing your attention; they assume you have the right to be wherever you are. Showing your Azorius insignia gets you an audience with anyone you want to talk to (though it might cause more problems than it solves when you're dealing with incorrigible lawbreakers). If you abuse this privilege, though, you can get in serious trouble with your superiors and even be stripped of your position."

        def CHARACTERISTICS = [
            "Lawful Stupid",
            "--",
            "--",
            "Medium",
            "Tall",
            "Tyr",
            "--",
            "--",
            "--",
            "Heavy"
        ]

        render(view: "charsheet", model: [hook: springSecurityService.currentUser.defaultHook,
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
                                        actions: ACTIONS,
                                        spellcaster: SPELLCASTER,
                                        spellstat: SPELLSTAT,
                                        maxspelllevel: MAXSPELLLEVEL,
                                        spells: SPELLS,
                                        inventory: INVENTORY,
                                        features: FEATURES,
                                        background: BACKGROUND,
                                        backgroundfeaturename: BACKGROUNDFEATURENAME,
                                        backgroundfeaturebody: BACKGROUNDFEATUREBODY,
                                        characteristics: CHARACTERISTICS])
    }

    def rivaan(){
        render(view: "charsheet", model: [hook: springSecurityService.currentUser.defaultHook,
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
                                        maxspelllevel: MAXSPELLLEVEL,
                                        spells: SPELLS,
                                        inventory: INVENTORY,
                                        features: FEATURES,
                                        background: BACKGROUND,
                                        backgroundfeaturename: BACKGROUNDFEATURENAME,
                                        backgroundfeaturebody: BACKGROUNDFEATUREBODY,
                                        characteristics: CHARACTERISTICS])
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

        def SPELLCASTER = false

        def MAXSPELLLEVEL = 1
        def SPELLS = []

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

        def FEATURES = [
            new Feature(
                name: 'Sneak Attack',
                body: "Once per turn, you can deal an extra 1d6 damage to one creature you hit with an attack with a finesse or ranged weapon if you have advantage on the attack roll. You don't need advantage on the attack roll if another enemy of the target is within 5 ft. of it, that enemy isn't incapacitated, and you don't have disadvantage on the attack roll.",
                formula: "1d6",
                source: "Class",
                charges: 0,
                maxCharges: 0
            ),
            new Feature(
                name: "Thieves' Cant",
                body: "You have learned thieves’ cant, a secret mix of dialect, jargon, and code that allows you to hide messages in seemingly normal conversation. It takes four times longer to convey such a message than it does to speak the same idea plainly.",
                source: "Class",
                charges: 0,
                maxCharges: 0
            ),
            new Feature(
                name: "Cunning Action",
                body: "You can take a bonus action on each of your turns to take the Dash, Disengage, or Hide action.",
                source: "Class",
                charges: 0,
                maxCharges: 0
            ),
            new Feature(
                name: "Dual Mind",
                body: "You have advantage on all Wisdom saving throws.",
                source: "Race",
                charges: 0,
                maxCharges: 0
            ),
            new Feature(
                name: "Mental Discipline",
                body: "You have resistance to psychic damage.",
                source: "Race",
                charges: 0,
                maxCharges: 0
            ),
            new Feature(
                name: "Mind Link",
                body: "You can speak telepathically to any creature you can see within 20 ft. of you. You don't need to share a language with the creature for it to understand, but the creature must be able to understand at least one language.\n\nAs an action, when you’re speaking telepathically to a creature, you can give that creature the ability to speak telepathically with you for the next hour, or until you end this effect as an action.",
                source: "Race",
                charges: 0,
                maxCharges: 0
            ),
            new Feature(
                name: "Severed from Dreams",
                body: "You are immune to magical spells and effects that require you to dream, like the dream spell, but not to spells and effects that put you to sleep, like the sleep spell.",
                source: "Race",
                charges: 0,
                maxCharges: 0
            ),
            new Feature(
                name: "Alert",
                body: "You gain a +5 bonus to initiative rolls and can't be surprised.",
                source: "Feat",
                charges: 0,
                maxCharges: 0
            )
        ]

        def BACKGROUND = "Urchin"
        def BACKGROUNDFEATURENAME = "City Secrets"
        def BACKGROUNDFEATUREBODY = "You know the secret patterns and flow to cities and can find passages through the urban sprawl that others would miss. When you are not in combat, you (and companions you lead) can travel between any two locations in the city twice as fast as your speed would normally allow."

        def CHARACTERISTICS = [
            "Neutral",
            "Female",
            "Brown",
            "Medium",
            "Average",
            "None",
            "White",
            "Pale",
            "Young",
            "Average"
        ]

        render(view: "charsheet", model: [hook: springSecurityService.currentUser.defaultHook,
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
                                        maxspelllevel: MAXSPELLLEVEL,
                                        spells: SPELLS,
                                        inventory: INVENTORY,
                                        features: FEATURES,
                                        background: BACKGROUND,
                                        backgroundfeaturename: BACKGROUNDFEATURENAME,
                                        backgroundfeaturebody: BACKGROUNDFEATUREBODY,
                                        characteristics: CHARACTERISTICS])
    }

}
