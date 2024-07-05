package org.java.spring_boot_test4.db.repo;

import org.java.spring_boot_test4.db.pojo.ContoBancario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContoRepo extends JpaRepository<ContoBancario, Integer> {

}
