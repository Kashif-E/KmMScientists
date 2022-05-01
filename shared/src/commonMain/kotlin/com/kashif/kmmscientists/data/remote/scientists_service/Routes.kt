package com.kashif.kmmscientists.data.remote.scientists_service

object Routes {

    private const val BASE_URL = "http://localhost:8080/" //for Ios you can just use localhost as it uses local machine's network
  // private const val BASE_URL = "http://10.0.2.2:8080/" // Android emulator uses 10.0.2.2 to connect to local host
    const val SCIENTISTS = "${BASE_URL}all"
    const val SCIENTIST_BY_ID = "${BASE_URL}scientistById"
}