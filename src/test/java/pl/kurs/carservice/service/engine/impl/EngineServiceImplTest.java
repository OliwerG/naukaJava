package pl.kurs.carservice.service.engine.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import pl.kurs.carservice.dao.EngineRepository;
import pl.kurs.carservice.models.Engine;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@EnableWebSecurity
class EngineServiceImplTest {

    private final List<Engine> engineList = List.of(
            new Engine("3000cm", 256, 500),
            new Engine("2000cm", 215, 450),
            new Engine("4800cm", 625, 800),
            new Engine("6300cm", 510, 650)
    );
    private final List<Engine> expectedResult = List.of(
            new Engine("2000cm", 215, 450),
            new Engine("3000cm", 256, 500),
            new Engine("6300cm", 510, 650),
            new Engine("4800cm", 625, 800)
    );

    @Mock
    private EngineRepository engineRepository;

    @InjectMocks
    private EngineServiceImpl engineService;

    @Test
    void sortEnginesByHorsePower() {
        List<Engine> result = engineService.sortEnginesByHorsePower(engineList);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @WithMockUser(username = "user", password = "123", authorities = "USER")
    void filterEnginesByHorsePower() {
        Engine e1 = new Engine("4800cm", 625, 800);
        Engine e2 = new Engine("6300cm", 510, 650);

        List<Engine> expectedResult = List.of(e1, e2);

        List<Engine> result = engineService.filterEnginesByHorsePower(engineList, 500);

        Assertions.assertEquals(expectedResult, result);

    }
}