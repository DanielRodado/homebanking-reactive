package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.ClientDTO;
import com.example.homebanking_reactive.models.ClientModel;

public class ClientMapper {

    public static ClientDTO toClientDTO(ClientModel clientEntity) {
        return new ClientDTO(clientEntity);
    }

   public static ClientModel toClient(ClientApplicationDTO clientAppDTO) {
       return ClientModel.builder()
               .name(clientAppDTO.name())
               .lastName(clientAppDTO.lastName())
               .email(clientAppDTO.email())
               .password(clientAppDTO.password())
               .build();
   }

}
