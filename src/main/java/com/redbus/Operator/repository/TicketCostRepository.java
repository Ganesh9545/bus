package com.redbus.Operator.repository;

import com.redbus.Operator.entity.TicketCost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface TicketCostRepository  extends JpaRepository<TicketCost,Long> {
}
