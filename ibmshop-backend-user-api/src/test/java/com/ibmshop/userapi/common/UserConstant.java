package com.ibmshop.userapi.common;

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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserConstant {
    private static final LocalDateTime DATA_CRIACAO = LocalDateTime.of(2023, 7, 23, 9, 1);

    private static final LocalDateTime DATA_ATUALIZACAO = LocalDateTime.of(2023, 9, 23, 9, 1);

    private static final List<Address> address = new ArrayList<>();
    private static final List<AddressDtoInsert> addressDtoInserts = new ArrayList<>();
    private static final List<AddressDtoOutput> addressDtoOut = new ArrayList<>();

    private static final List<AddressDtoUpdate> addressDtoUpdates = new ArrayList<>();

    public static  final UserEntity USER = new UserEntity(1L,"bruno","Santanta","85182468067","bruno@gmail.com","(11)98329-5158",true,DATA_CRIACAO,DATA_ATUALIZACAO, address);
    public static final CountryEntity COUNTRY_ENTITY = new CountryEntity(1L,"Brasil",55);

    public static final Address ADDRESS = new Address(1l,true,"Casa","guapé","11a","07150-020","C-B","alvorada","Guarulhos","SP",USER,COUNTRY_ENTITY);
    public static  final UserDtoInsert USER_DTO_INSERT = new UserDtoInsert(1L,"bruno","Santanta","85182468067","bruno@gmail.com","(11)98329-5158",true,DATA_CRIACAO,DATA_ATUALIZACAO, addressDtoInserts);


    public static  final UserDtoInsert USER_DTO_INSERT_WITH_ADDRESS = new UserDtoInsert(1L,"bruno","Santanta","85182468067","bruno@gmail.com","(11)98329-5158",true,DATA_CRIACAO,DATA_ATUALIZACAO, addressDtoInserts);

    public static  final UserDtoOutput USER_DTO_OUTPUT = new UserDtoOutput(1L,"bruno","Santanta","85182468067","bruno@gmail.com","(11)98329-5158",true,DATA_CRIACAO,DATA_ATUALIZACAO, addressDtoOut);

    public static  final UserDtoUpdate USER_DTO_UPDATE = new UserDtoUpdate(1L,"bruno","Santanta","85182468067","bruno@gmail.com","(11)98329-5158",true,DATA_CRIACAO,DATA_ATUALIZACAO, addressDtoUpdates);


    public static final CountryDtoOutput COUNTRY_DTO_OUTPUT = new CountryDtoOutput(1L,"Brasil",55);



    public static final AddressDtoOutput ADDRESS_DTO_OUTPUT = new AddressDtoOutput(1l,true,"Casa","guapé","11a","07150-020","C-B","alvorada","Guarulhos","SP",1l,USER_DTO_OUTPUT,COUNTRY_DTO_OUTPUT);

    public static final CountryDtoInsert COUNTRY_DTO_INSERT = new CountryDtoInsert(1L,"Brasil",55);

    public static final AddressDtoInsert ADDRESS_DTO_INSERT = new AddressDtoInsert(1l,true,"Casa","guapé","11a","07150-020","C-B","alvorada","Guarulhos","SP",1L,USER_DTO_INSERT,COUNTRY_DTO_INSERT);


    public static final AddressDtoUpdate ADDRESS_DTO_UPDATE = new AddressDtoUpdate(1l,true,"Casa","guapé","11a","07150-020","C-B","alvorada","Guarulhos","SP",1l,USER_DTO_UPDATE,1L);

}
