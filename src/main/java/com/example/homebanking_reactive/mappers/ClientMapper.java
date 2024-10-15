package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.models.ClientModel;
import reactor.core.publisher.Mono;

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

   public static ClientDTO toClientDTO(ClientModel client) {
       return new ClientDTO(client);
   }

   public static Mono<ClientDTO> toClientDTOMono(ClientModel client) {
       return Mono.just(toClientDTO(client));
   };

}
