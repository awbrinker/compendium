package compendium

import groovy.json.JsonSlurper

class CharacterLibrary {

    static Action[] buildActions(list) {
        def actions = []

        for(a in list){
            Action action = new Action(
                name: a.name,
                type: a.type,
                range: a.range,
                hit: a.hit,
                dc: a.dc,
                savetype: a.savetype,
                damage: a.damage,
                dmgtype: a.dmgtype,
                notes: a.notes,
                body: a.body ?: "",
                charges: a.charges ?: 0,
                maxCharges: a.maxCharges ?: 0,
                shortRest: a.shortRest ?: false
            ).save(flush: true)

            if(!action)
                println a.name

            actions.add(action)
        }

        return actions
    }

    static Feature[] buildFeatures(list) {
        def features = []

        for(f in list){
            Feature feature = new Feature(
                name: f.name,
                body: f.body,
                formula: f.formula,
                source: f.source,
                charges: f.charges ?: 0,
                maxCharges: f.maxCharges ?: 0,
                shortRest: f.shortRest ?: false
            ).save(flush: true)

            if(!feature)
                println f.name

            features.add(feature)
        }

        return features
    }

    static Spell[] buildSpells(list) {
        def spells = []

        for (s in list){
            spells.add(Spell.findByName(s))
        }

        return spells
    }

    static InventoryItem[] buildInventory(list) {
        def inventory = []

        for (i in list){
            InventoryItem item = new InventoryItem(
                name: i.name,
                active: i.active,
                weight: i.weight,
                qty: i.qty,
                cost: i.cost,
                notes: i.notes,
                body: i.body,
                attunable: i.attunable,
                attuned: i.attuned
            ).save(flush: true)

            if(!item)
                println i.name

            inventory.add(item)
        }

        return inventory
    }

    static void buildChar(filename){
        def jsonSlurper = new JsonSlurper()

        def character = jsonSlurper.parse(new File("data/characters/${filename}"))

        def initChar = new Character(
            hook: character.hook,
            name: character.name,
            raceclass: character.raceclass,
            xp: character.xp,
            nextxp: character.nextxp,
            STR: character.STR,
            DEX: character.DEX,
            CON: character.CON,
            INT: character.INT,
            WIS: character.WIS,
            CHA: character.CHA,
            prof: character.prof,
            speed: character.speed,
            insp: character.insp,
            hp: character.hp,
            maxhp: character.maxhp,
            maxhpchange: 0,
            temphp: character.temphp,
            successes: character.successes,
            failures: character.failures,
            hitDice: character.hitDice,
            hitDiceCount: character.hitDiceCount,
            maxHitDice: character.maxHitDice,
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
            actions: buildActions(character.actions),
            spellcaster: character.spellcaster,
            spellstat: character.spellstat ?: 0,
            maxspelllevel: character.maxspelllevel ?: 0,
            spellslots: character.spellslots,
            maxspellslots: character.maxspellslots,
            spells: buildSpells(character.spells),
            inventory: buildInventory(character.inventory),
            features: buildFeatures(character.features),
            background: character.background,
            backgroundfeaturename: character.backgroundfeaturename,
            backgroundfeaturebody: character.backgroundfeaturebody,
            characteristics: character.characteristics
        ).save(flush: true)

        if(!initChar)
            println filename
    }

    static void initialize() {
        buildChar("valakhad.json")
        buildChar("sentinel.json")
        buildChar("rivaan.json")
    }

}