package com.maersk.model;

import java.util.Map;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ContainerBookingResponse {
	
	private Map<String,Integer> check;

}
