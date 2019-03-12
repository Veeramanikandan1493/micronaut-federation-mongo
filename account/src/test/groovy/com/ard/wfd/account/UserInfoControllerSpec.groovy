package com.ard.wfd.account

import com.ard.wfd.account.client.UserInfoClient
import com.ard.wfd.account.domain.UserInfo
import com.ard.wfd.account.service.UserInfoService
import grails.gorm.transactions.Transactional
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class UserInfoControllerSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared
    UserInfoClient client = embeddedServer.applicationContext.getBean(UserInfoClient)
    @Shared
    UserInfoService service = embeddedServer.applicationContext.getBean(UserInfoService)
    @Shared
    Long id

    @Transactional
    void setupSpec() {
        def userInfo1 = new UserInfo(
                firstName: "Admin",
                lastName: "User",
                uName: "admin",
                uPassword: "admin123",
                email: "admin@mn.com",
                mobile: "97676655414",
                loggedIn: false
        )
        def userInfo2 = new UserInfo(
                firstName: "Test",
                lastName: "User",
                uName: "test",
                uPassword: "test123",
                email: "test@mn.com",
                mobile: "97676655434",
                loggedIn: false
        )
        id = service.save(userInfo1).id
        service.save(userInfo2)
    }

    @Transactional
    void cleanupSpec() {
        UserInfo.list()*.delete()
    }

    void "test index"() {
        when:
        List<UserInfo> userInfoList = client.list()

        then:
        userInfoList.size() == 2
    }

    void "test find one"() {
        when:
        UserInfo userInfo = client.show(id)

        then:
        userInfo.firstName == 'Admin'
        userInfo.uName == 'admin'
    }
}
