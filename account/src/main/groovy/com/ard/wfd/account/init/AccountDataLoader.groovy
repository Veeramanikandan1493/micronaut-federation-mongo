package com.ard.wfd.account.init

import com.ard.wfd.account.service.UserInfoService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.discovery.event.ServiceStartedEvent

@Slf4j
@CompileStatic
//@Singleton
@Requires(notEnv = Environment.TEST)
class AccountDataLoader implements ApplicationEventListener<ServiceStartedEvent> {

    final UserInfoService userInfoService

    AccountDataLoader(final UserInfoService userInfoService) {
        this.userInfoService = userInfoService
    }

//    @Inject
//    UserInfoService userInfoService

    @Override
    void onApplicationEvent(ServiceStartedEvent event) {
        log.info("Account Data Loader")
//        if (!userInfoService.count()) {
//            userInfoService.save(new UserInfo(
//                    firstName: "Admin",
//                    lastName: "User",
//                    uName: "admin",
//                    uPassword: "admin123",
//                    email: "admin@mn.com",
//                    mobile: "97676655434",
//                    loggedIn: false
//            ))
//        }
    }
}