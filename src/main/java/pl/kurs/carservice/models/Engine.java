package pl.kurs.carservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String capcity;
    private int powerHp;
    private int powerNm;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engine")
    @JsonIgnore
    private List<Car> car;

    public Engine(String capcity, int powerHp, int powerNm) {
        this.capcity = capcity;
        this.powerHp = powerHp;
        this.powerNm = powerNm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return powerHp == engine.powerHp && powerNm == engine.powerNm && Objects.equals(id, engine.id) && Objects.equals(capcity, engine.capcity) && Objects.equals(car, engine.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capcity, powerHp, powerNm, car);
    }
}
