package library.app.spring.service;

import java.util.List;

import library.app.spring.entity.Rent;

public interface RentService {
    void add(Rent rent);

    List<Rent> listRents();
}
