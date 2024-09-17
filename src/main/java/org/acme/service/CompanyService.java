package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Company;
import org.acme.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CompanyService {

    @Inject
    CompanyRepository companyRepository;

    public Optional<Company> saveCompany(Company newCompany){

        try{

            companyRepository.persist(newCompany);
            int listSize =companyRepository.listAll().size();
            Company savedCompany = companyRepository.listAll().get(listSize - 1);
            return Optional.of(savedCompany);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<List<Company>> getCompanies(){
        return Optional.of(companyRepository.findAll().list());
    }
}
