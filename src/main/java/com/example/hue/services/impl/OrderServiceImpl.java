package com.example.hue.services.impl;

import com.example.hue.common.converter.OrderConverter;
import com.example.hue.common.exception.ResourceNotFoundException;
import com.example.hue.models.dto.ChartStatistical;
import com.example.hue.models.dto.OrderDTO;
import com.example.hue.models.dto.StatisticByDate;
import com.example.hue.models.dto.StatisticByProduct;
import com.example.hue.models.entity.Order;
import com.example.hue.repositories.OrderRepository;
import com.example.hue.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderConverter orderConverter;

    private List<Order> statisticList;
    float daysBetweenBySearch = 0; //bien dem ngay sau khi search theo date or product
    SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // HH:mm:ss.SSSXXX
    SimpleDateFormat myTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderRepository.save(orderConverter.toEntity(orderDTO));
        return orderConverter.toDTO(order);
    }

    @Override
    public Page<OrderDTO> getByUserId(Long id, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Order> orderPage = orderRepository.findByUserId(id, paging);
        Page<OrderDTO> orderDtoPage = orderConverter.toPageDto(orderPage);
        return orderDtoPage;
    }

    @Override
    public OrderDTO getById(Long id) {
        Order order = orderRepository.getById(id);
        return orderConverter.toDTO(order);
    }

    @Override
    public Page<OrderDTO> getAll(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Order> orderPage = orderRepository.findAll(paging);
        Page<OrderDTO> orderDtoPage = orderConverter.toPageDto(orderPage);
        return orderDtoPage;
    }

    @Override
    public List<Order> statisticByDate(StatisticByDate statisticByDate) {
        return null;
    }

    @Override
    public List<Order> statisticByProduct(StatisticByProduct statisticByProduct) {
        if (statisticByProduct.getMonth() != null) {
            switch (statisticByProduct.getMonth()) {
                case "1":
                case "3":
                case "5":
                case "7":
                case "8":
                case "10":
                case "12":
                    daysBetweenBySearch = 31;
                    break;
                case "2":
                case "4":
                case "6":
                case "9":
                case "11":
                    daysBetweenBySearch = 30;
                    break;
                default:break;
            }
        } else {
            daysBetweenBySearch = 0;
        }

        if (statisticByProduct.getIdProduct() == null) {
            statisticByProduct.setIdProduct("");
        }
        if (statisticByProduct.getIdCategory() == null) {
            statisticByProduct.setIdCategory("");
        }
        if (statisticByProduct.getMonth() == null) {
            statisticByProduct.setMonth("");
        }
//        statisticList = orderRepository.statisticByProduct(
//                statisticByProduct.getIdCategory(),
//                statisticByProduct.getIdProduct(),
//                statisticByProduct.getMonth()
//        );
        return statisticList;
    }

    @Override
    public List<ChartStatistical> setPerformanceWithChartList() {
        return null;
    }

    @Override
    public List<ChartStatistical> totalsOfUses() {
        return null;
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Order order = orderRepository.findById(orderDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found with id :"));
        order.setStatus(orderDTO.getStatus());
        Order _order = orderRepository.save(order);

        return orderConverter.toDTO(_order);

    }
}
