package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.Procuratorate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProcuratorateRepositoryTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;
    @Test
    public void should_return_case_when_select_by_id() {
        //given
        int id=1;
        procuratorateRepository.saveAndFlush(new Procuratorate("diandi1"));
        procuratorateRepository.saveAndFlush(new Procuratorate("diandi2"));

        //when
        Procuratorate procuratorate=procuratorateRepository.findById(id).get();
        //then
        Assertions.assertSame(1,procuratorate.getId());
    }
}
