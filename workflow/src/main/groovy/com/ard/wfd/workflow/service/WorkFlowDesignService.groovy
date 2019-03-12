package com.ard.wfd.workflow.service

import com.ard.wfd.workflow.domain.WorkFlowDesign
import grails.gorm.services.Service

import javax.validation.constraints.NotNull

@Service(WorkFlowDesign)
interface WorkFlowDesignService {

    int count()

    WorkFlowDesign save(WorkFlowDesign userInfo)

    List<WorkFlowDesign> findAll()

    WorkFlowDesign find(@NotNull String id)

    WorkFlowDesign delete(@NotNull String id)
}