package com.bio.time.domain.irepository;

import java.util.Optional;

public interface ILogsRepository {
    Optional<Integer> getId(String user);

}
