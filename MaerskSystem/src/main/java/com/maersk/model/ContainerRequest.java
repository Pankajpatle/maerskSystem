package com.maersk.model;

import com.maersk.constant.ContainerType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContainerRequest {
	

	private ContainerType containerType; 
	private int containerSize;
	private String origin;
	private String destination;
	private int quantity;

}
