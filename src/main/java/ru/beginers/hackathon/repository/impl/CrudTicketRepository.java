package ru.beginers.hackathon.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.beginers.hackathon.model.Ticket;

import javax.transaction.Transactional;
import java.util.List;

public interface CrudTicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> getAllByUserId(int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);


    @Query("SELECT m FROM Meal m JOIN FETCH m.user WHERE m.id = ?1 and m.user.id = ?2")
    Ticket getWithUser(@Param("id") int id, @Param("userId") int userId);
}