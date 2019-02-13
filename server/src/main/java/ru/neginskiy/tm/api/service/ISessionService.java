package ru.neginskiy.tm.api.service;

import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.entity.Session;
import ru.neginskiy.tm.error.UncorrectSessionException;

public interface ISessionService {

    @Nullable Session delete(@Nullable String id);

    @Nullable Session getNewSession(@Nullable String userId);

    void validate(@Nullable Session session) throws UncorrectSessionException;
}