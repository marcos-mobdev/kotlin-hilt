package br.com.appforge.kotlinhilt.data.dto

data class APIResponseDTO(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserDTO>
)