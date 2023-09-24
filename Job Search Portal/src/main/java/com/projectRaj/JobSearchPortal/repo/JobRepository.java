package com.projectRaj.JobSearchPortal.repo;

import com.projectRaj.JobSearchPortal.model.Job;
import com.projectRaj.JobSearchPortal.model.Type;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

    List<Job> findByJobType(Type jobType);
    
    List<Job> findByJobTypeAndSalaryGreaterThanEqual(Type jobType, Double salary);

    List<Job> findByTitleAndSalaryGreaterThanEqual(String jobTitle, Double salary);

    List<Job> findByAppliedDateBefore(String date);

    @Modifying
    @Query(value = "UPDATE Job job SET job.salary = job.salary + (job.salary * (:incrementPercentage)) WHERE job.job_type = :type", nativeQuery = true)
    void updateSalaryByType(@Param("type") String type, @Param("incrementPercentage") Float incrementPercentage);

    @Modifying
    @Query(value = "DELETE FROM Job job WHERE job.id = :jobId" ,nativeQuery = true)
    void deleteJobById(@Param("jobId") Long jobId);

    List<Job> findByTitleContainingOrDescriptionContaining(String title, String description);
}
