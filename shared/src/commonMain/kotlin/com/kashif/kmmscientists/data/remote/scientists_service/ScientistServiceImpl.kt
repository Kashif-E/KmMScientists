package com.kashif.kmmscientists.data.remote.scientists_service

import com.kashif.kmmscientists.data.remote.dto.ScientistDTO
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

class ScientistServiceImpl(private val httpClient: HttpClient) : AbstractScientistService {
    override suspend fun getAllScientists(): List<ScientistDTO> {

        return try {
            httpClient.get<List<ScientistDTO>> {
                url(Routes.SCIENTISTS)
            }
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getScientistsByOrigin(): List<ScientistDTO> {
        return try {
            httpClient.get<List<ScientistDTO>> {
                url(Routes.SCIENTISTS) {
                    parameter("origin", "Arab")
                }

            }
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }
}