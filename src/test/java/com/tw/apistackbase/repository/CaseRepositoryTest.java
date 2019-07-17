package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.CaseInfo;
import com.tw.apistackbase.entity.Procuratorate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaseRepositoryTest {
    @Autowired
    private CaseRepository caseRepository;

    @Test
    public void should_return_case_when_select_by_id() {
        //given
        int id=1;
        caseRepository.saveAndFlush(new Case("kill",1111L));
        caseRepository.saveAndFlush(new Case("fire",112211L));

        //when
        Case Acase=caseRepository.findById(id).get();
        //then
        Assertions.assertSame(1,Acase.getId());
    }

    @Test
    public void should_return_all_case() {
        //given
        caseRepository.saveAndFlush(new Case("kill",1111L));
        caseRepository.saveAndFlush(new Case("fire",112211L));

        //when
        List<Case> caseList=caseRepository.findAll();
        //then
        Assertions.assertSame(2,caseList.size());
    }

    @Test
    public void should_return_case_when_select_by_name() {
        //given
        String name="kill";
        caseRepository.saveAndFlush(new Case("kill",1111L));
        caseRepository.saveAndFlush(new Case("fire",112211L));

        //when
        Case Acase=caseRepository.findByName(name);
        //then
        Assertions.assertEquals("kill",Acase.getName());
    }

    @Test
    public void should_delete_case_by_id() {
        //given
        int id=1;
        caseRepository.saveAndFlush(new Case("kill",1111L));
        caseRepository.saveAndFlush(new Case("fire",112211L));

        //when
        caseRepository.deleteById(id);
        //then
        List<Case> caseList=caseRepository.findAll();
        Assertions.assertEquals(1,caseList.size());
    }

    @Test
    public void should_case_info_one_to_one_correspondence() {
        //given
        caseRepository.saveAndFlush(new Case("kill",1111L,new CaseInfo("kill","sharen")));
        caseRepository.saveAndFlush(new Case("fire",112211L,new CaseInfo("fire","fanghuo")));

        //when
        List<Case> caseList=caseRepository.findAll();
        //then
        Assertions.assertEquals("kill",caseList.get(0).getInfo().getSubjective());
    }

    @Test
    public void should_add_case_info_in_criminal_case() {
        //given
        Case ACase=new Case("kill",1111L,new CaseInfo("kill","sharen"));
        Case BCase=new Case("slander",1111L);

        //when
        caseRepository.saveAndFlush(ACase);
        caseRepository.saveAndFlush(BCase);

        //then
        List<Case> caseList=caseRepository.findAll();
        Assertions.assertEquals("kill",caseList.get(0).getInfo().getSubjective());
        Assertions.assertNull(caseList.get(1).getInfo());
    }

    @Test
    public void should_procuratorate_one_to_one_correspondence() {
        //given
        caseRepository.saveAndFlush(new Case("kill",1111L,new Procuratorate("didian1")));
        caseRepository.saveAndFlush(new Case("kill",1111L,new Procuratorate("didian2")));
        //when
        List<Case> caseList=caseRepository.findAll();
        //then
        Assertions.assertEquals("didian1",caseList.get(0).getProcuratorate().getName());
    }

    @Test
    public void should_add_procuratorate_in_criminal_case() {
        //given
        Case case1=new Case("kill",1111L,new Procuratorate("didian1"));

        //when
        caseRepository.saveAndFlush(case1);

        //then
        List<Case> caseList=caseRepository.findAll();
        Assertions.assertEquals("didian1",caseList.get(0).getProcuratorate().getName());
    }
}