package com.project.Shoes.Service;

import com.project.Shoes.model.Province;
import com.project.Shoes.repository.ProvinceRepository;
import com.project.Shoes.service.ProvinceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class ProvinceServiceTest {
    private ProvinceService provinceService;
    private ProvinceRepository provinceRepositoryMock;
    private Province province;

    @BeforeAll
    public void setUp(){
        provinceRepositoryMock = mock(ProvinceRepository.class);
        provinceService = new ProvinceService(provinceRepositoryMock);
        province = new Province(1, null, null);
    }

    @Test
    public void addTest(){
        Mockito.when(provinceRepositoryMock.save(province)).thenReturn(province);
        Mockito.when(provinceRepositoryMock.findByDescription(province.getDescription())).thenReturn(null);

        ResponseEntity result = provinceService.add(province);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(province, result.getBody());
    }
}
