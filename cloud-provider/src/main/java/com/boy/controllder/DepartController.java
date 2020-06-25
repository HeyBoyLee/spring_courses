package com.boy.controllder;

import com.boy.bean.Depart;
import com.boy.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {
  @Autowired
  DepartService departService;

  @PostMapping("/save")
  public boolean saveHandler(@RequestBody Depart depart){
    return departService.saveDepart(depart);
  }

  @DeleteMapping("del/{id}")
  public boolean delHandler(@PathVariable("id") Integer id){
    return departService.removeDepartById(id);
  }

  @PutMapping("/update")
  public boolean updateHandler(@RequestBody Depart depart){
    return departService.modifyDepart(depart);
  }

  @GetMapping("/get/{id}")
  public Depart getHandler(@PathVariable("id") Integer id){
    return departService.getDepartById(id);
  }

  @GetMapping("/list")
  public List<Depart> getAllHandler(){
    return departService.listAllDeparts();
  }
}
