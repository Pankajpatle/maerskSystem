package com.maersk.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.maersk.model.Container;

@Repository
public interface BookingRepository extends CassandraRepository<Container, UUID>{

}
