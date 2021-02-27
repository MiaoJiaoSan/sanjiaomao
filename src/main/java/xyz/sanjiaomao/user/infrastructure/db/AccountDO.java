package xyz.sanjiaomao.user.infrastructure.db;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity(name = "account")
public class AccountDO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-uuid")
  @GenericGenerator(name = "custom-uuid", strategy = "xyz.sanjiaomao.user.infrastructure.db.IdentifierGenerator")
  private Long id;

  @Column
  private String username;

  @Column
  private String password;

  @Column
  private String nickname;

}
