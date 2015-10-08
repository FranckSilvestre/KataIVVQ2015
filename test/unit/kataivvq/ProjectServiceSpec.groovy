package kataivvq

import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ProjectService)
class ProjectServiceSpec extends Specification {

    ProjectService projectService

    def setup() {
        projectService = new ProjectService()
        // Workaround for GRAILS-10538
         projectService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }

    }

    def cleanup() {
    }

//    void "test add project to member"() {
//
//        // what's wrong with this approach ?
//
//        given:"a user and a project"
//        User user = Mock(User)
//        Project project = Mock(Project)
//        user.isMemberOfProject(project) >> true
//        project.memberCount() >> 1
//
//        when:"I add a member to the project"
//        projectService.addMemberToProject(user,project)
//
//        then:"the user is a member of the project"
//        user.isMemberOfProject(project) == true
//
//        and:"the project has exactly one member"
//        project.memberCount() == 1
//
//    }

    void "test add project to member (the good approach)"() {

        given:"a user and a project"
        User user = Mock(User)
        Project project = Mock(Project)
        projectService.projectDAOService = Mock(ProjectDAOService)

        when:"I add a member to the project"
        projectService.addMemberToProject(user,project)

        then:"the creation of a ProjectMember is triggered"
        1 * projectService.projectDAOService.createProjectMember(project,user)

    }
}
