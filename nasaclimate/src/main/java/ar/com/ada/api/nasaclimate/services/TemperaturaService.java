package ar.com.ada.api.nasaclimate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.nasaclimate.entities.Temperatura;
import ar.com.ada.api.nasaclimate.repositories.TemperaturaRepository;
@Service
public class TemperaturaService{

    @Autowired
    PaisService paisService;
    @Autowired
    TemperaturaRepository temperaturaRepository;

    public Temperatura cargarTemperatura(int codigoPais, int anioTemperatura, double grados) {

        Temperatura temperatura = new Temperatura();

        temperatura.setPais(paisService.buscarPorCodigoPais(codigoPais));
        temperatura.setAnioTemperatura(anioTemperatura);
        temperatura.setGrados(grados);

        temperaturaRepository.save(temperatura);

        return temperatura;

    }

    public List<Temperatura> listarTemperatura() {

        return temperaturaRepository.findAll();

    }

    public Temperatura buscarPorTemperaturaId(int temperaturaId){

        return temperaturaRepository.findByTemperaturaId(temperaturaId);

    } 

    public void actualizarEstadoTemperatura(Temperatura grados, int anioTemperatura){

        grados.setAnioTemperatura(anioTemperatura);

        temperaturaRepository.save(grados);

    }

    public void borrarTemperatura(Temperatura grados) {

        this.actualizarEstadoTemperatura(grados, 0);

    }



}