package com.tg.themeparkride.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tg.themeparkride.entity.ThemeParkRidesEntity;

@Repository
public interface ThemeParkRidesRepository extends CrudRepository<ThemeParkRidesEntity, Long> {
  List<ThemeParkRidesEntity> findByName(String name);
}

