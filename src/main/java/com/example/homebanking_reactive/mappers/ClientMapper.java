package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.models.ClientModel;

public class ClientMapper {

   public static ClientModel toClient(ClientApplicationDTO clientAppDTO) {
       return ClientModel.builder()
               .name(clientAppDTO.name())
               .lastName(clientAppDTO.lastName())
               .email(clientAppDTO.email())
               .password(clientAppDTO.password())
               .build();
   }

}
