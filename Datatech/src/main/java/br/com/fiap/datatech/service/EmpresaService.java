package br.com.fiap.datatech.service;

import br.com.fiap.datatech.dto.EmpresaDTO;
import br.com.fiap.datatech.entity.Empresa;
import br.com.fiap.datatech.repository.EmpresaRepository;
import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        // Configurando o ModelMapper para mapear explicitamente os campos
        modelMapper.typeMap(EmpresaDTO.class, Empresa.class)
                .addMappings(mapper -> {
                    mapper.map(EmpresaDTO::getNomeEmpresa, Empresa::setNomeEmpresa);
                    mapper.map(EmpresaDTO::getNomeFantasia, Empresa::setNomeFantasia);
                    mapper.map(EmpresaDTO::getCnpj, Empresa::setCnpj);
                });
        modelMapper.typeMap(Empresa.class, EmpresaDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Empresa::getNomeEmpresa, EmpresaDTO::setNomeEmpresa);
                    mapper.map(Empresa::getNomeFantasia, EmpresaDTO::setNomeFantasia);
                    mapper.map(Empresa::getCnpj, EmpresaDTO::setCnpj);
                });
    }

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
