package com.maboe.ebookshop.di;

import android.app.Application;

import com.maboe.ebookshop.model.EBookShopRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    EBookShopRepository providesEBookShopRepository(Application application) {
        return new EBookShopRepository(application);
    }
}
