package com.comtrade.Comtrade.Service;

import com.comtrade.Comtrade.Model.LangModel;
import com.comtrade.Comtrade.Repository.LangRepository;
import org.apache.commons.codec.language.bm.Lang;
import org.h2.command.dml.MergeUsing;
import org.hibernate.mapping.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class LangServiceTest {
    LangService langService = new LangService();
    LangModel lang = new LangModel(1,"Serbian","Zdravo svete");
    LangModel lang1 = new LangModel(2,"Blabla2","blala");
    LangModel lang2 = new LangModel(3,"Blabla3","blala");
    LangModel lang3 = new LangModel(4,"Blabla4","blala");
    LangModel lang4 = new LangModel(5,"Blabla5","blala");
    LangModel lang5 = new LangModel(6,"Blabla6","blala");
    LangModel lang6 = new LangModel(7,"Blabla7","blala");
    LangModel lang7 = new LangModel(8,"Blabla8","blala");
    LangModel lang8 = new LangModel(9,"Blabla9","blala");
    LangModel lang9 = new LangModel(10,"Blabla10","blala");
    LangRepository repo = Mockito.mock(LangRepository.class);
    @Test
    void save() {
        langService.langRepo = repo;
        repo.save(lang);
        assertEquals("Serbian",lang.getCountry());
    }

    @Test
    void getByParam() {
        langService.langRepo = repo;
        String para = "Serbian";
        ArrayList<LangModel> lista = new ArrayList<LangModel>();
        lista.add(lang);
        Iterable<LangModel> iterable = lista;
        when(repo.findAll()).thenReturn(iterable);
        assertEquals("Zdravo svete",langService.getByParam(para));
    }
    @Test
    void getByParamFail() {
        langService.langRepo = repo;
        String para = "Serbianx";
        ArrayList<LangModel> lista = new ArrayList<LangModel>();
        lista.add(lang);
        Iterable<LangModel> iterable = lista;
        when(repo.findAll()).thenReturn(iterable);
        assertEquals("Not Found",langService.getByParam(para));
    }

    @Test
    public void getAll()
    {
        langService.langRepo = repo;
        ArrayList<LangModel> lista = new ArrayList<LangModel>();
        lista.add(lang);
        lista.add(lang1);
        lista.add(lang2);
        lista.add(lang3);
        lista.add(lang4);
        lista.add(lang5);
        lista.add(lang6);
        lista.add(lang7);
        lista.add(lang8);
        lista.add(lang9);
        Iterable<LangModel> iterable = lista;
        when(repo.findAll()).thenReturn(iterable);
        assertEquals(10, langService.getAll().size());

    }
    @Test
    public void getAllFail()
    {
        langService.langRepo = repo;
        ArrayList<LangModel> lista = new ArrayList<LangModel>();
        Iterable<LangModel> iterable = lista;
        when(repo.findAll()).thenReturn(iterable);
        assertEquals(1, langService.getAll().size());
    }
}