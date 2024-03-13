package org.talent.talentpay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.talent.talentpay.entity.Users;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<Users, UUID> {

    Optional<Users> findUsersByPhoneNumber(String phoneNumber);

    Optional<Users> findUsersByMail(String mail);
}
