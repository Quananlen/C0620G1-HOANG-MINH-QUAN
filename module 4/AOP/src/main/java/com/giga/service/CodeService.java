package com.giga.service;

import com.giga.entity.Code;
import com.giga.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CodeService implements ICodeService {
    @Autowired
    ICodeRepository codeRepository;

    @Override
    public Code findById(Integer id) {
        return codeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public List<Code> findAllCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_Id(id);
    }

    @Override
    public List<Code> findAvailableCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id, 1);
    }
}
