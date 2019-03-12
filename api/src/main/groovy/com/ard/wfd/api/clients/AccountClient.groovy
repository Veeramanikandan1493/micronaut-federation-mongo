package com.ard.wfd.api.clients

import com.ard.wfd.account.domain.UserInfo
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.client.annotation.Client
import io.reactivex.Maybe
import io.reactivex.Single

import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Client("account")
interface AccountClient<T extends UserInfo> {
    @Get("/userInfo")
    Single<List<T>> list();

    @Get("/userInfo/{id}")
    Maybe<T> find(Long id)

    @Post("/userInfo")
    Single<T> save(@Valid @Body T pdt)

    @Put("/userInfo/{id}")
    Single<T> update(@NotBlank Long id, @Valid @Body T pdt)
}