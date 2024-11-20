package br.com.appforge.kotlinhilt.domain.useCase

import br.com.appforge.kotlinhilt.domain.model.User
import br.com.appforge.kotlinhilt.domain.repository.UserRepository
import javax.inject.Inject


class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
){

    suspend operator fun invoke():List<User>{
        try{
            //Insert Business Rules here
            return userRepository.getUsers()


        }catch (getUsersError:Exception){
            getUsersError.printStackTrace()
            return emptyList()
        }
    }

}