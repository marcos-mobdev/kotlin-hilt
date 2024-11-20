package br.com.appforge.kotlinhilt.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinhilt.R
import br.com.appforge.kotlinhilt.databinding.ActivityMainBinding
import br.com.appforge.kotlinhilt.presentation.viewModel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }


    private val usersViewModel by viewModels<UsersViewModel>()
    //Alternative:
    //private val usersViewModel:UsersViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
       //usersViewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        usersViewModel.users.observe(this){ usersList ->
            var listResult = ""
            usersList.forEach { user->
                listResult += "${user.firstName} ${user.surName} - ${user.age}\n"
            }

            binding.textView.text = listResult
        }




    }
}