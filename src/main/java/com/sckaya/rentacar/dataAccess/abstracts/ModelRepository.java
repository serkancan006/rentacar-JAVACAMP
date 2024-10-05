package com.sckaya.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sckaya.rentacar.Entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}

