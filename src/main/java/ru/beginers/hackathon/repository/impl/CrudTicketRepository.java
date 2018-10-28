package ru.beginers.hackathon.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.beginers.hackathon.model.Ticket;

import java.util.List;
@Transactional
public interface CrudTicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> getAllByUserId(int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ticket t WHERE t.id=:id AND t.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);


    @Query("SELECT t FROM Ticket t JOIN FETCH t.user WHERE t.id = ?1 and t.user.id = ?2")
    Ticket getWithUser(@Param("id") int id, @Param("userId") int userId);
}