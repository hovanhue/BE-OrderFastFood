package com.example.hue.services;

import com.example.hue.models.dto.ChartStatistical;
import com.example.hue.models.dto.OrderDTO;
import com.example.hue.models.dto.StatisticByDate;
import com.example.hue.models.dto.StatisticByProduct;
import com.example.hue.models.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    OrderDTO save(OrderDTO orderDTO);

    OrderDTO update(OrderDTO orderDTO);

    Page<OrderDTO> getByUserId(Long id, Integer page, Integer size);

    OrderDTO getById(Long id);

    Page<OrderDTO> getAll(Integer page, Integer size);

    List<Order> statisticByDate(StatisticByDate statisticByDate);

    List<Order> statisticByProduct(StatisticByProduct statisticByProduct);

    List<ChartStatistical> setPerformanceWithChartList();

    List<ChartStatistical> totalsOfUses();
}
