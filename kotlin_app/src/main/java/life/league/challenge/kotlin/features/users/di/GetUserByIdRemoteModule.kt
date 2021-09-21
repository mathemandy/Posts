package life.league.challenge.kotlin.features.users.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import life.league.challenge.kotlin.BuildConfig
import life.league.challenge.kotlin.features.users.contract.GetUserByIdRemote
import life.league.challenge.kotlin.features.users.remote.UserApiService
import life.league.challenge.kotlin.features.users.remote.impl.GetUserByIdRemoteImpl
import life.league.challenge.kotlin.libraries.remote.RemoteFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal interface GetUserByIdRemoteModule {

    @get:Binds
    val GetUserByIdRemoteImpl.bindGetUserById: GetUserByIdRemote

    companion object {
        @[Provides Singleton]
        fun userApiService(remoteFactory: RemoteFactory): UserApiService =
            remoteFactory.createRetrofit(
                url = BuildConfig.BASE_URL,
                isDebug = BuildConfig.DEBUG
            ).create(UserApiService::class.java)
    }
}
