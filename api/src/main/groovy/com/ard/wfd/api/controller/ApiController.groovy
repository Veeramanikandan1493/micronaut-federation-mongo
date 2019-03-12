package com.ard.wfd.api.controller

import com.ard.wfd.account.domain.UserInfo
import com.ard.wfd.api.clients.AccountClient
import com.ard.wfd.api.clients.WorkFlowClient
import com.ard.wfd.workflow.domain.WorkFlowDesign
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@Controller("/")
class ApiController {

    @Inject
    AccountClient accountClient
    @Inject
    WorkFlowClient workFlowClient

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }

    @Get("/userInfos")
    def fetchUserInfos() {
        return accountClient.list()
    }

    @Get("/userInfo/{id}")
    def fetchUserInfo(Long id) {
        return accountClient.find(id)
    }

    @Post("/userInfo")
    def saveUserInfo(@Body UserInfo userInfo) {
        return accountClient.save(userInfo)
    }

    @Put("/userInfo/{id}")
    def updateUserInfo(@NotBlank Long id, @Body UserInfo userInfo) {
        return accountClient.update(id, userInfo)
    }

    @Get("/workFlowDesigns")
    def fetchWorkFlowDesigns() {
        return workFlowClient.list()
    }

    @Get("/workFlowDesign/{id}")
    def fetchWorkFlowDesign(Long id) {
        return workFlowClient.find(id)
    }

    @Post("/workFlowDesign")
    def saveWorkFlowDesign(@Body WorkFlowDesign workFlowDesign) {
        return workFlowClient.save(workFlowDesign)
    }

    @Put("/workFlowDesign/{id}")
    def updateWorkFlowDesign(@NotBlank Long id, @Body WorkFlowDesign workFlowDesign) {
        return workFlowClient.update(id, workFlowDesign)
    }
}