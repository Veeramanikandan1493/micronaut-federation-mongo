package com.ard.wfd.workflow.controller

import com.ard.wfd.workflow.domain.WorkFlowDesign
import com.ard.wfd.workflow.service.WorkFlowDesignService
import grails.gorm.transactions.Transactional
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

import javax.inject.Inject

@Controller("/workFlowDesign")
class WorkFlowDesignController {

    @Inject
    WorkFlowDesignService workFlowDesignService

    @Get("/")
    List<WorkFlowDesign> list() {
        println("index called")
        return workFlowDesignService.findAll()
    }

    @Get("/{id}")
    @Transactional
    def show(String id) {
        println("get called")
        def workFlowDesign = workFlowDesignService.find(id)
        if (workFlowDesign == null) {
            return HttpStatus.NOT_FOUND
        }

        return workFlowDesign
    }

    @Post("/")
    @Consumes([MediaType.APPLICATION_JSON])
    @Transactional
    def create(@Body WorkFlowDesign workFlowDesign) {
        println("create called")
        try {
            return workFlowDesignService.save(workFlowDesign)
        }
        catch (Exception e) {
            println "${e}"
            return [status: HttpStatus.BAD_REQUEST, errors: workFlowDesign.errors]
        }
    }

    @Delete("/{id}")
    @Transactional
    def delete(String id) {
        println("delete called")
        def workFlowDesign = workFlowDesignService.find(id)
        if (workFlowDesign == null) {
            return HttpStatus.NOT_FOUND
        }
        try {
            workFlowDesignService.delete(id)
            return HttpStatus.NO_CONTENT
        }
        catch (Exception e) {
            println "${e}"
            return [status: HttpStatus.BAD_REQUEST, errors: workFlowDesign.errors]
        }
    }

    @Put("/{id}")
    @Transactional
    def update(String id, @Body WorkFlowDesign body) {
        println("update called")
        def workFlowDesign = workFlowDesignService.find(id)
        if (workFlowDesign == null) {
            return HttpStatus.NOT_FOUND
        }

        try {
            return workFlowDesignService.save(workFlowDesign)
        }
        catch (Exception e) {
            println "${e}"
            return [status: HttpStatus.BAD_REQUEST, errors: workFlowDesign.errors]
        }
    }
}