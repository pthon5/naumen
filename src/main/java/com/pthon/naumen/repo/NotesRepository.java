package com.pthon.naumen.repo;

import com.pthon.naumen.models.Notes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotesRepository extends CrudRepository<Notes, Long> {
    List<Notes> findAllByOrderByIdDesc();

    //search with date without search
    @Modifying
    @Query(value = "SELECT * FROM `notes` WHERE (`time` BETWEEN ?1 AND ?2) ORDER BY `id` DESC LIMIT ?3", nativeQuery = true)
    List<Notes> findByDate(String startDate, String endDate, int limit);

    //search with date with search
    @Modifying
    @Query(value = "SELECT * FROM `notes` WHERE (`time` BETWEEN ?1 AND ?2) AND `title` LIKE %?4% OR `content` LIKE %?4% ORDER BY `id` DESC LIMIT ?3", nativeQuery = true)
    List<Notes> findByDateAndSearch(String startDate, String endDate, int limit, String search);
}
