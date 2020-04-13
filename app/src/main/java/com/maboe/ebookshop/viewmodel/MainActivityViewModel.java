package com.maboe.ebookshop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.maboe.ebookshop.model.Book;
import com.maboe.ebookshop.model.Category;
import com.maboe.ebookshop.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> getAllCategories;
    private LiveData<List<Book>> getAllBooksOfSelectedCategory;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookShopRepository = new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getGetAllCategories() {
        getAllCategories = eBookShopRepository.getCategories();
        return getAllCategories;
    }

    public LiveData<List<Book>> getGetAllBooksOfSelectedCategory(int categoryId) {
        getAllBooksOfSelectedCategory = eBookShopRepository.getBooks(categoryId);
        return getAllBooksOfSelectedCategory;
    }

    public void insertBook(Book book) {
        eBookShopRepository.insertBook(book);
    }

    public void updateBook(Book book) {
        eBookShopRepository.updateBook(book);
    }

    public void deleteBook(Book book) {
        eBookShopRepository.deleteBook(book);
    }

}
