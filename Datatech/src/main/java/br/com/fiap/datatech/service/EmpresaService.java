package br.com.fiap.datatech.service;

import br.com.fiap.datatech.dto.EmpresaDTO;
import br.com.fiap.datatech.entity.Empresa;
import br.com.fiap.datatech.repository.EmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmpresaDTO> listarTodasEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream()
                .map(empresa -> modelMapper.map(empresa, EmpresaDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<EmpresaDTO> encontrarEmpresaPorId(Long empresaId) {
        Optional<Empresa> empresa = empresaRepository.findById(empresaId);
        return empresa.map(value -> modelMapper.map(value, EmpresaDTO.class));
    }

    public EmpresaDTO salvarEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
        empresa = empresaRepository.save(empresa);
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

    public void deletarEmpresa(Long empresaId) {
        empresaRepository.deleteById(empresaId);
    }
}
