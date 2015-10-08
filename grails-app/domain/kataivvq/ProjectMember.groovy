package kataivvq

class ProjectMember {

    User member
    Project project

    static belongsTo = [member:User,project:Project]

    Integer partTime

    static constraints = {
    }
}
