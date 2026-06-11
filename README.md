## 📡 Endpoints

### Buscar cotação de uma criptomoeda

Retorna a cotação atual da criptomoeda informada em Real (BRL) e Dólar (USD).

#### Requisição

```http
GET /cripto/{moeda}
```

#### Parâmetros

| Parâmetro | Tipo   | Descrição                                 |
| --------- | ------ | ----------------------------------------- |
| moeda     | String | Identificador da criptomoeda na CoinGecko |

#### Exemplo

```http
GET /cripto/bitcoin
```

#### Resposta de Sucesso (200 OK)

```json
{
  "brl": 328012.0,
  "usd": 63033.0
}
```

---

### Códigos de Resposta

#### 200 OK

A cotação foi encontrada com sucesso.

```json
{
  "brl": 328012.0,
  "usd": 63033.0
}
```

#### 404 Not Found

A criptomoeda informada não foi encontrada.

```json
{
  "mensagem": "Criptomoeda não encontrada"
}
```

#### 429 Too Many Requests

O limite de requisições por IP foi excedido.

```json
{
  "mensagem": "Limite de requisições excedido"
}
```

#### 500 Internal Server Error

Ocorreu um erro interno na aplicação ou na comunicação com a API externa.

```json
{
  "mensagem": "Erro interno do servidor"
}
```

---

## ⚡ Cache

A aplicação utiliza Redis para armazenar temporariamente as cotações das criptomoedas.

* Tempo de cache: 5 minutos
* Redução de chamadas à API da CoinGecko
* Melhoria no desempenho das consultas

---

## 🛡️ Rate Limiting

Para evitar abuso da API e preservar a cota da CoinGecko, foi implementado rate limiting por IP utilizando Bucket4j.

Configuração atual:

* 10 requisições por minuto por IP
* Resposta HTTP 429 quando o limite é excedido

---

## 📝 Exemplo de Uso

### Requisição

```bash
curl http://localhost:8080/cripto/bitcoin
```

### Resposta

```json
{
  "brl": 328012.0,
  "usd": 63033.0
}
```

👨‍💻 Autor

Desenvolvido por GLADYSON GABRIEL BARBOSA DE FREITAS Linkedin: www.linkedin.com/in/gladyson-gabriel30
