package com.kashif.kmmscientists.data.entities

@kotlinx.serialization.Serializable
data class Status(
    val message: String,
    val code: Int,
    val error: String=""
)