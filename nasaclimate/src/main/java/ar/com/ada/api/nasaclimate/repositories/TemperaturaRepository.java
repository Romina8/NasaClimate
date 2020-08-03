package ar.com.ada.api.nasaclimate.repositories;


import ar.com.ada.api.nasaclimate.entities.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Interer>{

}