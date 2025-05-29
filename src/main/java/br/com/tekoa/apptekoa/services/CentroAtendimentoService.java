package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.repositories.CentroAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroAtendimentoService {

    @Autowired
    private CentroAtendimentoRepository centroAtendimentoRepository;

}
