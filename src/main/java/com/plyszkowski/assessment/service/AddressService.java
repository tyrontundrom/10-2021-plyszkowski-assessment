package com.plyszkowski.assessment.service;

import com.plyszkowski.assessment.model.Address;
import com.plyszkowski.assessment.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address getById(Long id) {
        return addressRepository.getById(id);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }


    public Address editAddress(Address address) {
        Address editAddress = addressRepository.getById(address.getId());
        editAddress.setStreet(address.getStreet());
        editAddress.setHouseNumber(address.getHouseNumber());
        editAddress.setPostalCode(address.getPostalCode());
        editAddress.setCity(address.getCity());
        return addressRepository.save(editAddress);
    }
}
