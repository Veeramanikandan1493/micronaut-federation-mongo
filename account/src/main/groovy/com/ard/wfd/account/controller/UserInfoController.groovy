package com.ard.wfd.account.controller

import com.ard.wfd.account.domain.UserInfo
import com.ard.wfd.account.service.UserInfoService
import grails.gorm.transactions.Transactional
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

import javax.inject.Inject

@Controller("/userInfo")
class UserInfoController {

    @Inject
    UserInfoService userInfoService

    @Get("/{?args*}")
    List<UserInfo> list(def args) {
        println("index called")
        return userInfoService.findAll()
    }

    @Get("/{id}")
    @Transactional
    def show(Long id) {
        println("get called")
        def userInfo = userInfoService.find(id)
        if (userInfo == null) {
            return HttpStatus.NOT_FOUND
        }

        return userInfo
    }

    @Post("/")
    @Consumes([MediaType.APPLICATION_JSON])
    @Transactional
    def create(@Body UserInfo userInfo) {
        println("create called")
        try {
            return userInfoService.save(userInfo)
        }
        catch (Exception e) {
            println "${e}"
            return [status: HttpStatus.BAD_REQUEST, errors: userInfo.errors]
        }
    }

    @Delete("/{id}")
    @Transactional
    def delete(Long id) {
        println("delete called")
        def userInfo = userInfoService.find(id)
        if (userInfo == null) {
            return HttpStatus.NOT_FOUND
        }
        try {
            userInfoService.delete(id)
            return HttpStatus.NO_CONTENT
        }
        catch (Exception e) {
            println "${e}"
            return [status: HttpStatus.BAD_REQUEST, errors: userInfo.errors]
        }
    }

    @Put("/{id}")
    @Transactional
    def update(Long id, @Body UserInfo body) {
        println("update called")
        def userInfo = userInfoService.find(id)
        if (userInfo == null) {
            return HttpStatus.NOT_FOUND
        }

        userInfo.properties = body.properties

        try {
            userInfo = userInfoService.save(userInfo)
            return userInfo
        }
        catch (Exception e) {
            println "${e}"
            return [status: HttpStatus.BAD_REQUEST, errors: userInfo.errors]
        }
    }
}