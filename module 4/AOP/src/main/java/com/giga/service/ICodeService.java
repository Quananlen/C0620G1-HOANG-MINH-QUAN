package com.giga.service;

import com.giga.entity.Code;

import java.util.List;

public interface ICodeService{
    Code findById(Integer id);
    void save(Code code);
    List<Code> findAllCodeByBookId(Integer id);
    List<Code> findAvailableCodeByBookId(Integer id);
}
