package com.ard.wfd.account.service

import com.ard.wfd.account.domain.UserInfo
import grails.gorm.services.Service

import javax.validation.constraints.NotNull

@Service(UserInfo)
interface UserInfoService {

    int count()

    UserInfo save(UserInfo userInfo)

    List<UserInfo> findAll()

    UserInfo find(@NotNull Long id)

    UserInfo delete(@NotNull Long id)
}

//@Singleton
//@Service(UserInfo)
//abstract class UserInfoService implements IUserInfoService {
//    int count() {}
//
//    UserInfo save(UserInfo userInfo) {}
//
//    List<UserInfo> findAll() {}
//
//    UserInfo find(@NotNull Long id) {}
//
//    UserInfo delete(@NotNull Long id) {}
//}