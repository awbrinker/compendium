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

        render(view: "spells", model: [spells: Spell.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    def equipment(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "equipment", model: [items: Equipment.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    def feats(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "feats", model: [feats: Feat.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    def backgrounds(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "backgrounds", model: [backgrounds: Background.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    def magicitems(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "magicitems", model: [magicitems: MagicItem.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    def monsters(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "monsters", model: [monsters: Monster.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

}
