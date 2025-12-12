# Como Rodar a Aplicação Vinis Web

## Opção 1: Perfil de Desenvolvimento (H2 In-Memory - Sem MySQL)

Este é o modo mais rápido para testes, sem necessidade de configurar banco de dados externo.

### Comando para rodar:
```bash
mvn spring-boot:run
```

**Ou no Windows (usando PowerShell):**
```powershell
$env:SPRING_PROFILES_ACTIVE="prod"
.\mvnw.cmd spring-boot:run
```

**Características:**
- Usa banco H2 em memória
- Nenhuma configuração de banco de dados necessária
- Dados são perdidos ao reiniciar a aplicação
- Console H2 disponível em: `http://localhost:8081/h2-console`

---

## Opção 2: Perfil de Produção (MySQL)

Para usar com banco de dados MySQL (recomendado para persistência de dados).

### 1. Configurar o Banco de Dados MySQL

Primeiro, execute o script de criação do banco:

```bash
mysql -u root -p < CRIAR_BANCO_MYSQL.sql
```

Ou importe manualmente o arquivo `CRIAR_BANCO_MYSQL.sql` no seu cliente MySQL.

### 2. Configurar as Credenciais do Banco

Abra o arquivo: **`src/main/resources/application-prod.properties`**

Localize estas linhas e atualize conforme sua configuração:

```properties
# ============================================================
# MySQL Database Configuration - ALTERE AQUI
# ============================================================
spring.datasource.url=jdbc:mysql://localhost:3306/vaja?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

**Parâmetros a alterar:**
- `localhost` - endereço do servidor MySQL
- `3306` - porta do MySQL (padrão: 3306)
- `vaja` - nome do banco de dados
- `root` - usuário do MySQL
- `1234` - senha do MySQL

### 3. Comando para rodar com MySQL:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments='--spring.profiles.active=prod'
```

**Ou no Windows (usando PowerShell):**
```powershell
.\mvnw.cmd spring-boot:run -Dspring-boot.run.arguments='--spring.profiles.active=prod'
```

---

## Acessar a Aplicação

Após iniciar, acesse: **`http://localhost:8080`**

---

## Resumo dos Perfis

| Perfil | Comando | Banco | Configuração |
|--------|---------|-------|--------------|
| **Desenvolvimento (Padrão)** | `mvn spring-boot:run` | H2 In-Memory | Automática (sem config) |
| **Produção (MySQL)** | `mvn spring-boot:run -Dspring-boot.run.arguments='--spring.profiles.active=prod'` | MySQL | `application-prod.properties` |

---

## Troubleshooting

### Erro de conexão com MySQL
- Verifique se o MySQL está rodando
- Confirme as credenciais em `application-prod.properties`
- Verifique a porta MySQL (padrão: 3306)

### Porta 8080 já em uso
- Altere em `application.properties` ou `application-prod.properties`:
```properties
server.port=8081
```

### Maven não encontrado
- Use o wrapper: `.\mvnw.cmd` em vez de `mvn` no Windows
