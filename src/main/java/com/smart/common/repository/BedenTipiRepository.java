package com.smart.common.repository;

import java.util.List;

import com.smart.common.domain.beden.BedenTipi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "bedenTipis")
interface BedenTipiRepository extends JpaRepository<BedenTipi, Long> {
    @RestResource(path = "adiStartsWith", rel = "adiStartsWith")
    public List<BedenTipi> findAllByAdi(@Param("adi") String adi);
}