package com.example.projectcentre.di

import android.content.Context
import com.example.projectcentre.data.remote.api.AuthApi
import com.example.projectcentre.data.remote.api.UserApi
import com.example.projectcentre.data.repository.AuthRepository
import com.example.projectcentre.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

//    @Provides
//    @Singleton
//    fun provideAuthRepository(
//        authApi: AuthApi
//    ) = AuthRepository(authApi)
//
//    @Provides
//    @Singleton
//    fun provideUserRepository(
//        userApi: UserApi
//    ) = UserRepository(userApi)
//
//    @Provides
//    fun provideAuthApi(@Named("RetrofitMainApi") retrofit: Retrofit) : AuthApi {
//        return retrofit.create(AuthApi::class.java)
//    }
//
//    @Provides
//    fun provideUserApi(@Named("RetrofitMainApi") retrofit: Retrofit) : UserApi {
//        return retrofit.create(UserApi::class.java)
//    }

    @Provides
    @Singleton
    fun providesApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

//    @Provides
//    @Singleton
//    fun provideDataStoreOperations(
//        @ApplicationContext context: Context
//    ): DataStoreRep {
//        return DataStoreRepository(context = context)
//    }
//
//    @Provides
//    @Singleton
//    fun provideDataStoreOperationsImpl(
//        @ApplicationContext context: Context
//    ): DataStoreRepository {
//        return DataStoreRepository(context = context)
//    }



}