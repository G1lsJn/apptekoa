package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.repositories.ResgateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResgateService {

    @Autowired
    private ResgateRepository resgateRepository;

}
