package kataivvq

class Project {

    String name
    Date dateCreated

    User projectManager

    Integer memberCount() {
        ProjectMember.countByProject(this)
    }

    static constraints = {
        name blank: false
    }
}
