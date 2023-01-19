package compendium
import grails.util.Holders

class CompendiumController {

    def worse(cur, next){
        if(!cur) {
            return cur;
        }
        else return next;
    }

    def index() { 
        render(view: "index")
    }

    def classes() { 
        render(view: "classes")
    }

    def races() { 
        render(view: "races")
    }

    // Spells

    def getFilteredSpells(baseList) {
        def spells = new ArrayList<Spell>()

        for(Spell it: baseList){
            boolean flag = true;
            flag = it.name.toLowerCase().contains(params.nameFilter.toLowerCase())

            if(params.tagFilter != "--"){
                flag = worse(flag, it.dmgType.contains(params.tagFilter) || (it.tags != null && it.tags.contains(params.tagFilter)))
            }
            if(params.castingTimeFilter != "--"){
                flag = worse(flag, it.environment == params.castingTimeFilter)
            }
            if(params.levelStart != "--"){
                flag = worse(flag, it.level.compareTo(params.levelStart) >= 0)
            }
            if(params.levelEnd != "--"){
                flag = worse(flag, it.level.compareTo(params.levelEnd) <= 0)
            }

            if(flag){
                spells.add(it)
            }
        }

        return spells
    }

    def filterSpells(){
       def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def spells = getFilteredSpells(Spell.getAll())

        if(end < 10 && spells.size() > 10 && end < spells.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(spells.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, spells.size())

        render(view: "spells", model: [spells: spells.subList(start, end), count: spells.size(), start: start+1, end: end, nameFilter: params.nameFilter, tagsFilter: params.tagsFilter, 
                                        castingTimeFilter: params.castingTimeFilter, levelStart: params.levelStart, levelEnd: params.levelEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def spells(){
        def springSecurityService = Holders.applicationContext.springSecurityService
        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        end = Math.min(end, Spell.count())

        render(view: "spells", model: [spells: Spell.listOrderByName().subList(start, end), count: Spell.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    // Equipment

    def equipment(){
        def springSecurityService = Holders.applicationContext.springSecurityService
        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        end = Math.min(end, Equipment.count())

        render(view: "equipment", model: [items: Equipment.listOrderByName().subList(start, end), count: Equipment.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
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

        end = Math.min(end, MagicItem.count())

        render(view: "magicitems", model: [magicitems: MagicItem.listOrderByName().subList(start, end), count: MagicItem.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
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

        end = Math.min(end, Monster.count())

        render(view: "monsters", model: [monsters: Monster.listOrderByName().subList(start, end), count: Monster.count, start: start+1, end: end, hook: springSecurityService.currentUser.defaultHook])
    }

    def getFilteredMonsters(baseList) {
        def monsters = new ArrayList<Monster>()

        for(Monster it: baseList){
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

        return monsters
    }

    def filterMonsters(){
       def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.getAll())

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

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByCr())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersCrDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByCr(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersNameAsc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByName())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersNameDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByName(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTypeAsc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByType())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTypeDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByType(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSubtypeAsc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderBySubtype())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSubtypeDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderBySubtype(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSizeAsc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderBySize())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersSizeDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderBySize(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersAlignmentAsc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByAlignment())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersAlignmentDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByAlignment(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersEnvironmentAsc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByEnvironment())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersEnvironmentDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByEnvironment(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTagsAsc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByTags())

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }

    def sortMonstersTagsDesc(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        int start = 0
        int end = springSecurityService.currentUser.defaultLoadSize

        if(params.start != null){
            start = params.start.toInteger()-1
            end = params.end.toInteger()
        }

        def monsters = getFilteredMonsters(Monster.listOrderByTags(order: "desc"))

        if(end < 10 && monsters.size() > 10 && end < monsters.size() && end < springSecurityService.currentUser.defaultLoadSize){
            end = Math.min(monsters.size(), springSecurityService.currentUser.defaultLoadSize)
        }
        end = Math.min(end, monsters.size())

        render(view: "monsters", model: [monsters: monsters.subList(start, end), count: monsters.size(), start: start+1, end: end, nameFilter: params.nameFilter, typeFilter: params.typeFilter, 
                                        sizeFilter: params.sizeFilter, environmentFilter: params.environmentFilter, crStart: params.crStart, crEnd: params.crEnd, hook: springSecurityService.currentUser.defaultHook])
    }


    // Vehicles

    def vehicles(){
        render(view: "vehicles")
    }

    def vehicle(){
        def springSecurityService = Holders.applicationContext.springSecurityService
        def vehicle = Vehicle.findByName(params.vehicle)

        render(view: "vehicle", model: [vehicle: vehicle, hook: springSecurityService.currentUser.defaultHook])
    }

}
