package ru.egorza.servicecompany;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
public class CompanyController {

    private static Map<String, List<People>> mapCompany = new LinkedHashMap<>();


    @PostConstruct
    public void postConst(){

        People people = new People("Mark", "Director");

        mapCompany.put("APPLE", new ArrayList<>(Collections.singletonList(people)));

        people = new People("Den", "Director");
        mapCompany.put("INTEL", new ArrayList<>(Collections.singletonList(people)));

        people = new People("Tony", "Director");
        mapCompany.put("IBM", new ArrayList<>(Collections.singletonList(people)));
    }

    @GetMapping(value = "/getPeopleByNameCompany/{nameCompany}")
    public List<People> getPeopleByCompanyName(@PathVariable String nameCompany){
        if(mapCompany.containsKey(nameCompany.toUpperCase())){
            return mapCompany.get(nameCompany.toUpperCase());
        }
        return Collections.emptyList();
    }

    @GetMapping(value = "/getNameCompanies")
    public Set<String> getNameCompanies(){
        return mapCompany.keySet();
    }

}
