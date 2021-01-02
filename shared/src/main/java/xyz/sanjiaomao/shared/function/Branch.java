package xyz.sanjiaomao.shared.function;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-02 03:36
 */
public interface Branch {

  boolean test();

  default void trueAndThen(Consumer consumer) {
    if (test()) {
      consumer.accept();
    }
  }

  default void falseAndThen(Consumer consumer) {
    if (!test()) {
      consumer.accept();
    }
  }


}
