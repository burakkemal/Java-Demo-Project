package kodlama.io.RentACar.entities.concretes;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Table(name = "cars")
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "daily_price")
    private Double dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
