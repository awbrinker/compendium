package compendium

class Spell {

    String name
    String level
    String castingTime
    String range
    String[] components
    String duration
    String school
    String atk
    String save
    String[] dmgType
    String[] tags
    boolean concentration
    
    String formula
    String higherAddFormula

    String body
    String highText
    String compText

    String source

    String[] classes

    String castingTimeShorthand(){
        if(castingTime == '1 action'){
            return '1A'
        }
        if(castingTime == '1 bonus action'){
            return '1BA'
        }
        if(castingTime == '1 reaction'){
            return '1R'
        }
        return castingTime
    }

    String hitDC(bonus){
        if(atk == 'Ranged' || atk == 'Melee')
            return "+${bonus}"
        if(save != 'None')
            return "${8+parseInt(bonus)}"
        return '--'
    }

    static constraints = {
        body(maxSize: 100000)
        name(unique: true)
        highText(nullable: true, maxSize: 1024)
        compText(nullable: true, maxSize: 1024)
        tags(nullable: true)
    }


}
