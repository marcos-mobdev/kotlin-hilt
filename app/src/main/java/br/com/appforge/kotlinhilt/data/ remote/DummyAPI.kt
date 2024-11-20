package br.com.appforge.kotlinhilt.data.remote

import br.com.appforge.kotlinhilt.data.dto.APIResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {

    @GET("users")
    suspend fun getUsers():Response<APIResponseDTO>


}