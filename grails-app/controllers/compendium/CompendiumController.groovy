package compendium
import grails.util.Holders

class CompendiumController {

    def index() { 
        render(view: "index")
    }

    def classes() { 
        render(view: "classes")
    }

    def races() { 
        render(view: "races")
    }

    def spells(){
        def springSecurityService = Holders.applicationContext.springSecurityService
        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        end = Math.min(end, Spell.count())

        render(view: "spells", model: [spells: Spell.listOrderByName(), count: Spell.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def equipment(){
        def springSecurityService = Holders.applicationContext.springSecurityService
        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        end = Math.min(end, Equipment.count())

        render(view: "equipment", model: [items: Equipment.listOrderByName(), count: Equipment.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def feats(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "feats", model: [feats: Feat.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    def backgrounds(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "backgrounds", model: [backgrounds: Background.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    // Magic Items

    def magicitems(){
        def springSecurityService = Holders.applicationContext.springSecurityService
        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        end = Math.min(end, MagicItem.count())

        render(view: "magicitems", model: [magicitems: MagicItem.listOrderByName(), count: MagicItem.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    // Monsters

    int crIndex(String cr){
        def list = new ArrayList<String>()
        list.add("0")
        list.add("1/8")
        list.add("1/4")
        list.add("1/2")
        for(int i = 0; i<31; i++){
            list.add(""+i)
        }
        return list.indexOf(cr)
    }

    def monsters(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByName().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def worse(cur, next){
        if(!cur) {
            return cur;
        }
        else return next;
    }

    def filterMonsters(){
       def springSecurityService = Holders.applicationContext.springSecurityService

        def monsters = new ArrayList<Monster>()

        println params.crEnd

        for(Monster it: Monster.getAll()){
            boolean flag = true;
            flag = it.name.toLowerCase().contains(params.nameFilter.toLowerCase())
            flag = worse(flag, it.type.toLowerCase().contains(params.typeFilter.toLowerCase()) || (it.subtype != null && it.subtype.toLowerCase().contains(params.typeFilter.toLowerCase())))

            if(params.sizeFilter != "--"){
                flag = worse(flag, it.size == params.sizeFilter)
            }
            if(params.environmentFilter != "--"){
                flag = worse(flag, it.environment == params.environmentFilter)
            }
            if(params.crStart != "--"){
                flag = worse(flag, crIndex(params.crStart) <= crIndex(it.cr))
            }
            if(params.crEnd != "--"){
                flag = worse(flag, crIndex(it.cr) <= crIndex(params.crEnd))
            }

            if(flag){
                monsters.add(it)
            }
        }

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersCrAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByCr().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersCrDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByCr(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersNameAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByName().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersNameDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByName(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTypeAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByType().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTypeDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByType(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSubtypeAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderBySubtype().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSubtypeDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderBySubtype(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSizeAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderBySize().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSizeDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderBySize(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersAlignmentAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByAlignment().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersAlignmentDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByAlignment(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersEnvironmentAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByEnvironment().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersEnvironmentDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByEnvironment(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTagsAsc(){
                def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByTags().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTagsDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        render(view: "monsters", model: [monsters: Monster.listOrderByTags(order: "desc").subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

}
