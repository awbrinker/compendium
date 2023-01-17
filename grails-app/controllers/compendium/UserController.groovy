package compendium
import grails.util.Holders
import grails.gorm.transactions.*

class UserController {

    def index() { 
        def springSecurityService = Holders.applicationContext.springSecurityService

        render(view: "index", model: [hook: springSecurityService.currentUser.defaultHook, load: springSecurityService.currentUser.defaultLoadSize])
    }

    @Transactional
    def updateHook() {
        def springSecurityService = Holders.applicationContext.springSecurityService
        def user = springSecurityService.currentUser

        user.setDefaultHook(params.target)
        user.save(flush: true)
        render(view: "index", model: [hook: springSecurityService.currentUser.defaultHook])
    }

    @Transactional
    def updateLoad() {
        def springSecurityService = Holders.applicationContext.springSecurityService
        def user = springSecurityService.currentUser

        user.setDefaultLoadSize(params.load.toInteger())
        user.save(flush: true)
        render(view: "index", model: [hook: springSecurityService.currentUser.defaultHook, load: springSecurityService.currentUser.defaultLoadSize])
    }
}
