package com.ard.wfd.workflow.init

import com.ard.wfd.workflow.service.WorkFlowDesignService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.discovery.event.ServiceStartedEvent

import javax.inject.Singleton

@Slf4j
@CompileStatic
@Singleton
@Requires(notEnv = Environment.TEST)
class WorkFlowDataLoader implements ApplicationEventListener<ServiceStartedEvent> {

    final WorkFlowDesignService workFlowDesignService

    WorkFlowDataLoader(WorkFlowDesignService workFlowDesignService) {
        this.workFlowDesignService = workFlowDesignService
    }

//    @Inject
//    WorkFlowDesignService workFlowDesignService

    @Override
    void onApplicationEvent(ServiceStartedEvent event) {
        log.info("Account Data Loader")
//        if (!workFlowDesignService.count()) {
//            workFlowDesignService.save(new WorkFlowDesign(designName: 'Design 1', description: 'Description 1'))
//            workFlowDesignService.save(new WorkFlowDesign(designName: 'Design 2', description: 'Description 2'))
//            workFlowDesignService.save(new WorkFlowDesign(designName: 'Design 3', description: 'Description 3'))
//        }
    }
}