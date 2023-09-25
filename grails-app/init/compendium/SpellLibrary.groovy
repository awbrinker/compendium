package compendium

import groovy.json.JsonSlurper

class SpellLibrary {

    static String stripBrackets(string){
        if(string){
            return string.substring(1, string.length()-1)
        }
        return ""
    }

    static String grabCastingTime(time){

        if (stripBrackets(time.unit.toString()) == "bonus"){
            return "1 bonus action"
        }

        return stripBrackets(time.number.toString()) + " " + stripBrackets(time.unit.toString())
    }

    static String grabDuration(duration){

        if(duration.get(0).type == "permanent"){
            return "Until Dispelled"
        }

        if(duration.get(0).type == "special"){
            return "Special"
        }

        if(duration.get(0).type == "instant") {
            return "Instantaneous"
        }

        return stripBrackets(duration.duration.amount.toString()) + " " + stripBrackets(duration.duration.type.toString())
    }

    static String grabRange(range){

        if(!range){
            return "None?"
        }

        if(range.type == "cone"){
            return "Self ($range.distance.amount ft cone)"
        }

        if(!range.distance){
            return "No distance?"
        }

        if (range.distance.type == "sight" && !range.distance.amount){
            return "Sight"
        }

        if (range.distance.type == "self"){
            return "Self"
        }

        if(range.distance.type == "touch"){
            return "Touch"
        }

        return "$range.distance.amount ft"
    }

    static String[] grabComponents(components){
        
        def comps = []

        if(components.v){
            comps.add("V")
        }
        if(components.s){
            comps.add("S")
        }
        if(components.m){
            comps.add("M")
        }

        return comps as String[]
    }

    static String grabSchool(school){
        if(school == "A"){
            return "Abjuration"
        }
        if(school == "C"){
            return "Conjuration"
        }
        if(school == "D"){
            return "Divination"
        }
        if(school == "E"){
            return "Enchantment"
        }
        if(school == "V"){
            return "Evocation"
        }
        if(school == "I"){
            return "Illusion"
        }
        if(school == "N"){
            return "Necromancy"
        }
        if(school == "T"){
            return "Transmutation"
        }
        return "..Other?"
    }

    static String grabAtk(atk){
        if(!atk){
            return "None"
        }
        if(atk == "M"){
            return "Melee"
        }
        return "Ranged"
    }

    static String listToString(list) {

        if(!list){
            return "None"
        }

        return list.toString().substring(1, list.toString().length()-1)
    }

    static String generateBody(list) {

        if(!list){
            return "None"
        }

        def out = " "

        for(int i = 0; i < list.size(); i++){
            if(!list.get(i)){
                out += " "
            } else if(list.get(i) instanceof String){
                out += list.get(i)
            } else if(list.get(i).type == "table"){
                out += "Figure this shit out later"
            } else if(list.get(i).type == "list"){
                out += "Figure this shit out later"
            } else if(list.get(i).type == "entries"){
                out += generateBody(list.get(i))
            } else {
                out += list.get(i)
            }

            out += """
            """
        }

        return out
    }

    static String grabHighText(higher){
        if(!higher){
            return ""
        }

        return "At Higher Levels. " + higher.entries.get(0).toString().substring(1, higher.entries.get(0).toString().length()-1)
    }

    static String grabCompText(m){
        if(!m){
            return ""
        }

        if(m instanceof String){
            return  "* - ($m)"
        }

        return "* - ($m.text)"
    }

    static boolean grabConcentration(conc){
        if(conc.toString() == "true")
            return true
        
        return false
    }

    static void initialize() {
        String[] library = ["spells-egw.json",
                            "spells-ftd.json",
                            "spells-ggr.json",
                            "spells-phb.json",
                            "spells-scc.json",
                            "spells-tce.json",
                            "spells-xge.json"]

        def jsonSlurper = new JsonSlurper()

        for(int s = 0; s < library.length; s++) {

            def contents = jsonSlurper.parse(new File("data/spells/" + library[s]))

            for(int i = 0; i < contents.spell.size(); i++){
                def spell = contents.spell.get(i)

                def initSpell = new Spell(
                    name: spell.name,
                    level: spell.level,
                    castingTime: grabCastingTime(spell.time),
                    range: grabRange(spell.range),
                    components: grabComponents(spell.components),
                    duration: grabDuration(spell.duration),
                    school: grabSchool(spell.school),
                    atk: grabAtk(spell.spellAttack),
                    save: listToString(spell.savingThrow),
                    dmgType: spell.damageInflict ?: ["Other"],
                    tags: spell.miscTags,
                    concentration: grabConcentration(spell.duration.concentration),
                    formula: "None",
                    higherAddFormula: "None",
                    body: generateBody(spell.entries),
                    highText: grabHighText(spell.entriesHigherLevel),
                    compText: grabCompText(spell.components.m),
                    source: spell.source,
                    classes: ["Bard"]
                ).save(flush:true)

                if(!initSpell)
                    println spell.name
            }
        }

    }

}