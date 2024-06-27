package com.paule.banking_project.repositories;

import com.paule.banking_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //Select * from User where firstname = 'ali'
    List<User> findAllByFirstname(String firstname);

    //Select * from User where firstname like 'Ali'
    List<User> findAllByFirstnameContaining(String firstname);

    //Select * from User where firstname ilike 'ali'
    List<User> findAllByFirstnameContainingIgnoreCase(String firstname);

    //Select * from User where firstname= '%ali%' and email = 'poboneengouang@gmail.com'
    List<User> findAllByFirstnameContainingIgnoreCaseAndEmail(String firstname, String email);

    //Select * from User u inner join account a on u.id = a.id_user and a.iban = 'DE12345678'
    List<User> findAllByAccountIban(String iban);

    @Query("from User where firstname = :fn")
    List<User> searchByFirstname(@Param("fn") String firstname);

    @Query("from User where firstname = '%:firstname%'")
    List<User> searchByFirstnameContaining(@Param("fn") String firstname);

    @Query("from User u inner join Account a on u.id = a.user.id and a.iban = :iban")
    List<User> searchByIban(String iban);

    @Query(value = "select * from _user u inner join account a on u.id = a.id_user and a.iban = :iban", nativeQuery = true)
    List<User> searchByIbanNative(String iban);
}
