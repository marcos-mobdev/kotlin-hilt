package br.com.appforge.kotlinhilt.data.repository

import android.util.Log
import br.com.appforge.kotlinhilt.data.dto.UserDTO
import br.com.appforge.kotlinhilt.data.dto.toUser
import br.com.appforge.kotlinhilt.data.remote.DummyAPI
import br.com.appforge.kotlinhilt.domain.model.User
import br.com.appforge.kotlinhilt.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dummyAPI: DummyAPI
):UserRepository {
    override suspend fun getUsers(): List<User> {
        try{
            val response = dummyAPI.getUsers()
            if(response.isSuccessful && response.body() != null){
                val resultAPIDTO = response.body()
                val userListDTO = resultAPIDTO?.users
                if(userListDTO != null){
                    return userListDTO.map { it.toUser() }
                }else{
                    Log.i("info_users", "")
                }
            }else{
                Log.i("info_users", "${response.message()}")
            }

        }catch(getUsersError:Exception){
            getUsersError.printStackTrace()
        }
        return emptyList()
    }
}