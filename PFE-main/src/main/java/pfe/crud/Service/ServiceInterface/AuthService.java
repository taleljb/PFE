package pfe.crud.Service.ServiceInterface;

import pfe.crudDTO.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}