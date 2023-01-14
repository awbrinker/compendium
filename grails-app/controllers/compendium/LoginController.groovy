package compendium
import grails.gorm.transactions.*

class LoginController {

    def register() {
        render(view: "register")
    }

    @Transactional
    def createAccount() {
        def user = User.find {username == params.username}

        /* If username already exists within the database */
        if(user != null){
            def message = "An account already exists with that username.  Please choose another."
            redirect(view: "register", model: [errorMessage: message])
            return
            
        }else if(params.username != null && params.username != ""){ def userRole = Role.find { authority == "ROLE_USER"}

            def newUser = new User(username: params.username, password: params.password)
            newUser.save(flush: true)
            UserRole.create newUser, userRole, true
            UserRole.withSession {
                        it.flush()
                        it.clear()
            }

            redirect(view: "/index")
            return;
        }else{

            def message = "Invalid Username."
            redirect(view: "register", model: [errorMessage: message])
            return
        }
    }
}
