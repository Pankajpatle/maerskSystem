package com.maersk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.Exception.ValidateException;
import com.maersk.model.Container;
import com.maersk.model.ContainerBookingResponse;
import com.maersk.model.ContainerRequest;
import com.maersk.model.ContainerResponse;
import com.maersk.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	//for Save Method Controller
	@PostMapping("api/saveBookings")
	public ContainerResponse saveBooking(@RequestBody Container container) throws Exception {
		String status = validateContainer(container);
		
		if(status!=null || !status.equals("")) {
			
			throw new ValidateException(status);
		}
		
		System.out.println("Inside Controller Booking Save");
		return bookingService.saveBooking(container);
	}

	//for check available
	@PostMapping("api/bookings/checkAvailable")
	public ContainerBookingResponse  checkAvailable(@RequestBody ContainerRequest containerRequest) {
		String status = validateContainerRequest(containerRequest);
	 if(status!=null || !status.equals("")) {
			
			throw new ValidateException(status);
		}
		System.out.println("Inside Controller checkavailable");
		return bookingService.checkAvailable(containerRequest);
	}
	
	
	//1st endpoint
	@PostMapping("api/bookings")
	public String boo (@RequestBody ContainerRequest containerRequest) {
		System.out.println("Inside Controller checkavailable");
		return (String) bookingService.available(containerRequest);
	}
	
	
	private String  validateContainer(Container container) {
		String error ="";
		
		if(container !=null) {
			if(container.getContainerType()==null || container.getContainerType().equals("")) {
			 error = "please provide container type";
			 return error;
			}else if(container.getDestination()==null || container.getDestination().equals("")) {
				error = "please provide destination";
				 return error;
			}else if(container.getOrigin()==null || container.getOrigin().equals("")) {
				error = "please provide origin";
				 return error;
			}else if(container.getTimestamp()==null) {
				error = "please provide timestamp";
				 return error;
			}
		}
		return error;
	}
	
	
	private String  validateContainerRequest(ContainerRequest container) {
		String error ="";
		
		if(container !=null) {
			if(container.getContainerType()==null || container.getContainerType().equals("")) {
			 error = "please provide container type";
			 return error;
			}else if(container.getDestination()==null || container.getDestination().equals("")) {
				error = "please provide destination";
				 return error;
			}else if(container.getOrigin()==null || container.getOrigin().equals("")) {
				error = "please provide origin";
				 return error;
			}
		}
		return error;
	}
}
