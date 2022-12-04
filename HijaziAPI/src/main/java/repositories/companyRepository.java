package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.company;

@Repository
public interface companyRepository extends JpaRepository<company,Integer> {

}
