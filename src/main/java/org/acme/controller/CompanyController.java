package org.acme.controller;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Company;
import org.acme.service.CompanyService;

import java.util.List;
import java.util.Optional;

@Path("/company")
public class CompanyController {

    @Inject
    CompanyService companyService;

    @POST
    @Transactional
    public Response saveUser(Company company){

        Optional<Company> savedCompany = companyService.saveCompany(company);

        if (savedCompany.isPresent()) {
            return Response.ok(savedCompany.get()).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    public Response findAllCompanies(){
        Optional<List<Company>> companies = companyService.getCompanies();
        if(companies.isPresent()){
            return Response.ok(companies).build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
