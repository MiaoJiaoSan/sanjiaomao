package xyz.sanjiaomao.user.interfaces.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.application.cmd.opt.SaveActCmd;
import xyz.sanjiaomao.user.interfaces.dto.AccountDTO;

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


  SaveActCmd convert(AccountDTO dto);
}
