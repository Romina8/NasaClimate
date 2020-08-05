package ar.com.ada.api.nasaclimate.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.api.nasaclimate.entities.Pais;
import ar.com.ada.api.nasaclimate.models.request.CreacionPaisRequest;
import ar.com.ada.api.nasaclimate.models.response.GenericResponse;
import ar.com.ada.api.nasaclimate.services.PaisService;

@RestController
public class PaisController{

    /*
     * POST /paises : que permita la creación de un país.
     * RequestBody:
     *  
     * {
     * “codigoPais”: 32, 
     * “nombre”: “Argentina” 
     * } 
     * 
     * */

    @Autowired
    PaisService paisService;

    @PostMapping("/paises")
    public ResponseEntity<GenericResponse> crearPais(@RequestBody CreacionPaisRequest pais){
 
       paisService.crearPais(pais.codigoPais, pais.nombre);
 
       GenericResponse resp = new GenericResponse();
       resp.isOk = true;
       resp.message = "Se agregó el país " + pais.nombre + " con éxito";
       resp.id = pais.codigoPais;
 
       return ResponseEntity.ok(resp);
    }

    /*
    * GET /paises : que devuelva la lista de países SIN las temperaturas.
    */

    @GetMapping("/paises")
    public ResponseEntity<List<Pais>> listarPaises(){

      return ResponseEntity.ok(paisService.listarPaises());
    }

    /*
    * GET /paises/{id} : que devuelva la info de un pais en particular(SIN las
    * temperaturas)
    */

    @GetMapping("/paises/{codigoPais}")
    public ResponseEntity<Pais> buscarPorCodigoPais(@PathVariable int codigoPais) {

      return ResponseEntity.ok(paisService.buscarPorCodigoPais(codigoPais));

    }

    /*
    * PUT /paises/{id} : que actualice solo el nombre del país. Usar un requestBody
    * que solo tenga el nombre del país.
    */

    @PutMapping("/paises/{codigoPais}")
    public ResponseEntity<GenericResponse> actualizarNombrePais(@PathVariable int codigoPais,@RequestBody String nombre) {

        Pais paisOriginal = paisService.buscarPorCodigoPais(codigoPais);

        if (paisOriginal != null) {
        
            paisService.actualizarNombrePais(paisOriginal, nombre);

            GenericResponse resp = new GenericResponse();
            resp.isOk = true;
            resp.message = "Se actualizó con éxito el nombre";
        
            return ResponseEntity.ok(resp);
    
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}