package com.maersk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maersk.constant.BookingConstant;
import com.maersk.model.Container;
import com.maersk.model.ContainerBookingResponse;
import com.maersk.model.ContainerRequest;
import com.maersk.model.ContainerResponse;
import com.maersk.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BookingRepository bookingRepository;
	
    private BookingConstant bookingConstant;

	//For save Method
	public ContainerResponse saveBooking(Container container) {

		Container res = bookingRepository.save(container);
		ContainerResponse containerResponse = new ContainerResponse();
		containerResponse.setBookingRef(res.getId().toString());
		return containerResponse;
	}

	public ContainerBookingResponse checkAvailable(ContainerRequest containerRequest) {
		
		ContainerBookingResponse result = new ContainerBookingResponse();
		Map<String, Integer> map = new HashMap<>();
		map.put("available", 6);
		result.setCheck(map);
		System.out.println("Result====" + result);
		return result;
	}

	public String available(ContainerRequest containerRequest) {

		String uri = bookingConstant.URI;
		ContainerBookingResponse result = restTemplate.getForObject(uri, ContainerBookingResponse.class);		
		if(result.getCheck().get("available")==0) {
			return "“available”:false";
		}else {
			return "“available”:true";
		}
	}

}
