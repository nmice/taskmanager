package ru.neginskiy.tm.service;

import ru.neginskiy.tm.api.IService;
import ru.neginskiy.tm.repository.AbstractRepository;

public abstract class AbstractService<T extends AbstractRepository> implements IService<T> {

}
