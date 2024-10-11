package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.models.ClientModel;

import java.util.HashSet;
import java.util.List;

public class ClientMapper {

   public static ClientModel toClient(ClientApplicationDTO clientAppDTO) {
       return ClientModel.builder()
               .name(clientAppDTO.name())
               .lastName(clientAppDTO.lastName())
               .email(clientAppDTO.email())
               .password(clientAppDTO.password())
               .build();
   }

   public static ClientDTO toClientDTO(ClientModel client, List<AccountDTO> accountDTOS) {
       return new ClientDTO(client, new HashSet<>(accountDTOS));
   }

}
