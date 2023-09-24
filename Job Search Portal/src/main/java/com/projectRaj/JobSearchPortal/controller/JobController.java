package com.projectRaj.JobSearchPortal.controller;

import com.projectRaj.JobSearchPortal.model.Job;
import com.projectRaj.JobSearchPortal.model.Type;
import com.projectRaj.JobSearchPortal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("api/jobs")
    public String addJobs(@RequestBody @Valid List<Job> jobs){
        return jobService.addJobs(jobs);
    }

    @GetMapping("api/job/id/{jobId}")
    public Object getJob(@PathVariable @Valid Long jobId){
        return jobService.getJob(jobId);
    }

    @PutMapping("api/job/id/{jobId}")
    public Object updateJob(@PathVariable @Valid Long jobId, @RequestBody @Valid Job newJobData){
        return jobService.updateJob(jobId,newJobData);
    }

    @DeleteMapping("api/job/id/{jobId}")
    public Object deleteJob(@PathVariable @Valid Long jobId){
        return jobService.deleteJob(jobId);
    }

    @GetMapping("api/custumFinder/jobsByType/{jobType}")
    public List<Job> getAllJobsByType(@RequestParam Type jobType){
        return jobService.getAllJobsByType(jobType);
    }

    @GetMapping("api/custumFinder/type/jobsBySalary/{salary}")
    public List<Job> getAllJobsByJobTypeAndSalaryGreaterThan(@RequestParam Type jobType,@PathVariable Double salary){
        return jobService.getAllJobsByJobTypeAndSalaryGreaterThan(jobType,salary);
    }

    @GetMapping("api/custumFinder/jobsByTitle/salary/{salary}")
    public List<Job> getAllJobsByTitleAndSalary(@RequestParam String jobTitle,@PathVariable Double salary){
        return jobService.getByTitleAndsalary(jobTitle,salary);
    }

    @GetMapping("api/custumFinder/companyByAppliedDate/{date}")
    public List<String> getAllCompanyNamesAppliedBeforeDate(@PathVariable String date){
        return jobService.getAllCompanyNamesAppliedBeforeDate(date);
    }

    @PutMapping("api/custumQuery/job/type/hike/{incPercentage}")
    public String updateSalaryByJobType(@RequestParam Type type , @PathVariable Float incPercentage){
        return jobService.updateSalaryByJobType(type,incPercentage);
    }
    @DeleteMapping("api/custumQuery/job/id/{jobId}")
    public String deleteByJobId(@PathVariable Long jobId){
        return jobService.deleteByJobId(jobId);
    }

    @GetMapping("api/custumQuery/job/title/description")
    public List<Job> searchJobsByTitleOrDescription(@RequestParam String title, @RequestParam String description) {
        return jobService.searchJobsByTitleOrDescription(title,description);
    }
}
