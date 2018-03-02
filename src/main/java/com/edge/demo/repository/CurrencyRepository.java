package com.edge.demo.repository;

import com.edge.demo.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kelseyedge on 2/14/18.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
