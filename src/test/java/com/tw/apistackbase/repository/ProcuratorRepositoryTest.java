package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.Procurator;
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
public class ProcuratorRepositoryTest {
    @Autowired
    private ProcuratorRepository procuratorRepository;
    @Test
    public void should_return_Procurator_when_select_by_id() {
        //given
        int id=1;
        procuratorRepository.saveAndFlush(new Procurator("panda"));
        procuratorRepository.saveAndFlush(new Procurator("milo"));

        //when
        Procurator procurator=procuratorRepository.findById(id).get();
        //then
        Assertions.assertSame(1,procurator.getId());
    }
}
