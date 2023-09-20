package com.company.company.repository;

import com.company.company.dao.ProfessionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalInfoRepository extends JpaRepository<ProfessionalInfo,Integer> {
}
