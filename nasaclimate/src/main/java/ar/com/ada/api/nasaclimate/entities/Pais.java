package ar.com.ada.api.nasaclimate.entities;

@Entity
public class Pais{

    private String codigoPais;
    private String nombre;
    
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Temperatura> temperaturas;





}