package com.maboe.ebookshop.di;


import com.maboe.ebookshop.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface EBookShopComponent {

    void inject(MainActivity mainActivity);
}
