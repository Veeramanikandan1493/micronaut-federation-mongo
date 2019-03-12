package com.ard.wfd.workflow.domain

import com.ard.wfd.account.domain.UserInfo
import grails.gorm.annotation.Entity
import org.bson.types.ObjectId

@Entity
class WorkFlowDesign {

    ObjectId id
    String designName
    String description

    UserInfo createdBy
    UserInfo modifiedBy

    Date dateCreated
    Date lastUpdated

    static constraints = {
        designName unique: true
        description nullable: true

        createdBy nullable: true
        modifiedBy nullable: true
    }
}
