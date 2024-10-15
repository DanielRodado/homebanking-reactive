package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.entities.ClientEntity;
import reactor.core.publisher.Mono;

public final class ClientMapper {

   public static ClientEntity toClient(ClientApplicationDTO clientAppDTO) {
       return ClientEntity.builder()
               .name(clientAppDTO.name())
               .lastName(clientAppDTO.lastName())
               .email(clientAppDTO.email())
               .password(clientAppDTO.password())
               .build();
   }

   public static ClientDTO toClientDTO(ClientEntity client) {
       return new ClientDTO(client);
   }

   public static Mono<ClientDTO> toClientDTOMono(ClientEntity client) {
       return Mono.just(toClientDTO(client));
   };

}
