package com.comtrade.Comtrade.Repository;

import com.comtrade.Comtrade.Model.LangModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LangRepository extends CrudRepository<LangModel, String> {

}
