package com.ibmshop.userapi.app.mapper;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.input.CountryDtoInsert;
import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.output.CountryDtoOutput;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
import com.ibmshop.userapi.app.dto.update.UserDtoUpdate;
import com.ibmshop.userapi.domain.entities.Address;
import com.ibmshop.userapi.domain.entities.CountryEntity;
import com.ibmshop.userapi.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-30T16:20:13-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity dtoToEntity(UserDtoInsert dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setNome( dto.getNome() );
        userEntity.setSobrenome( dto.getSobrenome() );
        userEntity.setCpf( dto.getCpf() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setTelefone( dto.getTelefone() );
        userEntity.setAtivo( dto.getAtivo() );
        userEntity.setData_criacao( dto.getData_criacao() );
        userEntity.setData_modificacao( dto.getData_modificacao() );
        userEntity.setAddress( addressDtoInsertListToAddressList( dto.getAddress() ) );

        return userEntity;
    }

    @Override
    public UserEntity dtoToEntityUpdate(UserDtoOutput dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setNome( dto.getNome() );
        userEntity.setSobrenome( dto.getSobrenome() );
        userEntity.setCpf( dto.getCpf() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setTelefone( dto.getTelefone() );
        userEntity.setAtivo( dto.getAtivo() );
        userEntity.setData_criacao( dto.getData_criacao() );
        userEntity.setData_modificacao( dto.getData_modificacao() );
        userEntity.setAddress( addressDtoOutputListToAddressList( dto.getAddress() ) );

        return userEntity;
    }

    @Override
    public UserEntity dtoToEntityUpdateUser(UserDtoUpdate dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setNome( dto.getNome() );
        userEntity.setSobrenome( dto.getSobrenome() );
        userEntity.setCpf( dto.getCpf() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setTelefone( dto.getTelefone() );
        userEntity.setAtivo( dto.getAtivo() );
        userEntity.setData_criacao( dto.getData_criacao() );
        userEntity.setData_modificacao( dto.getData_modificacao() );
        userEntity.setAddress( addressDtoUpdateListToAddressList( dto.getAddress() ) );

        return userEntity;
    }

    @Override
    public UserDtoOutput entityToDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDtoOutput userDtoOutput = new UserDtoOutput();

        userDtoOutput.setId( entity.getId() );
        userDtoOutput.setNome( entity.getNome() );
        userDtoOutput.setSobrenome( entity.getSobrenome() );
        userDtoOutput.setCpf( entity.getCpf() );
        userDtoOutput.setEmail( entity.getEmail() );
        userDtoOutput.setTelefone( entity.getTelefone() );
        userDtoOutput.setAtivo( entity.getAtivo() );
        userDtoOutput.setData_criacao( entity.getData_criacao() );
        userDtoOutput.setData_modificacao( entity.getData_modificacao() );
        userDtoOutput.setAddress( addressListToAddressDtoOutputList( entity.getAddress() ) );

        return userDtoOutput;
    }

    protected CountryEntity countryDtoInsertToCountryEntity(CountryDtoInsert countryDtoInsert) {
        if ( countryDtoInsert == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setId( countryDtoInsert.getId() );
        countryEntity.setNome( countryDtoInsert.getNome() );
        countryEntity.setCodigo( countryDtoInsert.getCodigo() );

        return countryEntity;
    }

    protected Address addressDtoInsertToAddress(AddressDtoInsert addressDtoInsert) {
        if ( addressDtoInsert == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDtoInsert.getId() );
        address.setPadrao( addressDtoInsert.getPadrao() );
        address.setApelido( addressDtoInsert.getApelido() );
        address.setRua( addressDtoInsert.getRua() );
        address.setNumero( addressDtoInsert.getNumero() );
        address.setCep( addressDtoInsert.getCep() );
        address.setComplemento( addressDtoInsert.getComplemento() );
        address.setBairro( addressDtoInsert.getBairro() );
        address.setCidade( addressDtoInsert.getCidade() );
        address.setEstado( addressDtoInsert.getEstado() );
        address.setUser( dtoToEntity( addressDtoInsert.getUser() ) );
        address.setCountry( countryDtoInsertToCountryEntity( addressDtoInsert.getCountry() ) );

        return address;
    }

    protected List<Address> addressDtoInsertListToAddressList(List<AddressDtoInsert> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDtoInsert addressDtoInsert : list ) {
            list1.add( addressDtoInsertToAddress( addressDtoInsert ) );
        }

        return list1;
    }

    protected CountryEntity countryDtoOutputToCountryEntity(CountryDtoOutput countryDtoOutput) {
        if ( countryDtoOutput == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setId( countryDtoOutput.getId() );
        countryEntity.setNome( countryDtoOutput.getNome() );
        countryEntity.setCodigo( countryDtoOutput.getCodigo() );

        return countryEntity;
    }

    protected Address addressDtoOutputToAddress(AddressDtoOutput addressDtoOutput) {
        if ( addressDtoOutput == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDtoOutput.getId() );
        address.setPadrao( addressDtoOutput.getPadrao() );
        address.setApelido( addressDtoOutput.getApelido() );
        address.setRua( addressDtoOutput.getRua() );
        address.setNumero( addressDtoOutput.getNumero() );
        address.setCep( addressDtoOutput.getCep() );
        address.setComplemento( addressDtoOutput.getComplemento() );
        address.setBairro( addressDtoOutput.getBairro() );
        address.setCidade( addressDtoOutput.getCidade() );
        address.setEstado( addressDtoOutput.getEstado() );
        address.setUser( dtoToEntityUpdate( addressDtoOutput.getUser() ) );
        address.setCountry( countryDtoOutputToCountryEntity( addressDtoOutput.getCountry() ) );

        return address;
    }

    protected List<Address> addressDtoOutputListToAddressList(List<AddressDtoOutput> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDtoOutput addressDtoOutput : list ) {
            list1.add( addressDtoOutputToAddress( addressDtoOutput ) );
        }

        return list1;
    }

    protected Address addressDtoUpdateToAddress(AddressDtoUpdate addressDtoUpdate) {
        if ( addressDtoUpdate == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDtoUpdate.getId() );
        address.setPadrao( addressDtoUpdate.getPadrao() );
        address.setApelido( addressDtoUpdate.getApelido() );
        address.setRua( addressDtoUpdate.getRua() );
        address.setNumero( addressDtoUpdate.getNumero() );
        address.setCep( addressDtoUpdate.getCep() );
        address.setComplemento( addressDtoUpdate.getComplemento() );
        address.setBairro( addressDtoUpdate.getBairro() );
        address.setCidade( addressDtoUpdate.getCidade() );
        address.setEstado( addressDtoUpdate.getEstado() );
        address.setUser( dtoToEntityUpdateUser( addressDtoUpdate.getUser() ) );

        return address;
    }

    protected List<Address> addressDtoUpdateListToAddressList(List<AddressDtoUpdate> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDtoUpdate addressDtoUpdate : list ) {
            list1.add( addressDtoUpdateToAddress( addressDtoUpdate ) );
        }

        return list1;
    }

    protected CountryDtoOutput countryEntityToCountryDtoOutput(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDtoOutput countryDtoOutput = new CountryDtoOutput();

        countryDtoOutput.setId( countryEntity.getId() );
        countryDtoOutput.setNome( countryEntity.getNome() );
        if ( countryEntity.getCodigo() != null ) {
            countryDtoOutput.setCodigo( countryEntity.getCodigo() );
        }

        return countryDtoOutput;
    }

    protected AddressDtoOutput addressToAddressDtoOutput(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDtoOutput addressDtoOutput = new AddressDtoOutput();

        addressDtoOutput.setId( address.getId() );
        addressDtoOutput.setPadrao( address.getPadrao() );
        addressDtoOutput.setApelido( address.getApelido() );
        addressDtoOutput.setRua( address.getRua() );
        addressDtoOutput.setNumero( address.getNumero() );
        addressDtoOutput.setCep( address.getCep() );
        addressDtoOutput.setComplemento( address.getComplemento() );
        addressDtoOutput.setBairro( address.getBairro() );
        addressDtoOutput.setCidade( address.getCidade() );
        addressDtoOutput.setEstado( address.getEstado() );
        addressDtoOutput.setUser( entityToDto( address.getUser() ) );
        addressDtoOutput.setCountry( countryEntityToCountryDtoOutput( address.getCountry() ) );

        return addressDtoOutput;
    }

    protected List<AddressDtoOutput> addressListToAddressDtoOutputList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDtoOutput> list1 = new ArrayList<AddressDtoOutput>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressDtoOutput( address ) );
        }

        return list1;
    }
}
