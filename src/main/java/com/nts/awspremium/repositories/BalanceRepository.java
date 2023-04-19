package com.nts.awspremium.repositories;

import com.nts.awspremium.model.Admin;
import com.nts.awspremium.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance,Long> {
    @Query(value = "Select * from balance where round((UNIX_TIMESTAMP()-time/1000)/60/60/24)<=10 order by time desc",nativeQuery = true)
    public List<Balance> getAllBalance();
    @Query(value = "Select * from balance where user=?1 and round((UNIX_TIMESTAMP()-time/1000)/60/60/24)<=10 order by time desc",nativeQuery = true)
    public List<Balance> getAllBalance(String user);
}
