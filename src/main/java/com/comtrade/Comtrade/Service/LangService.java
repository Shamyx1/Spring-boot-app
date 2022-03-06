package com.comtrade.Comtrade.Service;

import com.comtrade.Comtrade.Model.LangModel;
import com.comtrade.Comtrade.Repository.LangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LangService {

    @Autowired
    private LangRepository langRepo;

    public LangService(){}

    public void save(LangModel model){
           langRepo.save(model);
    }


    public String getByParam(String param){
        try {
            Map<String, String> language = new HashMap<>();
            langRepo.findAll().forEach((LangModel model) -> {
                if (param.equals(model.getCountry()))
                    language.put(model.getCountry(), model.getWord());
            });
            if (language.size() == 0) {
                return "Not Found";
            }
            return language.get(param);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    public Map <String, String> getAll(){
        try {
            Map<String, String> language = new HashMap<>();
            langRepo.findAll().forEach((LangModel model) -> {
                language.put(model.getCountry(), model.getWord());
            });
            if (language.size() == 0) {
                language.put("Information", "Not Found");
            }
            return language;
        } catch (Exception ex) {
            Map<String, String> language = new HashMap<>();
            language.put("error", ex.getMessage());
            return language;
        }
    }

}
