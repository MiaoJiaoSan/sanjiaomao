package xyz.sanjiaomao.auth.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;


public class TraceConverterConfig extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent event) {
    return event.getMDCPropertyMap().getOrDefault("traceId","system");
  }
}
