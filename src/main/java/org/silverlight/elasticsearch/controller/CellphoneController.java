package org.silverlight.elasticsearch.controller;

import org.silverlight.elasticsearch.model.CellPhone;
import org.silverlight.elasticsearch.service.CellphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by silverlight on 2020/4/26.
 *
 * @author silverlight
 * @date 2020/4/26 18:29
 */
@RestController
public class CellphoneController {

    @Autowired
    private CellphoneService cellphoneService;

    @ResponseBody
    @PostMapping("/cellphones")
    public String saveCellphone(@RequestBody CellPhone cellPhone){
        cellphoneService.save(cellPhone);
        return "success";
    }

    @ResponseBody
    @GetMapping("/cellphone/{id}")
    public CellPhone getById(@PathVariable("id") Long id){
        return cellphoneService.getById(id);
    }

    @ResponseBody
    @GetMapping("/cellphone/search/brand")
    public List<CellPhone> getByBrandLike(String brand){
        return cellphoneService.getByBrandLike(brand);
    }

    @ResponseBody
    @GetMapping("/cellphones")
    public List<CellPhone> getAll(){
        return cellphoneService.getAll();
    }

    @ResponseBody
    @GetMapping("/cellphones/fullsearch")
    public Page<CellPhone> fullSearch(String keyword){
        return cellphoneService.fullSearch(keyword);
    }

    @ResponseBody
    @PutMapping("/cellphones")
    public String update(@RequestBody CellPhone cellPhone){
        cellphoneService.update(cellPhone);
        return "success";
    }

    @ResponseBody
    @DeleteMapping("/cellphone/{id}")
    public String delete(@PathVariable("id") Long id){
        cellphoneService.deleteById(id);
        return "success";
    }
}
