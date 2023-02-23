package pl.kurs.carservice.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kurs.carservice.models.Engine;

import java.util.List;

public interface EngineRepository extends CrudRepository<Engine, Long> {

    List<Engine> getByPowerHp(short powerHp);
}
