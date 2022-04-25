package com.kashif.kmmscientists.data.local.entities

@kotlinx.serialization.Serializable
data class Status(
    val message: String,
    val code: Int,
    val error: String=""
)