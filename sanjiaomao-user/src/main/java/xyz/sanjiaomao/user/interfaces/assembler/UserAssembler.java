package xyz.sanjiaomao.user.interfaces.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.application.cmd.opt.SaveUserCmd;
import xyz.sanjiaomao.user.interfaces.dto.SaveUserDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-29 13:19
 */
@Mapper(componentModel = "spring")
public interface UserAssembler {

  SaveUserCmd convert(SaveUserDTO dto);
}
