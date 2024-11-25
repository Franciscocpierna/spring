package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager en = enf.createEntityManager();
		
		// inseriu na base de dados as pessoas acima
		//en.getTransaction().begin();
		//en.persist(p1);
		//en.persist(p2);
		//en.persist(p3);
		//en.getTransaction().commit();
	
		//Pessoa p = en.find(Pessoa.class, 2); //esssa procura no banco
		//System.out.println(p); //imprime na tela
		
		//removendo do banco de dados
		
		Pessoa p = en.find(Pessoa.class, 2);
		en.getTransaction().begin();
		en.remove(p);
		en.getTransaction().commit();
		
		
		System.out.println("Pronto");
		en.clear();
		enf.close();
		
	}

}
