package br.com.appforge.kotlinhilt.domain.repository

import br.com.appforge.kotlinhilt.domain.model.User

interface UserRepository {

    suspend fun getUsers():List<User>
}