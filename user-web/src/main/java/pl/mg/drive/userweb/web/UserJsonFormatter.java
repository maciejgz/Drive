package pl.mg.drive.userweb.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import pl.mg.drive.userweb.dao.User;

import java.io.IOException;

//@JsonComponent
public class UserJsonFormatter {

    public static class Serializer extends JsonSerializer<User> {
        @Override
        public void serialize(User value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("name", value.getName());
            gen.writeEndObject();
        }
    }

    public static class Deserializer extends JsonDeserializer<User> {
        @Override
        public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            TreeNode treeNode = p.getCodec().readTree(p);
            TextNode name
                    = (TextNode) treeNode.get("name");
            User user = new User();
            user.setName(name.asText());
            return user;
        }
    }

}
