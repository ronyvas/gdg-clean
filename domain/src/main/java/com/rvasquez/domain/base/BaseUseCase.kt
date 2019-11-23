package com.rvasquez.domain.base

import com.rvasquez.domain.model.Result

/**
 * Created by rvasquez on 2019-11-22.
 */

interface BaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): Result<R>
}