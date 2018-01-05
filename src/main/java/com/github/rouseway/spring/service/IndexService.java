package com.github.rouseway.spring.service;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.rouseway.spring.mvc.MyConfigure;


//define your service at here, algorithm could be packaged at here in functions
@Service
public class IndexService {
	
	//this member should be defined as bean in "*-servlet.xml"
	@Autowired
	private PoolingHttpClientConnectionManager connectionManager;

	
	//your service function
	public String getStrFromService() throws Exception {
		return MyConfigure.greet + " " + MyConfigure.object;
	}
	
}
