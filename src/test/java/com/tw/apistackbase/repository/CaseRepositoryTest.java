package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
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
}