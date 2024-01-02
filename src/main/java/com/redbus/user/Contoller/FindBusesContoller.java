package com.redbus.user.Contoller;

import com.redbus.Operator.entity.BusOperator;
import com.redbus.user.Service.SearchBusesService;
import com.redbus.user.payload.BusListDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class FindBusesContoller {

    private SearchBusesService searchBusesService;

    public FindBusesContoller(SearchBusesService searchBusesService) {
        this.searchBusesService = searchBusesService;
    }


    //http://localhost:8080/api/user/searchBuses?departureCity=CityA&arrivalCity=CityB&departureDate=2023-08-15
    @GetMapping("/searchBuses")
    public List<BusListDto> searchBy(@RequestParam("departureCity") String departureCity ,@RequestParam("arrivalCity")  String arrivalCity, @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate){
        List<BusListDto> busesSearchResult = searchBusesService.searchBusBy(departureCity, arrivalCity, departureDate);
        return  busesSearchResult;
    }

}
