package com.maboe.ebookshop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.maboe.ebookshop.model.Book;
import com.maboe.ebookshop.model.Category;
import com.maboe.ebookshop.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> getAllCategories;
    private LiveData<List<Book>> getAllBooksOfSelectedCategory;


    public MainActivityViewModel(EBookShopRepository eBookShopRepository) {
        this.eBookShopRepository = eBookShopRepository;
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
