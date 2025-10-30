package com.bradesco.hbtn;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

public class UsuarioOperations {

    public static void main(String[] args) {
        MongoDBConnection connection = new MongoDBConnection();
        MongoDatabase database = connection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("usuarios");

        collection.drop();

        Usuario u1 = new Usuario("Alice", 25);
        Usuario u2 = new Usuario("Bob", 30);
        Usuario u3 = new Usuario("Charlie", 35);
        collection.insertMany(Arrays.asList(u1.toDocument(), u2.toDocument(), u3.toDocument()));
        System.out.println("Registros inseridos.");

        System.out.println("\n📋 Registros após inserção:");
        collection.find().forEach(doc -> System.out.println(Usuario.fromDocument(doc)));

        Bson filtroBob = Filters.eq("nome", "Bob");
        Bson atualizacaoIdade = Updates.set("idade", 32);
        collection.updateOne(filtroBob, atualizacaoIdade);
        System.out.println("\n🔄 Idade de Bob atualizada para 32.");

        System.out.println("\n📋 Registros após atualização:");
        collection.find().forEach(doc -> System.out.println(Usuario.fromDocument(doc)));

        Bson filtroCharlie = Filters.eq("nome", "Charlie");
        collection.deleteOne(filtroCharlie);
        System.out.println("\n❌ Registro de Charlie removido.");

        System.out.println("\n📋 Registros finais:");
        collection.find().forEach(doc -> System.out.println(Usuario.fromDocument(doc)));

        connection.closeConnection();
    }
}
