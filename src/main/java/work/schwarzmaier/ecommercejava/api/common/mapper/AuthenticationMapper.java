package work.schwarzmaier.ecommercejava.api.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import work.schwarzmaier.ecommercejava.api.authentication.AuthenticationRespones;
import work.schwarzmaier.ecommercejava.service.authentication.common.AuthenticationResult;

@Mapper
public interface AuthenticationMapper {

    AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);

    AuthenticationRespones toRespones(AuthenticationResult authenticationResult);
}
