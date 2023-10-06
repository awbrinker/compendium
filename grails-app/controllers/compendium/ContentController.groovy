package compendium
import grails.util.Holders
import grails.gorm.transactions.*

class ContentController {

    def index() { 
        render(view: "index")
    }

    @Transactional
    def update() {
        def character = Character.findByName(params.name)

        character.insp = params.inspValue.toBoolean()
        character.hp = params.hp.toInteger()
        character.maxhpchange = params.maxhp.toInteger() - character.maxhp.toInteger()
        character.temphp = params.temphp.toInteger()

        for(a in character.actions){
            if(a.maxCharges != 0){
                a.charges = params["${a.name}charges"].toInteger()
            }
            a.save(flush:true)
        }

        def slots = [0]
        for(int i = 1; i < 10; i++){
            slots.add(i <= character.maxspelllevel ? params["slots$i"].toInteger() : 0)
        }
        character.spellslots = slots

        for(f in character.features){
            if(f.maxCharges != 0){
                f.charges = params["${f.name}charges"].toInteger()
            }
            f.save(flush:true)
        }

        character.save(flush: true)

        redirect(action: params.name.toLowerCase())
    }

    def sentinel(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        def character = Character.findByName("Sentinel")

        render(view: "charsheet", model: [hook: springSecurityService.currentUser.defaultHook,
                                        name: character.name,
                                        xp: character.xp,
                                        nextxp: character.nextxp,
                                        raceclass: character.raceclass,
                                        stats: [character.STR, 
                                                character.DEX, 
                                                character.CON, 
                                                character.INT, 
                                                character.WIS, 
                                                character.CHA], 
                                        prof: character.prof,
                                        speed: character.speed,
                                        insp: character.insp,
                                        hp: character.hp,
                                        maxhp: character.maxhp + character.maxhpchange,
                                        temphp: character.temphp,
                                        successes: character.successes,
                                        failures: character.failures,
                                        saves: character.saves,
                                        savenotes: character.savenotes,
                                        senses: character.senses,
                                        armorProfs: character.armorProfs,
                                        weaponProfs: character.weaponProfs,
                                        toolProfs: character.toolProfs,
                                        languages: character.languages,
                                        skills: character.skills,
                                        initbonus: character.initbonus,
                                        ac: character.ac,
                                        defences: character.defences,
                                        conditions: character.conditions,
                                        actions: character.actions,
                                        spellcaster: character.spellcaster,
                                        spellstat: character.spellstat ?: 0,
                                        maxspelllevel: character.maxspelllevel ?: 0,
                                        spellslots: character.spellslots,
                                        maxspellslots: character.maxspellslots,
                                        spells: character.spells,
                                        inventory: character.inventory,
                                        features: character.features,
                                        background: character.background,
                                        backgroundfeaturename: character.backgroundfeaturename,
                                        backgroundfeaturebody: character.backgroundfeaturebody,
                                        characteristics: character.characteristics])
    }

    def rivaan(){
        render(view: "charsheet", model: [hook: springSecurityService.currentUser.defaultHook,
                                        name: character.name,
                                        xp: character.xp,
                                        nextxp: character.nextxp,
                                        raceclass: character.raceclass,
                                        stats: [character.STR, 
                                                character.DEX, 
                                                character.CON, 
                                                character.INT, 
                                                character.WIS, 
                                                character.CHA], 
                                        prof: character.prof,
                                        speed: character.speed,
                                        insp: character.insp,
                                        hp: character.hp,
                                        maxhp: character.maxhp + character.maxhpchange,
                                        temphp: character.temphp,
                                        successes: character.successes,
                                        failures: character.failures,
                                        saves: character.saves,
                                        savenotes: character.savenotes,
                                        senses: character.senses,
                                        armorProfs: character.armorProfs,
                                        weaponProfs: character.weaponProfs,
                                        toolProfs: character.toolProfs,
                                        languages: character.languages,
                                        skills: character.skills,
                                        initbonus: character.initbonus,
                                        ac: character.ac,
                                        defences: character.defences,
                                        conditions: character.conditions,
                                        actions: character.actions,
                                        spellcaster: character.spellcaster,
                                        spellstat: character.spellstat ?: 0,
                                        maxspelllevel: character.maxspelllevel ?: 0,
                                        spellslots: character.spellslots,
                                        maxspellslots: character.maxspellslots,
                                        spells: character.spells,
                                        inventory: character.inventory,
                                        features: character.features,
                                        background: character.background,
                                        backgroundfeaturename: character.backgroundfeaturename,
                                        backgroundfeaturebody: character.backgroundfeaturebody,
                                        characteristics: character.characteristics])
    }

    def valakhad(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        def character = Character.findByName("Valakhad")

        render(view: "charsheet", model: [hook: springSecurityService.currentUser.defaultHook,
                                        name: character.name,
                                        xp: character.xp,
                                        nextxp: character.nextxp,
                                        raceclass: character.raceclass,
                                        stats: [character.STR, 
                                                character.DEX, 
                                                character.CON, 
                                                character.INT, 
                                                character.WIS, 
                                                character.CHA], 
                                        prof: character.prof,
                                        speed: character.speed,
                                        insp: character.insp,
                                        hp: character.hp,
                                        maxhp: character.maxhp,
                                        temphp: character.temphp,
                                        successes: character.successes,
                                        failures: character.failures,
                                        saves: character.saves,
                                        savenotes: character.savenotes,
                                        senses: character.senses,
                                        armorProfs: character.armorProfs,
                                        weaponProfs: character.weaponProfs,
                                        toolProfs: character.toolProfs,
                                        languages: character.languages,
                                        skills: character.skills,
                                        initbonus: character.initbonus,
                                        ac: character.ac,
                                        defences: character.defences,
                                        conditions: character.conditions,
                                        actions: character.actions,
                                        spellcaster: character.spellcaster,
                                        spellstat: character.spellstat ?: 0,
                                        maxspelllevel: character.maxspelllevel ?: 0,
                                        spellslots: character.spellslots,
                                        maxspellslots: character.maxspellslots,
                                        spells: character.spells,
                                        inventory: character.inventory,
                                        features: character.features,
                                        background: character.background,
                                        backgroundfeaturename: character.backgroundfeaturename,
                                        backgroundfeaturebody: character.backgroundfeaturebody,
                                        characteristics: character.characteristics])
    }

}
