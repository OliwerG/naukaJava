package pl.kurs.carservice.controller;

import org.springframework.web.bind.annotation.*;
import pl.kurs.carservice.models.Engine;
import pl.kurs.carservice.service.engine.EngineService;

import java.util.List;

@RestController
@RequestMapping("/engines")
public class EngineController {
    private final EngineService engineService;

    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @PutMapping("/add")
    public void addEngine(@RequestBody Engine engine) {
        engineService.addEngine(engine);
    }

    @GetMapping("/getById")
    public Engine getEngineById(@RequestParam Long id) {
        return engineService.getEngine(id);
    }

    @DeleteMapping("/delete")
    public void deleteEngine(@RequestBody Engine engine) {
        engineService.deleteEngine(engine);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteEngineById(@PathVariable Long id) {
        engineService.deleteEngineById(id);
    }

    @GetMapping("/getAll")
    public List<Engine> getAllEngines() {
        return engineService.getAllEngines();
    }

    @PutMapping("/upgrade")
    public void upgradeEngine(@RequestBody Engine engine) {
        engineService.upgradeEngine(engine);
    }

}
