package CareNewgen.EmpManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CareNewgen.EmpManagement.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
