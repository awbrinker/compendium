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

    String saveShorthand(){
        return save.substring(0,3).toUpperCase()
    }

    String hitDC(bonus){
        if(atk == 'Ranged' || atk == 'Melee')
            return "+${bonus}"
        if(save != 'None')
            return "${8+(int)bonus} ${saveShorthand()}"
        return '--'
    }

    String cantripFormula(int tier){
        if(formula == 'None')
            return "--"

        String out = ""
        def list = formula.split(" &")
        int k = list.size()/4

        if(tier < 3){
            for(int i = 0; i < k; i++){
                if(list.size()%4 != 0)
                    i++
                out += list[i]
                out += " & "
            }
        }else if(tier < 6){
            for(int i = k; i < 2*k; i++){
                if(list.size()%4 != 0)
                    i++
                out += list[i]
                out += " & "
            }
        }else if(tier < 9){
            for(int i = 2*k; i < 3*k; i++){
                if(list.size()%4 != 0)
                    i++
                out += list[i]
                out += " & "
            }
        }else{
            for(int i = 3*k; i < 4*k; i++){
                if(list.size()%4 != 0)
                    i++
                out += list[i]
                out += " & "
            }
        }

        return out.substring(0, out.length()-3)
    }

    String charFormula(int tier, int bonus, int level){
        if(formula == 'None')
            return "--"

        def higher = ""
        if(level > this.level.toInteger()){
            int per = higherAddFormula.substring(0,1).toInteger()
            int die = higherAddFormula.substring(2).toInteger()
            higher += "& ${per * (level-this.level.toInteger())}d$die"
        }

        if(atk == 'Ranged' || atk == 'Melee'){
            if(this.level == '0'){
                return "d20${hitDC(bonus)} & ${cantripFormula(tier)}"
            }
            return "d20${hitDC(bonus)} & $formula $higher"
        }
        if(this.level == '0'){
            return "${cantripFormula(tier)}"
        }

        return "$formula $higher"
    }

    String charDisplayFormula(int tier, int bonus, int level){
        if(formula == 'None')
            return "--"

        def higher = ""
        int per = higherAddFormula.substring(0,1).toInteger()
        int die = higherAddFormula.substring(2).toInteger()
        higher += "& ${per * (level-this.level.toInteger())}d$die"

        return "$formula $higher"
    }

    static constraints = {
        body(maxSize: 100000)
        name(unique: true)
        highText(nullable: true, maxSize: 1024)
        compText(nullable: true, maxSize: 1024)
        tags(nullable: true)
    }


}
