package com.maersk.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/*
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
*/
import com.maersk.constant.ContainerType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table
public class Container {

	@PrimaryKey
	private UUID id;
	private ContainerType containerType; 
	private String origin;
	private String destination;
	private int quantity;
	private Date timestamp;

}
