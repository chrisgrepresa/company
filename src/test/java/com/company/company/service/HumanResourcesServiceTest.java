package com.company.company.service;

import com.company.company.dao.Worker;
import com.company.company.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HumanResourcesServiceTest {

    @InjectMocks
    HumanResourcesService humanResourcesService;

    @Mock
    ProfessionalInfoRepository professionalInfoRepository;

    @Mock
    WorkerJobRepository workerJobRepository;

    @Mock
    WorkerRepository workerRepository;

    @Mock
    GenderRepository genderRepository;

    @Mock
    ContractTypeRepository contractTypeRepository;

    @Test
    @DisplayName("Find All Workers Test") // Al darle al play saldrá esto debajo
    public void findAllWorkersTest(){
        String value = "value";
        List<Worker> workers = List.of(new Worker(1,"Paco", value, value,
                LocalDate.of(2023,9,19), value, value, value, value,
                value, value, value, value, 3, value));

        when(workerRepository.findAll()).thenReturn(workers); //método Mock instanciado
        humanResourcesService.findAllWorkers(); // el real?
        //aquí una aserción para ver que ha funcionado.
        assertEquals(1, humanResourcesService.findAllWorkers().size());
        assertEquals("Paco", humanResourcesService.findAllWorkers().get(0).getFirstName());

    }

    @Test
    public void deleteWorkerByIdTest(){
        //En la firma del método al ser test no se le pone Id
        Integer id = 1;
        humanResourcesService.deleteWorkerById(id);
        //minúscula porque es el objeto, ver InjectMocks.
        verify(workerRepository, times(1)).deleteById(id);
        //1 porque sólo se borra una vez, si fuera un bucle sería tantas veces como fuera correcto y
        // sabes que es el número en el que debe ejecutarse el bucle
        // 0 si quieres verificar que no se ha ejecutado.
    }

  
}