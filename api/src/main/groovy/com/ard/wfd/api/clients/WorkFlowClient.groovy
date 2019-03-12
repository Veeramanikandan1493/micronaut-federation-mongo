package com.ard.wfd.api.clients

import com.ard.wfd.workflow.domain.WorkFlowDesign
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.client.annotation.Client
import io.reactivex.Maybe
import io.reactivex.Single

import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Client("workFlow")
interface WorkFlowClient<T extends WorkFlowDesign> {
    @Get("/workFlowDesign")
    Single<List<T>> list();

    @Get("/workFlowDesign/{id}")
    Maybe<T> find(Long id)

    @Post("/workFlowDesign")
    Single<T> save(@Valid @Body T pdt)

    @Put("/workFlowDesign/{id}")
    Single<T> update(@NotBlank Long id, @Valid @Body T pdt)
}