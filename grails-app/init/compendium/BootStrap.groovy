package compendium
import grails.gorm.transactions.*

class BootStrap {

    @Transactional
    void initialize(){

        // Users
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testAdmin = new User(username: 'admin', password: 'password', defaultHook: 'https://discordapp.com/api/webhooks/1063212486121234443/WnujW9t76JO5ogf-RUbhrjHlVerXMmsHYfJ2VD-R0rACP9DOOsYmemSqwp1TbdPJy2bW')
        testAdmin.save(flush: true)

        def testUser = new User(username: 'user', password: 'password')
        testUser.save(flush: true)

        UserRole.create testAdmin, adminRole, true
        UserRole.create testUser, userRole, true
        UserRole.withSession {
            it.flush()
            it.clear()
        }

        // Spells

        def iceKnife = new Spell(
            name: "Ice Knife",
            level: "1st",
            castingTime: "1 Action",
            range: "60 ft",
            components: ["S", "M"],
            duration: "Instantaneous",
            school: "Conjuration",
            atk: "Ranged",
            save: "DEX",
            dmgType: ["Piercing", "Cold"],
            concentration: false,
            
            formula: "d10 & 2d6",
            higherAddFormula: "d6",

            body: "You create a shard of ice and fling it at one creature within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 piercing damage. Hit or miss, the shard then explodes. The target and each creature within 5 feet of it must succeed on a Dexterity saving throw or take 2d6 cold damage.",
            highText: "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the cold damage increases by 1d6 for each slot level above 1st.",
            compText: "* - (a drop of water or a piece of ice)",
            source: "Elemental Evil Player's Companion",

            classes: ["Bard", "Sorcerer", "Warlock", "Wizard", "Artificer"]
        ).save(flush: true)

        def mageHand = new Spell(
            name: "Mage Hand",
            level: "0th",
            castingTime: "1 Action",
            range: "30 ft",
            components: ["V", "S"],
            duration: "1 Minute",
            school: "Conjuration",
            atk: "None",
            save: "None",
            dmgType: ["Utility"],
            concentration: false,
            
            formula: "None",
            higherAddFormula: "None",

            body: "A spectral, floating hand appears at a point you choose within range. The hand lasts for the duration or until you dismiss it as an action. The hand vanishes if it is ever more than 30 feet away from you or if you cast this spell again.  You can use your action to control the hand. You can use the hand to manipulate an object, open an unlocked door or container, stow or retrieve an item from an open container, or pour the contents out of a vial. You can move the hand up to 30 feet each time you use it.  The hand can't attack, activate magic items, or carry more than 10 pounds.",
            highText: " ",
            compText: " ",
            source: "Basic Rules",

            classes: ["Druid", "Sorcerer", "Wizard"]
        ).save(flush: true)
    }

    def init = { servletContext ->
        initialize()
    }
    def destroy = {
    }
}
