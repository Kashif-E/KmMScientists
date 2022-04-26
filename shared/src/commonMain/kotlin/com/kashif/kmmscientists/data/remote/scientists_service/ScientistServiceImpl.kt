package com.kashif.kmmscientists.data.remote.scientists_service

import com.kashif.kmmscientists.data.remote.dto.ScientistDTO
import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.data.ResponseHandler
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ScientistServiceImpl(
    private val httpClient: HttpClient,
    private val responseHandler: ResponseHandler
) : AbstractScientistService {
    override fun getAllScientists() = flow {

        try {
            val scientistList = httpClient.get<List<ScientistDTO>> {
                contentType(ContentType.Application.Json)
                url(Routes.SCIENTISTS)
            }
            emit(responseHandler.handleSuccess(scientistList))
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emit(
                responseHandler.handleException(
                    DataState.Message.RedirectResponseException
                )
            )
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emit(
                responseHandler.handleException(
                    DataState.Message.RedirectResponseException
                )
            )
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emit(
                responseHandler.handleException(
                    DataState.Message.RedirectResponseException
                )
            )
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emit(
                responseHandler.handleException(
                    e
                )
            )
        }
    }

    override suspend fun getScientistsByOrigin(origin: String) = flow {
        try {
            val scientistList = httpClient.get<List<ScientistDTO>> {
                url(Routes.SCIENTISTS) {
                    parameter("origin", origin)
                }

            }
            emit(responseHandler.handleSuccess(scientistList))
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emit(
                responseHandler.handleException(
                    DataState.Message.RedirectResponseException
                )
            )
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emit(
                responseHandler.handleException(
                    DataState.Message.RedirectResponseException
                )
            )
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emit(
                responseHandler.handleException(
                    e
                )
            )
        }
    }
}