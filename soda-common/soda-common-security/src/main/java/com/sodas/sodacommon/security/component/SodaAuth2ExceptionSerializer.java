package com.sodas.sodacommon.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sodas.sodacommon.core.constant.CommonConstants;
import com.sodas.sodacommon.security.exception.SodaAuth2Exception;
import lombok.SneakyThrows;

public class SodaAuth2ExceptionSerializer extends StdSerializer<SodaAuth2Exception> {

    public SodaAuth2ExceptionSerializer() {
        super(SodaAuth2Exception.class);
    }

    @Override
    @SneakyThrows
    public void serialize(SodaAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
        gen.writeStartObject();
        gen.writeObjectField("code", CommonConstants.FAIL);
        gen.writeStringField("msg", value.getMessage());
        gen.writeStringField("data", value.getErrorCode());
        gen.writeEndObject();
    }
}
