package com.tesis.clasificacionanimalesapi.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.tesis.clasificacionanimalesapi.model.Clasificacion;

public interface ClasificacionRepository extends CosmosRepository<Clasificacion, String> {

}
