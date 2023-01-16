package compendium
import grails.gorm.transactions.*

class BootStrap {

    @Transactional
    void initialize(){

        // Users
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testAdmin = new User(username: 'admin', password: 'password', defaultHook: 'https://discordapp.com/api/webhooks/1063212486121234443/WnujW9t76JO5ogf-RUbhrjHlVerXMmsHYfJ2VD-R0rACP9DOOsYmemSqwp1TbdPJy2bW')
        testAdmin.save(flush: true)

        def testUser = new User(username: 'user', password: 'password')
        testUser.save(flush: true)

        UserRole.create testAdmin, adminRole, true
        UserRole.create testUser, userRole, true
        UserRole.withSession {
            it.flush()
            it.clear()
        }

        // Libraries
        SpellLibrary.initialize()
        EquipmentLibrary.initialize()
        FeatLibrary.initialize()
        BackgroundLibrary.initialize()
        MagicItemLibrary.initialize()
        MonsterLibrary.initialize()

        // SpellLibrary.overload()
        //EquipmentLibrary.overload()
        // MagicItemLibrary.overload()
        // MonsterLibrary.overload()
    }

    def init = { servletContext ->
        initialize()
    }
    def destroy = {
    }
}
