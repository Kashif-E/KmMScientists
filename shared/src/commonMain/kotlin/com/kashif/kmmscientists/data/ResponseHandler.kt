package com.kashif.kmmscientists.data

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException


enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1),
    BadRequest(400),
    NotFound(404),
    Conflict(409),
    InternalServerError(500),
    Forbidden(403),
    NotAcceptable(406),
    ServiceUnavailable(503),
    UnAuthorized(401),
}


open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T?): DataState<T> {
        return DataState.Success(data)
    }

    fun <T : Any> handleException(e: Exception): DataState<T> {

//        when(e){
//
//           is TimeoutException -> DataState.Message.Timeout
//            // is ConnectivityInterceptor.NoNetworkException -> Resource.CustomMessages.NoInternet
//            is UnknownHostException -> DataState.Message.ServerBusy
//            is ConnectException -> DataState.Message.NoInternet
//            is SocketTimeoutException -> DataState.Message.SocketTimeOutException
//            else -> DataState.CustomMessages.GenericMessage(getErrorMessage(throwable.cause))
//        }

        return DataState.Error(
            DataState.Message.GenericMessage(
                e.message ?: "Something went wrong"
            )
        )
    }

    fun <T : Any> handleException(message: DataState.Message): DataState<T> {


        return DataState.Error(message)
    }


    private fun getErrorMessage(cause: Throwable): String {
        return cause?.message?.let {
            if (it.contains("api")) {
                "No Internet"
            } else {
                it.ifEmpty {
                    "No Internet"
                }
            }

        } ?: "No Internet"
    }


    fun <T : Any> handleException(statusCode: Int): DataState.Message {
        return getErrorType(statusCode)
    }
}

private fun getErrorType(code: Int): DataState.Message {
    return when (code) {
        ErrorCodes.SocketTimeOut.code -> DataState.Message.Timeout
        ErrorCodes.UnAuthorized.code -> DataState.Message.Unauthorized
        ErrorCodes.InternalServerError.code -> DataState.Message.InternalServerError
        ErrorCodes.BadRequest.code -> DataState.Message.BadRequest
        ErrorCodes.Conflict.code -> DataState.Message.Conflict
        ErrorCodes.InternalServerError.code -> DataState.Message.InternalServerError
        ErrorCodes.NotFound.code -> DataState.Message.NotFound
        ErrorCodes.NotAcceptable.code -> DataState.Message.NotAcceptable
        ErrorCodes.ServiceUnavailable.code -> DataState.Message.ServiceUnavailable
        ErrorCodes.Forbidden.code -> DataState.Message.Forbidden
        else -> DataState.Message.GenericMessage("An error Occurred with code $code")
    }
}


