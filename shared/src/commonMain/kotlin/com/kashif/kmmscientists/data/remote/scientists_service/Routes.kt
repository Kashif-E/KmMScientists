package com.kashif.kmmscientists.data.remote.scientists_service

object Routes {

    private const val BASE_URL = "http://localhost:8080/"
    const val SCIENTISTS = "${BASE_URL}all"
    const val SCIENTIST_BY_ID = "${BASE_URL}scientistById"
}