package kataivvq

import grails.transaction.Transactional

@Transactional
class ProjectService {

    ProjectDAOService projectDAOService

    def addMemberToProject(User member, Project project) {
        projectDAOService.createProjectMember(project,member)
    }
}
