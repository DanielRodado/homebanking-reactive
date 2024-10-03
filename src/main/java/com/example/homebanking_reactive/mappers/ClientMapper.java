package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.ClientDTO;
import com.example.homebanking_reactive.models.ClientEntity;

public class ClientMapper {

    public static ClientDTO toClientDTO(ClientEntity clientEntity) {
        return new ClientDTO(clientEntity);
    }

   public static ClientEntity toClient(ClientApplicationDTO clientAppDTO) {
       return ClientEntity.builder()
               .name(clientAppDTO.name())
               .lastName(clientAppDTO.lastName())
               .email(clientAppDTO.email())
               .password(clientAppDTO.password())
               .build();
   }

}
