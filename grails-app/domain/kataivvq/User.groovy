package kataivvq

class User {

    String username
    String email
    String password

    String passwordConfirm
    String passwordFirstTry

    static transients = ['passwordConfirm','passwordFirstTry']

    boolean isMemberOfProject(Project project){
        ProjectMember.findByMemberAndProject(this,project) != null
    }

//    def onLoad() {
//        passwordConfirm = password
//    }

    static constraints = {
        email email: true
        passwordFirstTry minSize: 5, validator: { val, obj ->
            return val == obj.passwordConfirm
        }
        passwordConfirm bindable:true
        passwordFirstTry bindable:true
        username blank: false
    }
}
