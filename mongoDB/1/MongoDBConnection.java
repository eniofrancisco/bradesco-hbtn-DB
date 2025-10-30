package com.bradesco.hbtn;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private static final String USERNAME = "eniofrancisco_db_user";
    private static final String PASSWORD = "LsAqrkBSrCMlfZ5Z";
    private static final String CLUSTER_URL = "cluster0.qcvc7l9.mongodb.net";
    private static final String DATABASE_NAME = "Cluster0";

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnection() {
        try {
            String connectionString = String.format(
                "mongodb+srv://%s:%s@%s/?retryWrites=true&w=majority&appName=%s",
                USERNAME, PASSWORD, CLUSTER_URL, DATABASE_NAME
            );

            ConnectionString connString = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .build();

            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase(DATABASE_NAME);

            System.out.println("Conexão estabelecida com sucesso ao MongoDB!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexão encerrada com sucesso.");
        }
    }
}
