package ar.com.ada.api.nasaclimate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.com.ada.api.nasaclimate.entities.Temperatura;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {

    public Temperatura findByTemperaturaId(int temperaturaId);
}