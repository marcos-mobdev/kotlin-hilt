package br.com.appforge.kotlinhilt.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.appforge.kotlinhilt.domain.model.User
import br.com.appforge.kotlinhilt.domain.useCase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor (
    private val usersUseCase: GetUsersUseCase
): ViewModel() {

    private val _users = MutableLiveData<List<User>>()

    val users :LiveData<List<User>>
        get() = _users

    init {
        getUsers()
    }


    fun getUsers(){
        viewModelScope.launch {
            val listUsers = usersUseCase()
            _users.postValue(listUsers)
        }
    }
}