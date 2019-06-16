package org.emsi.jobapplications;


import java.io.IOException;
import java.text.ParseException;

import org.emsi.jobapplications.dao.others.ContextDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PfaComputingJobApplicationStudiesApplication 
{

	public static void main(String[] args) throws IOException, ParseException 
	{
		ContextDAO.ctx = SpringApplication.run(PfaComputingJobApplicationStudiesApplication.class, args);
	}
}
