package library.app.spring.dao;

import java.util.List;

import library.app.spring.entity.Rent;

public interface RentDao {
    void add(Rent rent);

    List<Rent> listRents();
}
