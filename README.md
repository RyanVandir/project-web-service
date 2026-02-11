# 🚀 Project Web Services  
### Spring Boot • JPA • Hibernate • Arquitetura Hexagonal

API REST desenvolvida em **Java 21 + Spring Boot**, criada como **projeto de estudo e prática avançada de backend**.

Este projeto foi inspirado no workshop do professor **Nélio Alves**:

🔗 Repositório base:  
https://github.com/acenelio/workshop-springboot4-jpa  

A partir da base do curso, o projeto foi **reestruturado e evoluído** com foco em:

- Aplicação de **Arquitetura Hexagonal (Ports and Adapters)**
- Separação entre **Domain e Entity**
- Implementação explícita de **Use Cases**
- Mapeamento com **MapStruct**
- Organização voltada para escalabilidade

> 🎯 Este projeto não é apenas um CRUD — é um laboratório de arquitetura e boas práticas.

---

# Objetivo do Projeto

Consolidar conhecimentos em:

- Spring Boot
- JPA / Hibernate
- Modelagem de domínio
- Relacionamentos complexos
- Tratamento global de exceções
- Perfil de ambiente (test)
- Evolução da arquitetura tradicional (resource/service/repository) para **Arquitetura Hexagonal**

---

# 🏗️ Arquitetura Aplicada

O projeto foi estruturado com base na **Arquitetura Hexagonal**, promovendo baixo acoplamento e alta testabilidade.

### 🔄 Fluxo da Aplicação

Controller (Adapter In)

↓

Port In

↓

UseCase

↓

Port Out

↓

Adapter Out (Repository)

↓

Banco de Dados

### 🔑 Princípios Aplicados

- SOLID
- Inversão de Dependência
- Clean Architecture
- Separation of Concerns
- Ports and Adapters Pattern

O **domínio não depende de Spring, JPA ou banco de dados**.

---

# 🛠️ Ferramentas

| Tecnologia | Versão |
|------------|--------|
| Java | 21 |
| Spring Boot | 4.0.1 |
| Spring Web MVC | |
| Spring Data JPA | |
| Hibernate | via JPA |
| MapStruct | 1.5.5 |
| Lombok | 1.18.34 |
| H2 | Desenvolvimento/Teste |
| Maven | Build Tool |

---

# 📦 Funcionalidades

## 👤 Users
- POST `/users`
- GET `/users`
- GET `/users/{id}`
- PUT `/users/{id}`
- DELETE `/users/{id}`

## 📦 Orders
- GET `/orders`
- GET `/orders/{id}`
- DELETE `/orders/{id}`

## 🏷️ Categories
- POST `/categories`
- GET `/categories`
- GET `/categories/{id}`

## 🛍️ Products
- POST `/products`
- GET `/products`
- GET `/products/{id}`

---

# 🗄️ Modelagem de Domínio

Relacionamentos implementados:

- `User` → OneToMany → `Order`
- `Order` → ManyToMany → `Product` (via `OrderItem`)
- `Product` → ManyToMany → `Category`
- `Order` → OneToOne → `Payment`
- Enum `OrderStatus`
- Métodos de cálculo de subtotal e total

Modelagem baseada no workshop do Prof. Nélio Alves, com evolução estrutural na arquitetura.

---

# 🧠 Principais Aprendizados

Durante o desenvolvimento foram praticados:

- Dependency Injection
- Tratamento global de exceções
- Profile (test)
- Separação entre Domain e Persistence
- Mapeamento performático com MapStruct
- Estrutura preparada para crescimento
- Organização de código orientada a arquitetura

---

# 🧪 Ambiente

### 🔹 Desenvolvimento / Teste
- H2 Database (em memória)
- Console disponível em:
http://localhost:8080/h2-console

---

# Diferenciais do Projeto

✔ Baseado em curso referência do mercado

✔ Evoluído com Arquitetura Hexagonal

✔ Domínio desacoplado do framework

✔ Separação clara entre regra de negócio e infraestrutura

✔ Estrutura escalável e profissional
