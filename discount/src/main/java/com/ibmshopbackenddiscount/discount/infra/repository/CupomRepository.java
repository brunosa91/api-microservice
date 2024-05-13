package com.ibmshopbackenddiscount.discount.infra.repository;

import com.ibmshopbackenddiscount.discount.infra.entity.CupomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CupomRepository extends JpaRepository <CupomEntity,Long>{
//TODO FAZER IMPLEMENTAÇAO PARA RETORNO DO ORELSETHROW

    //TODO FAZER LOGS TBMM
    Optional<CupomEntity> findCupomByCodigo(String codigo);
}
