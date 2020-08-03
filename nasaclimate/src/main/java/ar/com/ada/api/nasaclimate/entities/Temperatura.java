package ar.com.ada.api.nasaclimate.entities;

@Entity
@Table(name = "temperatura")
public class Temperatura{

    @Id
    @Column (name = "temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdTemperatura;
    @Column (name = "anio_temperatura")
    private int anioTemperatura;
    private Double grados;

    @ManyToOne
    @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais")
    @JsonIgnore
    private Pais pais;



   

}