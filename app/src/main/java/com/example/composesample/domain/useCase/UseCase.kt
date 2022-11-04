package com.example.composesample.domain.useCase

abstract class UseCase<in P, R> {

    abstract suspend fun invoke(parameters: P): R
}