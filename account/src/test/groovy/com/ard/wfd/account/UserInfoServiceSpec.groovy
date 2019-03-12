package com.ard.wfd.account

import com.ard.wfd.account.domain.UserInfo
import com.ard.wfd.account.service.UserInfoService
import grails.gorm.transactions.Rollback
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@Rollback
class UserInfoServiceSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared
    UserInfoService service = embeddedServer.applicationContext.getBean(UserInfoService) // <2>

    void "it can work with clubs"() {
        expect:
        service.count() == 0

        when:
        service.save(new UserInfo(
                firstName: "Admin",
                lastName: "User",
                uName: "admin",
                uPassword: "admin123",
                email: "admin@mn.com",
                mobile: "97676655414",
                loggedIn: false
        ))

        then:
        service.count() == 1

        when:
        List<UserInfo> clubs = service.findAll()

        then:
        clubs.size() == 1
    }

    void "it can show a club"() {
        given:
        UserInfo club = service.save(new UserInfo(
                firstName: "Test",
                lastName: "User",
                uName: "test",
                uPassword: "test123",
                email: "test@mn.com",
                mobile: "97676655434",
                loggedIn: false
        ))

        when:
        service.find(club.id)

        then:
        club.firstName == "Test"
        club.uName == "test"
    }
}