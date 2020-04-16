package com.maboe.ebookshop.model;

import android.app.Application;


import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EBookShopRepository {
    private CategoryDao categoryDao;
    private BookDao bookDao;

    private LiveData<List<Category>> categories;
    private LiveData<List<Book>> books;


    public EBookShopRepository(Application application) {

        BooksDataBase booksDataBase = BooksDataBase.getInstance(application);
        categoryDao = booksDataBase.categoryDao();
        bookDao = booksDataBase.bookDao();

    }

    public LiveData<List<Category>> getCategories() {
        return categoryDao.getAllCategories();
    }

    public LiveData<List<Book>> getBooks(int categoryId) {
        return bookDao.getBooks(categoryId);
    }

    public void insertCategory(Category category) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.insert(category);
            }
        });

    }

    public void updateCategory(Category category) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.update(category);
            }
        });
    }

    public void deleteCategory(Category category) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.delete(category);
            }
        });
    }


    public void insertBook(Book book) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                bookDao.insert(book);
            }
        });

    }

    public void updateBook(Book book) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                bookDao.update(book);
            }
        });
    }

    public void deleteBook(Book book) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(new Runnable() {
            @Override
            public void run() {
                bookDao.delete(book);
            }
        });
    }

}