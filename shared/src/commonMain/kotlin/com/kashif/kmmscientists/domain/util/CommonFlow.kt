package com.kashif.kmmscientists.domain.util


import com.kashif.kmmscientists.data.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)

class CommonFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {

    fun collectCommon(
        coroutineScope: CoroutineScope? = null,
        collect: (T) -> Unit,
        error: (DataState.Message) -> Unit
    ) {
        try {

            onEach {
                collect(it)
            }.launchIn(coroutineScope ?: CoroutineScope(Dispatchers.Main))

        } catch (e: Exception) {

            error(DataState.Message.GenericMessage(e.message ?: "Something went wrong"))
        }


    }
}