package life.league.challenge.kotlin.features.posts.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import life.league.challenge.kotlin.features.posts.contract.GetPostRepository
import life.league.challenge.kotlin.features.posts.repository.GetPostRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
internal interface RepositoryModule {

    @get:Binds
    val GetPostRepositoryImpl.getPostRepository: GetPostRepository
}
