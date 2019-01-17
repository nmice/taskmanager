package ru.neginskiy.tm.service;

import ru.neginskiy.tm.api.IRepository;
import ru.neginskiy.tm.entity.AbstractEntity;

public abstract class AbstractService<T extends AbstractEntity> implements IRepository<T> {

}
