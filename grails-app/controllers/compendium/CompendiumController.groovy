package compendium
import grails.util.Holders

class CompendiumController {

    def index() { 
        render(view: "index")
    }

    def spells(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "spells", model: [spells: Spell.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

    def equipment(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "equipment", model: [items: Equipment.listOrderByName(), hook: springSecurityService.currentUser.defaultHook])
    }

}
