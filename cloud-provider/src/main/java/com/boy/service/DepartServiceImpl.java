package com.boy.service;

import com.boy.bean.Depart;
import com.boy.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
  @Autowired
  DepartRepository repository;

  @Override
  public boolean saveDepart(Depart depart) {
    Depart obj = repository.save(depart);
    return obj != null;
  }

  @Override
  public boolean removeDepartById(Integer id) {
    if(repository.existsById(id)){
      repository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public boolean modifyDepart(Depart depart) {
    Depart obj = repository.save(depart);
    return obj != null;
  }

  @Override
  public Depart getDepartById(Integer id) {
    if(repository.existsById(id)){
      return repository.getOne(id);
    }
    return new Depart();
  }

  @Override
  public List<Depart> listAllDeparts() {
    return repository.findAll();
  }
}
