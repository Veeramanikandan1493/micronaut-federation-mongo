package com.ard.wfd.account.domain

import grails.gorm.annotation.Entity
import org.bson.types.ObjectId

@Entity
class UserInfo {
    ObjectId id
    String firstName
    String lastName
    String uName
    String uPassword
    String email
    String mobile
    Boolean loggedIn = false
    Date dateCreated
    Date lastUpdated

    static constraints = {
        uName unique: true
        email unique: true, email: true
        mobile nullable: true
    }
}
