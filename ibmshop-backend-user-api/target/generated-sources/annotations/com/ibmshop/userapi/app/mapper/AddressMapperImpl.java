package com.ibmshop.userapi.app.mapper;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.input.CountryDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.output.CountryDtoOutput;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
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
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDtoOutput entityToDtoAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDtoOutput addressDtoOutput = new AddressDtoOutput();

        addressDtoOutput.setIdUser( addressUserId( address ) );
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
        addressDtoOutput.setUser( userEntityToUserDtoOutput( address.getUser() ) );
        addressDtoOutput.setCountry( countryEntityToCountryDtoOutput( address.getCountry() ) );

        return addressDtoOutput;
    }

    @Override
    public Address dtoToEntityAddress(AddressDtoInsert addressDtoInsert) {
        if ( addressDtoInsert == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( addressDtoInsertToUserEntity( addressDtoInsert ) );
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
        address.setCountry( countryDtoInsertToCountryEntity( addressDtoInsert.getCountry() ) );

        return address;
    }

    @Override
    public Address dtoToEntityAddress(AddressDtoOutput addressDtoOutput) {
        if ( addressDtoOutput == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( addressDtoOutputToUserEntity( addressDtoOutput ) );
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
        address.setCountry( countryDtoOutputToCountryEntity( addressDtoOutput.getCountry() ) );

        return address;
    }

    @Override
    public Address dtoToEntityAddress(AddressDtoUpdate addressDtoUpdate) {
        if ( addressDtoUpdate == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( addressDtoUpdateToUserEntity( addressDtoUpdate ) );
        address.setCountry( addressDtoUpdateToCountryEntity( addressDtoUpdate ) );
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

        return address;
    }

    private Long addressUserId(Address address) {
        if ( address == null ) {
            return null;
        }
        UserEntity user = address.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<AddressDtoOutput> addressListToAddressDtoOutputList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDtoOutput> list1 = new ArrayList<AddressDtoOutput>( list.size() );
        for ( Address address : list ) {
            list1.add( entityToDtoAddress( address ) );
        }

        return list1;
    }

    protected UserDtoOutput userEntityToUserDtoOutput(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDtoOutput userDtoOutput = new UserDtoOutput();

        userDtoOutput.setId( userEntity.getId() );
        userDtoOutput.setNome( userEntity.getNome() );
        userDtoOutput.setSobrenome( userEntity.getSobrenome() );
        userDtoOutput.setCpf( userEntity.getCpf() );
        userDtoOutput.setEmail( userEntity.getEmail() );
        userDtoOutput.setTelefone( userEntity.getTelefone() );
        userDtoOutput.setAtivo( userEntity.getAtivo() );
        userDtoOutput.setData_criacao( userEntity.getData_criacao() );
        userDtoOutput.setData_modificacao( userEntity.getData_modificacao() );
        userDtoOutput.setAddress( addressListToAddressDtoOutputList( userEntity.getAddress() ) );

        return userDtoOutput;
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

    protected UserEntity addressDtoInsertToUserEntity(AddressDtoInsert addressDtoInsert) {
        if ( addressDtoInsert == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( addressDtoInsert.getIdUser() );

        return userEntity;
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

    protected UserEntity addressDtoOutputToUserEntity(AddressDtoOutput addressDtoOutput) {
        if ( addressDtoOutput == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( addressDtoOutput.getIdUser() );

        return userEntity;
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

    protected UserEntity addressDtoUpdateToUserEntity(AddressDtoUpdate addressDtoUpdate) {
        if ( addressDtoUpdate == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( addressDtoUpdate.getIdUser() );

        return userEntity;
    }

    protected CountryEntity addressDtoUpdateToCountryEntity(AddressDtoUpdate addressDtoUpdate) {
        if ( addressDtoUpdate == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setId( addressDtoUpdate.getIdCountry() );

        return countryEntity;
    }
}
