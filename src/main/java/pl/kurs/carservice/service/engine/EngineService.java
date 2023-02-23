package pl.kurs.carservice.service.engine;

import pl.kurs.carservice.models.Engine;

import java.util.List;

public interface EngineService {
    void addEngine(Engine engine);

    void deleteEngine(Engine engine);

    void deleteEngineById(Long id);

    void upgradeEngine(Engine engine);

    Engine getEngine(Long id);

    List<Engine> getAllEngines();

    List<Engine> sortEnginesByHorsePower(List<Engine> engineList);

    List<Engine> filterEnginesByHorsePower(List<Engine> engineList, int horsePower);

}
