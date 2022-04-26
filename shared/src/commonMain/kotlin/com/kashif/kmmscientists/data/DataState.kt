package com.kashif.kmmscientists.data


/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */


sealed  class DataState<T>(
    val data: T? = null,
    val error : Message = Message.GenericMessage("Something Went Wrong")
) {
    class Success<T>(data: T?) : DataState<T>(data)
    class Loading<T> : DataState<T>()
    class Error<T>(message: Message): DataState<T>(error =  message)
    sealed class Message(val message: String="")  {

        object Timeout : Message()
        object ServerResponseException: Message()
        object ClientRequestException: Message()
        object RedirectResponseException: Message()
        object EmptyData: Message()
        object ServerBusy : Message()
        object HttpException : Message()
        object SocketTimeOutException : Message()
        object NoInternet : Message()
        object Unauthorized : Message()
        object InternalServerError : Message()
        object BadRequest : Message()
        object Conflict : Message()
        object NotFound : Message()
        object NotAcceptable : Message()
        object ServiceUnavailable : Message()
        object Forbidden : Message()
        data class GenericMessage(val error: String) : Message(message = error)


    }

}
