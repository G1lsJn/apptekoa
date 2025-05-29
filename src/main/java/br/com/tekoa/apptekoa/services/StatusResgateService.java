package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.repositories.StatusResgateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusResgateService {

    @Autowired
    private StatusResgateRepository statusResgateRepository;
}
