package com.projectRaj.JobSearchPortal.service;

import com.projectRaj.JobSearchPortal.model.Job;
import com.projectRaj.JobSearchPortal.model.Type;
import com.projectRaj.JobSearchPortal.repo.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    //=======================CRUD Repository Methods===============================
    //Create -----> C
    public String addJobs(List<Job> jobs) {
        jobRepository.saveAll(jobs);
        return jobs.size() +" Jobs added into repository";
    }

    // Read -----> R
    public Object getJob(Long jobId) {
        Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            return job;
        }
        String errorMsg = "Job with id " + jobId + " not found";
        return errorMsg;
    }


    //Update -----> U
    public Object updateJob(Long jobId, Job newJobData) {
        Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            jobRepository.save(newJobData);
            return "Job data updated of this id : "+jobId;
        }
        String errorMsg = "Job with id " + jobId + " not found";
        return errorMsg;
    }

    //Delete -----> D
    public Object deleteJob(Long jobId) {
        Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            jobRepository.deleteById(jobId);
            return "Job data deleted of id : "+jobId;
        }
        String errorMsg = "Job with id " + jobId + " not found";
        return errorMsg;
    }

    //=======================Custom Finders===============================
    public List<Job> getAllJobsByType(Type jobType) {
        return jobRepository.findByJobType(jobType);
    }
    public List<Job> getAllJobsByJobTypeAndSalaryGreaterThan(Type jobType,Double salary) {
        return jobRepository.findByJobTypeAndSalaryGreaterThanEqual(jobType,salary);
    }


    public List<Job> getByTitleAndsalary(String jobTitle, Double salary) {
        return jobRepository.findByTitleAndSalaryGreaterThanEqual(jobTitle,salary);
    }

    public List<String> getAllCompanyNamesAppliedBeforeDate(String date) {
        List<String> companies = new ArrayList<>(); // Initialize the list

        List<Job> jobs = jobRepository.findByAppliedDateBefore(date);

        for (Job job : jobs) {
            companies.add(job.getCompanyName());
        }
        return companies;
    }

    //=======================Custom Queries===============================
    @Transactional
    public String updateSalaryByJobType(Type type, Float incPercentage) {
        jobRepository.updateSalaryByType(type.name(),incPercentage);
        return "Salaries updated of this type : "+type;
    }

    @Transactional
    public String deleteByJobId(Long jobId) {
        Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            jobRepository.deleteJobById(jobId);
            return "Job data deleted of id : "+jobId;
        }
        String errorMsg = "Job with id " + jobId + " not found";
        return errorMsg;
    }

    public List<Job> searchJobsByTitleOrDescription(String title, String description) {
        return jobRepository.findByTitleContainingOrDescriptionContaining(title, description);
    }
}


