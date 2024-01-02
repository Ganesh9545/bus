package com.redbus.user.Service;

import com.redbus.Operator.entity.BusOperator;
import com.redbus.Operator.repository.BusOperatorRepository;
import com.redbus.user.payload.BusListDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchBusesService {

    private BusOperatorRepository busOperatorRepository;

    public SearchBusesService(BusOperatorRepository busOperatorRepository) {
        this.busOperatorRepository = busOperatorRepository;
    }

    public List<BusListDto> searchBusBy(String departureCity , String arrivalCity, Date departureDate){
        List<BusOperator> busesAvailable = busOperatorRepository.findByDepartureCityAndArrivalCityAndDepartureDate(departureCity, arrivalCity, departureDate);
        List<BusListDto> busListDto = busesAvailable.stream().map(busOperator -> mapToDto(busOperator)).collect(Collectors.toList());
   return busListDto;
    }


  BusListDto mapToDto(BusOperator busOperator){
        BusListDto busListDto=new BusListDto();
        busListDto.setBusId(busOperator.getBusId());
        busListDto.setBusNumber(busOperator.getBusNumber());
        busListDto.setBusType(busListDto.getBusType());
        busListDto.setAmenities(busListDto.getAmenities());
        busListDto.setArrivalDate(busOperator.getArrivalDate());
        busListDto.setDepartureDate(busOperator.getDepartureDate());
        busListDto.setArrivalCity(busOperator.getArrivalCity());
        busListDto.setDepartureCity(busOperator.getDepartureCity());
        busListDto.setArrivalTime(busOperator.getArrivalTime());
        busListDto.setDepartureTime(busOperator.getDepartureTime());
        busListDto.setNumberSeats(busOperator.getNumberSeats());
        busListDto.setBusOperatorCompanyName(busOperator.getBusOperatorCompanyName());
        return busListDto;

    }

}
