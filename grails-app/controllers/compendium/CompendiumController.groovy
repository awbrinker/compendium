package compendium
import grails.util.Holders

class CompendiumController {

    def index() { 
        render(view: "index")
    }

    def spells(){
        def springSecurityService = Holders.applicationContext.springSecurityService

        println(Spell.getAll())

        render(view: "spells", model: [spells: Spell.getAll(), hook: springSecurityService.currentUser.defaultHook])
    }
}
