package com.harsh.jobportal;


import com.harsh.jobportal.modal.JobPost;
import com.harsh.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "frontend url-url")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobposts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @PostMapping("addjob")
    public JobPost addJob(@RequestBody  JobPost jobPost){
            service.addJob(jobPost);
       return service.getJobById(jobPost.getPostId());
    }

    @GetMapping("job/{id}")
    public JobPost getJobById(@PathVariable int id){
        System.out.println(id);
        return service.getJobById(id);
    }

    @PutMapping("addjob")
    public void updateJob(@RequestBody JobPost job ){
        service.updateJob(job);

    }

    @DeleteMapping("job/{id}")
    public String deleteJob(@PathVariable int id){
        service.deleteJob(id);
        return "Deleted";

    }


}
