package xyz.sanjiaomao.user.infrastructure.db;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class UserDO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-uuid")
  @GenericGenerator(name = "custom-uuid", strategy = "xyz.sanjiaomao.user.infrastructure.db.IdentifierGenerator")
  private Long id;

  @Column
  private Long accountId;

  @Column
  private String name;

  @Column
  private Integer age;

  @Column
  private String gender;

  @Column
  private String idCard;

  @Column
  private String mobile;

  @Column
  private String email;
}
