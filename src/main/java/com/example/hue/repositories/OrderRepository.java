package com.example.hue.repositories;

import com.example.hue.models.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByUserId(Long id, Pageable pageable);

    @Query(value = "select product.name, month(orders.date_created),quantity \n" +
            "from order_detail\n" +
            "inner join product on product.id = order_detail.product_id\n" +
            "inner join orders on orders.id = order_detail.order_id", nativeQuery = true)
    List<Order> statisticProductByMonth(String idCategory, String idProduct, String month);

    @Query(value = "select product.name, day(orders.date_created),quantity \n" +
            "from order_detail\n" +
            "inner join product on product.id = order_detail.product_id\n" +
            "inner join orders on orders.id = order_detail.order_id", nativeQuery = true)
    List<Order> statisticProductByDate(String idCategory, String idProduct, String month);

    @Query(value = "select product.name, year(orders.date_created),quantity \n" +
            "from order_detail\n" +
            "inner join product on product.id = order_detail.product_id\n" +
            "inner join orders on orders.id = order_detail.order_id", nativeQuery = true)
    List<Order> statisticProductByYear(String idCategory, String idProduct, String month);
}
