package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.repositories.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

}
