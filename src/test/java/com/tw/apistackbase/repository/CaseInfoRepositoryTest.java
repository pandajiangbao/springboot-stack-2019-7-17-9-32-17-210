package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.CaseInfo;
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
public class CaseInfoRepositoryTest {
    @Autowired
    private CaseInfoRepository caseInfoRepository;

    @Test
    public void should_return_case_info_when_select_by_id() {
        //given
        int id=1;
        caseInfoRepository.saveAndFlush(new CaseInfo("kill","sharen"));
        caseInfoRepository.saveAndFlush(new CaseInfo("fire","fanghuo"));

        //when
        CaseInfo caseInfo=caseInfoRepository.findById(id).get();
        //then
        Assertions.assertSame(1,caseInfo.getId());
    }

//    @Test
//    public void should_return_all_case() {
//        //given
//        caseRepository.saveAndFlush(new Case("kill",1111L));
//        caseRepository.saveAndFlush(new Case("fire",112211L));
//
//        //when
//        List<Case> caseList=caseRepository.findAll();
//        //then
//        Assertions.assertSame(2,caseList.size());
//    }

//    @Test
//    public void should_return_case_when_select_by_name() {
//        //given
//        String name="kill";
//        caseRepository.saveAndFlush(new Case("kill",1111L));
//        caseRepository.saveAndFlush(new Case("fire",112211L));
//
//        //when
//        Case Acase=caseRepository.findByName(name);
//        //then
//        Assertions.assertEquals("kill",Acase.getName());
//    }
//
//    @Test
//    public void should_delete_case_by_id() {
//        //given
//        int id=1;
//        caseRepository.saveAndFlush(new Case("kill",1111L));
//        caseRepository.saveAndFlush(new Case("fire",112211L));
//
//        //when
//        caseRepository.deleteById(id);
//        //then
//        List<Case> caseList=caseRepository.findAll();
//        Assertions.assertEquals(1,caseList.size());
//    }
}