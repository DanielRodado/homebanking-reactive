package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.models.ClientModel;

import java.util.Set;

public class ClientMapper {

   public static ClientModel toClient(ClientApplicationDTO clientAppDTO) {
       return ClientModel.builder()
               .name(clientAppDTO.name())
               .lastName(clientAppDTO.lastName())
               .email(clientAppDTO.email())
               .password(clientAppDTO.password())
               .build();
   }

   public static ClientDTO toClientDTO(ClientModel client, Set<AccountDTO> accountDTOS) {
       return new ClientDTO(client, accountDTOS);
   }

}
