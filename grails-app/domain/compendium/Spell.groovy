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
        String out = ""
        def list = formula.split(" &")
        int k = list.size()/4

        if(tier < 3){
            for(int i = 0; i < k; i++){
                out += list[i]
                out += " & "
            }
        }else if(tier < 6){
            for(int i = k; i < 2*k; i++){
                out += list[i]
                out += " & "
            }
        }else if(tier < 9){
            for(int i = 2*k; i < 3*k; i++){
                out += list[i]
                out += " & "
            }
        }else{
            for(int i = 3*k; i < 4*k; i++){
                out += list[i]
                out += " & "
            }
        }

        return out.substring(0, out.length()-3)
    }

    static constraints = {
        body(maxSize: 100000)
        name(unique: true)
        highText(nullable: true, maxSize: 1024)
        compText(nullable: true, maxSize: 1024)
        tags(nullable: true)
    }


}
