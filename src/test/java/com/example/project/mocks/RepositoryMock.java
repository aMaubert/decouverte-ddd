package com.example.project.mocks;

import com.example.project.models.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryMock<T extends Identifier> {

    public final List<T> stock;
    private int currentId;

    public RepositoryMock() {
        this.currentId = 0;
        this.stock = new ArrayList<>();
    }

    public T create(T element) {
        element.setId(this.currentId++);
        this.stock.add( element );
        return element;
    }

    public Optional<T> getElementById(int id) {
        return this.stock.stream().filter(element -> element.getId() == id ).findFirst();
    }

}
