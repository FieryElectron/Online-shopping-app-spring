package org.javadev.app.neo4j;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Value;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class Neo4jDBService {

	private final Driver driver;

	Neo4jDBService(Driver driver) {

		this.driver = driver;

		try (Session session = this.driver.session()) {

			System.out.println("####################");
			System.out.println("####################");
			System.out.println("####################");

			String res = session.writeTransaction(tx -> {
				tx.run("MATCH (n) DETACH DELETE n");
				tx.run("" + "CREATE (p:p0{name:'Person11'})\n" + "CREATE (p1:Person100{name:'Person100'})\n");
				Result Res = tx.run("MATCH (n) RETURN (n)");

				for(Record r:Res.list()){
					System.out.println(r.get("n").get("name"));
				}

				return "result";
			});

			// System.out.println(res);
		}
	}

}
