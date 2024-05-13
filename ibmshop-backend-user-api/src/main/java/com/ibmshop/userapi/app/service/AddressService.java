package com.ibmshop.userapi.app.service;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
import com.ibmshop.userapi.app.mapper.AddressMapperImpl;
import com.ibmshop.userapi.cross.exception.ValidationItemExist;
import com.ibmshop.userapi.domain.entities.Address;
import com.ibmshop.userapi.domain.repositories.AddressRepository;
import com.ibmshop.userapi.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AddressService implements AddressInterface {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AddressRepository addressRepository;


    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressMapperImpl addressMapper;


    @Override
    @Transactional
    public List<AddressDtoOutput> findAll() {
        List<Address> addressList = addressRepository.findAll();

        List<AddressDtoOutput> addressDtoOutputsList = addressList.stream().map(addressMapper::entityToDtoAddress).collect(Collectors.toList());

        log.info("findAll Mapeamento entidade para Dto", addressDtoOutputsList);

        return addressDtoOutputsList;
    }

    @Override
    @Transactional
    public AddressDtoOutput findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);

        if (addressOptional.isEmpty()) {
            throw new EntityNotFoundException("Endereço não existe com este id");
        }
        AddressDtoOutput addressDtoOutput = addressMapper.entityToDtoAddress(addressOptional.get());

        log.info("findById Mapeamento entidade para Dto get{}", addressDtoOutput);

        return addressDtoOutput;
    }

    @Override

    @Transactional
    public List<AddressDtoOutput> findByIdUser(Long id) {

        List<Address> addressList = addressRepository.findByUserId(id);
        if (addressList.isEmpty()) {
            throw new EntityNotFoundException("Não encontrado endereço para este usuário");
        }
        List<AddressDtoOutput> addressDtoOutputList = addressList.stream().map(ad -> addressMapper.entityToDtoAddress(ad)).collect(Collectors.toList());


        log.info("findByIdUser Mapeamento entidade para Dto get{}", addressDtoOutputList);
        return addressDtoOutputList;
    }


    @Override
    @Transactional
    public Address insert(AddressDtoInsert addressDtoInsertObj) {

        List<Address> addressList = addressRepository.findByUserId(addressDtoInsertObj.getIdUser());


        Optional<Address> addressOptional = addressRepository.findByApelido(addressDtoInsertObj.getApelido());
        if (addressOptional.isPresent())

            throw new ValidationItemExist("Apelido", "Não foi possível cadastrar o endereço. Você já possui um endereço com esse apelido. Insira um apelido diferente e tente novamente.");

        if (addressList.isEmpty()) {

            addressDtoInsertObj.setPadrao(true);
        } else if (addressDtoInsertObj.getPadrao() == null || addressDtoInsertObj.getPadrao() == false) {
            addressDtoInsertObj.setPadrao(false);
        } else if (addressDtoInsertObj.getPadrao() == true) {

            for (Address address : addressList) {
                {

                    if (address.getPadrao() == true) {

                        address.setPadrao(false);
                    }

                }
            }

        }


        Address addressObj = addressMapper.dtoToEntityAddress(addressDtoInsertObj);

        log.info("INSERT Mapeamento DTO para entidade: {}", addressObj);

        return addressRepository.save(addressObj);
    }

    @Override
    @Transactional
    public void update(AddressDtoUpdate addressDtoUpdate, Long id) {
        Optional<Address> address = addressRepository.findById(id);

        List<Address> addressList = addressRepository.findByUserId(addressDtoUpdate.getIdUser());
        if (address.isEmpty())
            throw new EntityNotFoundException(
                    "Desculpe, não foi possível encontrar um  com endereço com este id. Verifique e tente novamente.");


        if (addressList.size() == 1 && addressDtoUpdate.getPadrao().equals(false)) {

            throw new EntityNotFoundException("Não pode mudar para false quando há apenas 1 item");

        } else if (addressList.size() > 1 && addressDtoUpdate.getPadrao() == true) {


            for (Address addressTrueActive : addressList) {
                if (addressTrueActive.getPadrao() == true) {
                    addressTrueActive.setPadrao(false);
                }


            }


        } else if (addressList.size() > 1 && addressDtoUpdate.getPadrao().equals(false)) {
            for (Address addressTrueActive : addressList) {
                if (addressTrueActive.getPadrao() == false) {
                    addressTrueActive.setPadrao(true);
                }


            }
        }


        Address addressUpdate = addressMapper.dtoToEntityAddress(addressDtoUpdate);


        addressRepository.save(addressUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException( "Endereço inexistente."));

        List<Address> addressList = addressRepository.findByUserId(id);

        if (address.getPadrao() == true) {

            for (Address addressInList : addressList) {
                if (address.getPadrao() == false) {

                    address.setPadrao(true);
                    break;
                }
            }
        }


        //Address address = addressMapper.dtoToEntityAddress(addressDtoOutput);

        addressRepository.delete(address);

    }
}

