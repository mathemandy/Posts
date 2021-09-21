package life.league.challenge.kotlin.features.posts.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import life.league.challenge.kotlin.BuildConfig
import life.league.challenge.kotlin.features.posts.contract.GetPostRemote
import life.league.challenge.kotlin.features.posts.remote.ApiService
import life.league.challenge.kotlin.features.posts.remote.impl.GetPostRemoteImpl
import life.league.challenge.kotlin.libraries.remote.RemoteFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal interface RemoteModule {

    @get:Binds
    val GetPostRemoteImpl.bindGetPostRemote: GetPostRemote

    companion object {
        @[Provides Singleton]
        fun apiService(remoteFactory: RemoteFactory): ApiService =
            remoteFactory.createRetrofit(
                url = BuildConfig.BASE_URL,
                isDebug = BuildConfig.DEBUG
            ).create(ApiService::class.java)
    }
}
