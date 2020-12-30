package xyz.sanjiaomao.user.interfaces.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.application.cmd.opt.AddRoleCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveActCmd;
import xyz.sanjiaomao.user.interfaces.dto.AddRoleDTO;
import xyz.sanjiaomao.user.interfaces.dto.SaveAccountDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:51
 */
@Mapper(componentModel = "spring")
public interface AccountAssembler {


  SaveActCmd convert(SaveAccountDTO dto);

  AddRoleCmd convert(AddRoleDTO dto);
}
