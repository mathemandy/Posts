package life.league.challenge.kotlin.features.auth.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import life.league.challenge.kotlin.BuildConfig
import life.league.challenge.kotlin.features.auth.contract.LoginRemote
import life.league.challenge.kotlin.features.auth.remote.LoginApiService
import life.league.challenge.kotlin.features.auth.remote.impl.LoginRemoteImpl
import life.league.challenge.kotlin.libraries.remote.RemoteFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal interface AuthRemoteModule {

    @get:Binds
    val LoginRemoteImpl.bindLoginRemote: LoginRemote

    companion object {
        @[Provides Singleton]
        fun loginApiService(remoteFactory: RemoteFactory): LoginApiService =
            remoteFactory.createRetrofit(
                url = BuildConfig.BASE_URL,
                isDebug = BuildConfig.DEBUG
            ).create(LoginApiService::class.java)
    }
}
