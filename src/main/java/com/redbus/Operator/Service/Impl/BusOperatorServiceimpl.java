package com.redbus.Operator.Service.Impl;

import com.redbus.Operator.Service.BusOperatorService;
import com.redbus.Operator.entity.BusOperator;
import com.redbus.Operator.entity.TicketCost;
import com.redbus.Operator.payload.BusOperatorDto;
import com.redbus.Operator.repository.BusOperatorRepository;
import com.redbus.Operator.repository.TicketCostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BusOperatorServiceimpl implements BusOperatorService {


    private BusOperatorRepository busOperatorRepository;
    private TicketCostRepository ticketCostRepository;
    private ModelMapper modelMapper;

    public BusOperatorServiceimpl(BusOperatorRepository busOperatorRepository, TicketCostRepository ticketCostRepository, ModelMapper modelMapper) {
        this.busOperatorRepository = busOperatorRepository;
        this.ticketCostRepository = ticketCostRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BusOperatorDto scheduleBus(BusOperatorDto busOperatorDto) {
        BusOperator busOperator = mapToEntity(busOperatorDto);

        TicketCost ticketCost=new TicketCost();
        ticketCost.setTicketId(busOperatorDto.getTicketCost().getTicketId());
        ticketCost.setCost(busOperatorDto.getTicketCost().getCost());
        ticketCost.setCode(busOperatorDto.getTicketCost().getCode());
        ticketCost.setDiscountAmount(busOperatorDto.getTicketCost().getDiscountAmount());
        busOperator.setTicketCost(ticketCost);

        String busId = UUID.randomUUID().toString();
        busOperator.setBusId(busId);
        BusOperator savedBusSchedule = busOperatorRepository.save(busOperator);
       return   mapToDto(savedBusSchedule);

    }


    BusOperator mapToEntity( BusOperatorDto busOperatorDto){
        BusOperator busOperator=modelMapper.map(busOperatorDto,BusOperator.class);
        return busOperator;
    }

    BusOperatorDto mapToDto(BusOperator savedBusSchedule){
        BusOperatorDto busOperatorDto=modelMapper.map(savedBusSchedule,BusOperatorDto.class);
        return busOperatorDto;
    }


}
