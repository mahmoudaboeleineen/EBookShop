package com.maboe.ebookshop;

import android.app.Application;

import com.maboe.ebookshop.di.AppModule;
import com.maboe.ebookshop.di.DaggerEBookShopComponent;
import com.maboe.ebookshop.di.EBookShopComponent;

public class App extends Application {

    private static App app;

    private EBookShopComponent eBookShopComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        eBookShopComponent = DaggerEBookShopComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        app = this;
    }

    public static App getApp() {
        return app;
    }

    public EBookShopComponent getEBookShopComponent() {
        return eBookShopComponent;
    }
}
