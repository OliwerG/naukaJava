package pl.kurs.carservice.service.engine.impl;

import org.springframework.stereotype.Service;
import pl.kurs.carservice.dao.EngineRepository;
import pl.kurs.carservice.models.Engine;
import pl.kurs.carservice.service.engine.EngineService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngineServiceImpl implements EngineService {

    private final EngineRepository engineRepository;
    private Engine engine;

    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public void addEngine(Engine engine) {
        engineRepository.save(engine);
    }

    @Override
    public void deleteEngine(Engine engine) {
        engine.setCar(Collections.emptyList());
        engineRepository.save(engine);
        engineRepository.delete(engine);
    }

    @Override
    public void deleteEngineById(Long id) {
        Engine e1 = engineRepository.findById(id).get();
        engineRepository.delete(e1);
    }

    @Override
    public void upgradeEngine(Engine engine) {
        engineRepository.save(engine);
    }

    @Override
    public Engine getEngine(Long id) {
        return engineRepository.findById(id).get();
    }

    @Override
    public List<Engine> getAllEngines() {
        List<Engine> engineList = new ArrayList<>();
        engineRepository.findAll().forEach(engineList::add);
        return engineList;
    }

    @Override
    public List<Engine> sortEnginesByHorsePower(List<Engine> engineList) {
        return engineList.stream()
                .sorted(Comparator.comparingInt(Engine::getPowerHp))
                .collect(Collectors.toList());
    }

    @Override
    public List<Engine> filterEnginesByHorsePower(List<Engine> engineList, int horsePower) {
        return engineList.stream()
                .filter(engine -> engine.getPowerHp() >= horsePower)
                .collect(Collectors.toList());
    }
}
