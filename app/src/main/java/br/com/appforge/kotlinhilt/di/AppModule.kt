package br.com.appforge.kotlinhilt.di

import br.com.appforge.kotlinhilt.data.remote.DummyAPI
import br.com.appforge.kotlinhilt.data.repository.UserRepositoryImpl
import br.com.appforge.kotlinhilt.domain.repository.UserRepository
import br.com.appforge.kotlinhilt.domain.useCase.GetUsersUseCase
import br.com.appforge.kotlinhilt.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.DUMMY_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDummyAPI(retrofit:Retrofit):DummyAPI{
        return retrofit.create(DummyAPI::class.java)
    }

    @Provides
    fun provideUserRepository(dummyAPI: DummyAPI):UserRepository{
        return UserRepositoryImpl(dummyAPI)
    }

    @Provides
    fun proviceUsersUseCase(userRepository: UserRepository):GetUsersUseCase{
        return GetUsersUseCase(userRepository)
    }

}