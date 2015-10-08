package kataivvq

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    User user

    def setup() {
        user = new User()
    }

    def cleanup() {
    }

    void "test a valid user "() {

        given: "a user correctly set"
        user.username = "toto"
        user.email = "toto@toto.com"
        user.password = "pwd1234"
        user.passwordConfirm = user.password

        when: "trying to validate the user"
        def res = user.validate()


        then: "the user is valid"
        res == true

        and: "the user has no errors"
        !user.hasErrors()

    }

    void "test invalid users"() {

        given: "a user with good username and password"
        user.username = "toto"
        user.password = "toto1234"

        and: "with a bad email"
        user.email = "toto"

        when: "trying to validate the user"
        def res = user.validate()

        then: "the user is not valid"
        res == false

        and: "the user has errors"
        user.hasErrors()

        when: "the user has a short password (less than 5 char) and a good email"
        user.email = "toto@gmail.com"
        user.password = "toto"

        and: "trying to validate the user"
        def userValidPassword = user.validate()

        then: "the user is not valid"
        userValidPassword == false

        and: "the user has errors"
        user.hasErrors()

    }

    @Unroll
    def "test invalid user #aUsername"() {
        given: "a user"
        user.username = aUsername
        user.password = aPassword
        user.email = anEmail

        when: "validating the user"
        def isValid = user.validate()

        then: "the user is not valid"
        isValid == false

        where:
        aUsername | aPassword   | anEmail
        "toto1"   | "toto12345" | "toto"
        "toto2"   | "toto"      | "toto@gmail.com"
        ""        | "toto12345" | "toto@gmail.com"
        null      | "toto12345" | "toto@gmail.com"

    }


}
