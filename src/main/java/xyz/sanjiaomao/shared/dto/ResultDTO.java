package xyz.sanjiaomao.shared.dto;

import lombok.Data;

@Data
public class ResultDTO {

  protected String message;

  protected Boolean result;

  public ResultDTO(Boolean result) {
    this.message = "";
    this.result = result;
  }

  public ResultDTO(String message, Boolean result) {
    this.message = message;
    this.result = result;
  }
}
