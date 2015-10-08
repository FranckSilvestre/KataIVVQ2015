package kataivvq

class User {

    String username
    String email
    String password

    String passwordConfirm

    static transients = ['passwordConfirm']

    boolean isMemberOfProject(Project project){
        ProjectMember.findByMemberAndProject(this,project) != null
    }

//    def onLoad() {
//        passwordConfirm = password
//    }

    static constraints = {
        email email: true
        password minSize: 5, validator: { val, obj ->
            return val == obj.passwordConfirm
        }
        username blank: false
    }
}
