package com.example.pojectdemo.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController
{
    private  JobService service;

    public JobController(JobService service)
    {
        this.service = service;
    }

    @GetMapping("/urljob")
    public ResponseEntity<List<Job>>findall()
    {
        return new ResponseEntity<>(service.findall(),HttpStatus.OK);
    }
    @PostMapping("/urljob")
    public ResponseEntity<String> createjob(@RequestBody Job job)
    {
       service.createjob(job);
        return new ResponseEntity<>("Added Sucessfully",HttpStatus.OK);
    }
    @GetMapping("/urljob/{id}")
    public ResponseEntity<Job> getId(@PathVariable Long id) {
        Job job = service.getId(id);
        if (job!= null)
        {
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/urljob/{id}")
    public ResponseEntity<String> deletereq (@PathVariable Long id)
    {
        boolean deleted = service.deleteidreq(id);
        if(deleted)
        {
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("NotDeleted",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/urljob/{id}")
    public ResponseEntity<String>  updatejob(@PathVariable Long id,@RequestBody Job updatejob)
    {
        boolean Updated= service.updatejob(id,updatejob);
        if(Updated)
        {
            return new ResponseEntity<>("Updated sucessfully",HttpStatus.OK);

        }
        return new ResponseEntity<>("not updated",HttpStatus.NOT_ACCEPTABLE);
    }

}
