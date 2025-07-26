# Sistema de Gestão de Viaturas - BeForward MZ

Este é um sistema de gestão de viaturas desenvolvido em Java com interface gráfica Swing para a BeForward Moçambique.

## 👥 Desenvolvedores

- **Dikshy Guinesh**
- **Hélder Junior**
- **Saymara Chambal**

## 📋 Sobre o Projeto

O sistema foi desenvolvido como trabalho prático da disciplina de Programação Orientada a Objetos II e oferece uma solução completa para gestão de clientes e operações relacionadas.

## ⚡ Funcionalidades

### 🔐 Sistema de Autenticação

- Login com diferentes tipos de usuários
- Cadastro de novos usuários
- Controle de acesso por perfil

### 👥 Gestão de Clientes

- Cadastro de clientes (Particular, Empresarial, Revendedor)
- Diferentes tipos de clientes com regras específicas
- Visualização de quantidade de clientes

### 💰 Operações Financeiras

- Cálculos de preços e impostos
- Relatórios financeiros
- Situação financeira
- Geração de recibos em PDF

### 🎵 Interface Rica

- Interface gráfica moderna com tema escuro
- Efeitos sonoros
- Ícones e imagens personalizados
- Animações e transições suaves

## 🛠️ Tecnologias Utilizadas

- **Java Swing** - Interface gráfica
- **iText PDF** - Geração de relatórios em PDF
- **Java I/O** - Manipulação de arquivos
- **Eclipse IDE** - Ambiente de desenvolvimento

## 📁 Estrutura do Projeto

```
src/
├── TelaLogin.java          # Tela de login principal
├── TelaMenu.java           # Menu principal do sistema
├── TelaDadosCarro.java     # Cadastro de veículos
├── Cliente.java            # Classe base para clientes
├── Carro.java              # Classe para veículos
├── Usuario.java            # Classe para usuários
├── Calculos.java           # Cálculos financeiros
├── GerarPDF.java           # Geração de relatórios PDF
└── ...                     # Outras classes e telas

lib/
└── itextpdf-5.5.13.jar    # Biblioteca para PDF

resources/
├── *.png                   # Ícones e imagens
├── *.wav                   # Efeitos sonoros
└── *.txt                   # Arquivos de dados
```

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 8 ou superior
- Eclipse IDE (recomendado)

### Passos para executar:

1. **Clone o repositório**

   ```bash
   git clone https://github.com/seu-usuario/POO2_TP2.git
   cd POO2_TP2
   ```

2. **Abra no Eclipse**

   - File → Import → Existing Projects into Workspace
   - Selecione a pasta do projeto

3. **Configure as dependências**

   - Certifique-se de que o arquivo `itextpdf-5.5.13.jar` está na pasta `lib/`
   - Adicione a biblioteca ao Build Path (clique direito no projeto → Properties → Java Build Path → Libraries → Add JARs)

4. **Execute**
   - Clique direito em `TelaLogin.java` → Run As → Java Application
   - Ou execute o arquivo `App.jar` diretamente

## 📊 Dados de Teste

O sistema utiliza arquivos de texto para armazenar dados:

- `DadosUsuarios.txt` - Usuários do sistema
- `DadosClientes.txt` - Informações dos clientes
- `DadosCarros.txt` - Catálogo de veículos

## 🎨 Interface

O sistema apresenta uma interface moderna com:

- Tema escuro profissional
- Cores da marca BeForward (laranja e preto)
- Ícones intuitivos
- Efeitos visuais
- Layout responsivo

## 📝 Funcionalidades Detalhadas

### Tipos de Cliente

- **Particular**: Clientes individuais
- **Empresarial**: Empresas
- **Revendedor**: Parceiros comerciais

### Operações Disponíveis

- ✅ Cadastro e login de usuários
- ✅ CRUD completo de veículos
- ✅ Gestão de clientes
- ✅ Cálculos automáticos de preços
- ✅ Relatórios em PDF
- ✅ Pesquisa e filtros avançados

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos como parte do curso de Programação Orientada a Objetos II.

## 🤝 Contribuições

Este é um projeto acadêmico, mas sugestões e melhorias são bem-vindas!

## 📞 Contato

Para dúvidas ou sugestões sobre o projeto, entre em contato com os desenvolvedores listados acima.

---

**Desenvolvido com ❤️ pelos estudantes do Instituto Superior de Ciências de Tecnologias de Moçambique**
