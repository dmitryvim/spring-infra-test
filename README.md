# spring-infra-test

## local run

Start

```bash
docker compose -f stack.yml rm
docker compose -f stack.yml up
./gradlew bootRun
```

Connect to DB
```bash
psql -h localhost -p 5432 -d dima -U dima -W
```

test my entity
```bash
curl -X POST http://localhost:8080/ent -H 'Content-Type: application/json' -d '{"id":"8f1bde2d-a455-4257-90e9-169458dae77f", "name":"as", "value":12}'
curl http://localhost:8080/ent/8f1bde2d-a455-4257-90e9-169458dae77f
```