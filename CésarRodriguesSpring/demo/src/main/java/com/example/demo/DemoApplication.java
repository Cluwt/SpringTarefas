package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Conexão com o Redis usando suas credenciais
		Jedis jedis = new Jedis("redis://default:y0EirjDM0L323e8IJqbHK6VYqbzmjcOR@redis-10396.c308.sa-east-1-1.ec2.cloud.redislabs.com:10396");
		Connection connection = jedis.getConnection();

		// Define um usuário no formato JSON
		String user1 = "{nome:'Alessandro', usuario:'aleprofessor', senha:'666'}";

		// Realiza operações com o Redis
		connection.connect();
		jedis.set("User:1", user1);
		System.out.println(jedis.get("User:1"));
		jedis.del("User:1");
		System.out.println(jedis.get("User:1"));
		connection.close();
	}
}
