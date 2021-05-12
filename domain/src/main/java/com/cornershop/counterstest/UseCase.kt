package com.cornershop.counterstest

import com.cornershop.counterstest.exception.Failure
import com.cornershop.counterstest.functional.CustomResult
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

interface UseCase<in Params, out Type> where Type : Any {

    suspend operator fun invoke(
        params: Params,
        context: CoroutineContext = IO
    ): CustomResult<Failure, Type> =
        withContext(context) {
            invoke(params, context)
        }
    
    object None
}