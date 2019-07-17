package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.Procurator;
import com.tw.apistackbase.entity.Procuratorate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void should_contain_procurator_when_select_procuratorate() {
        //given
        List<Procurator> procuratorList=new ArrayList<>();
        procuratorList.add(new Procurator("panda"));
        procuratorList.add(new Procurator("milo"));

        procuratorateRepository.saveAndFlush(new Procuratorate("diandi1",procuratorList));
        procuratorateRepository.saveAndFlush(new Procuratorate("diandi2",procuratorList));

        //when
        List<Procuratorate> procuratorateList=procuratorateRepository.findAll();
        //then
        Assertions.assertEquals("panda",procuratorateList.get(0).getProcuratorList().get(0).getName());
        Assertions.assertEquals("milo",procuratorateList.get(1).getProcuratorList().get(1).getName());

    }
}
