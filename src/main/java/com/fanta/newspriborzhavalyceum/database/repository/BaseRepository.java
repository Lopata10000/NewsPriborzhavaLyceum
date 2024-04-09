package com.fanta.newspriborzhavalyceum.database.repository;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<T, ID> {

    // Збереження сутності
    public abstract T save(T entity);

    // Отримання сутності за ідентифікатором
    public abstract Optional<T> findById(ID id);

    // Отримання всіх сутностей
    public abstract List<T> findAll();

    // Оновлення сутності
    public abstract T update(T entity);

    // Видалення сутності за ідентифікатором
    public abstract void deleteById(ID id);

}
