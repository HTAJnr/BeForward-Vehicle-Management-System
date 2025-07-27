# Sistema de Gestão de Viaturas - BeForward MZ

Este é um sistema de gestão de viaturas desenvolvido em Java com interface gráfica Swing para a BeForward Moçambique.

## 👥 Desenvolvedores

- **Dikshy Guinesh**
- **Hélder Junior**  
- **Saymara Chambal**

## 📋 Sobre o Projeto

O sistema foi desenvolvido como trabalho prático da disciplina de Programação Orientada a Objetos II (POO2) no Instituto Superior de Ciências de Tecnologias de Moçambique e oferece uma solução completa para gestão de clientes e viaturas.

## ⚡ Funcionalidades

### 🔐 Sistema de Autenticação
- Login com usuários pré-cadastrados
- Cadastro de novos usuários
- Controle de acesso por perfil
- Interface de autenticação moderna

### 👥 Gestão de Clientes
- Cadastro de diferentes tipos de clientes:
  - **Particular**: Clientes individuais
  - **Empresarial**: Empresas
  - **Revendedor**: Parceiros comerciais
- Visualização de quantidade de clientes por tipo
- Pesquisa e filtros avançados

### 🚗 Gestão de Viaturas
- Catálogo completo de veículos com:
  - Marca, modelo, cilindrada e preço
  - Múltiplas marcas (Toyota, Honda, Nissan, Mazda, BMW, Mercedes, etc.)
  - Informações detalhadas de cada veículo

### 💰 Operações Financeiras
- Cálculos automáticos de preços e impostos
- Diferentes cálculos baseados no tipo de cliente
- Relatórios financeiros detalhados
- Situação financeira por cliente
- Geração de recibos em PDF

### 🎨 Interface Rica
- Interface gráfica moderna com tema escuro
- Cores da marca BeForward (laranja e preto)
- Ícones intuitivos e personalizados
- Efeitos visuais e animações
- Layout profissional

## 🛠️ Tecnologias Utilizadas

- **Java SE** - Linguagem principal
- **Java Swing** - Interface gráfica
- **iText PDF 5.5.13** - Geração de relatórios em PDF
- **Java I/O** - Manipulação de arquivos de dados
- **Eclipse IDE** - Ambiente de desenvolvimento integrado

## 📁 Estrutura do Projeto

```
TP2_POO2_BeForward/
├── .classpath                      # Configuração do classpath do Eclipse
├── .project                        # Arquivo de projeto do Eclipse
├── .settings/                      # Configurações do Eclipse
├── .git/                          # Controle de versão Git
├── .metadata/                     # Metadados do workspace Eclipse
├── bin/                           # Arquivos compilados (.class)
│   ├── model/                     # Classes do modelo compiladas
│   ├── util/                      # Classes utilitárias compiladas
│   └── view/                      # Classes da interface compiladas
├── lib/                           # Bibliotecas externas
│   └── itextpdf-5.5.13.jar      # Biblioteca para geração de PDF
├── resources/                     # Recursos do sistema
│   ├── audio/                     # Efeitos sonoros
│   │   └── moveee.wav
│   ├── data/                      # Arquivos de dados
│   │   ├── DadosCarros.txt       # Catálogo de veículos
│   │   ├── DadosClientes.txt     # Informações dos clientes
│   │   └── DadosUsuarios.txt     # Usuários do sistema
│   └── images/                    # Ícones e imagens da interface
│       ├── BeForward_LOGO.png
│       ├── *.png                 # Diversos ícones da interface
│       └── ...
└── src/                          # Código-fonte
    ├── model/                    # Classes do modelo de dados
    │   ├── Carro.java           # Classe para veículos
    │   ├── Cliente.java         # Classe base para clientes
    │   ├── Particular.java      # Cliente particular
    │   ├── Empresarial.java     # Cliente empresarial
    │   ├── Revendedor.java      # Cliente revendedor
    │   ├── Usuario.java         # Classe para usuários
    │   ├── Estado.java          # Estados do sistema
    │   ├── Normal.java          # Tipo normal
    │   └── Doutorado.java       # Tipo doutorado
    ├── util/                     # Classes utilitárias
    │   ├── Calculos.java        # Cálculos financeiros
    │   ├── CalculosInterface.java # Interface para cálculos
    │   ├── GerarPDF.java        # Geração de relatórios PDF
    │   ├── FicheiroTexto.java   # Manipulação de arquivos
    │   ├── Pesquisa.java        # Funcionalidades de pesquisa
    │   ├── Ordenacoes.java      # Algoritmos de ordenação
    │   ├── Alteracoes.java      # Operações de alteração
    │   ├── Remocoes.java        # Operações de remoção
    │   └── Tabelas.java         # Manipulação de tabelas
    └── view/                     # Interface gráfica (Swing)
        ├── TelaLogin.java       # Tela de login principal
        ├── TelaMenu.java        # Menu principal do sistema
        ├── TelaDadosCarro.java  # Cadastro/visualização de veículos
        ├── TelaNovoUsuario.java # Cadastro de usuários
        ├── TelaRegistrar.java   # Registro de clientes
        ├── TelaPesquisar.java   # Pesquisa avançada
        ├── TelaRecibo.java      # Geração de recibos
        ├── TelaAlterar.java     # Alteração de dados
        ├── TelaAbout.java       # Informações sobre o sistema
        ├── TelaManual.java      # Manual do usuário
        ├── TelaMusica.java      # Controle de áudio
        └── ...                  # Outras telas específicas
```

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Eclipse IDE (recomendado) ou outra IDE Java

### Passos para executar:

1. **Clone ou baixe o repositório**
   ```bash
   git clone https://github.com/HTAJnr/BeForward-Vehicle-Management-System.git
   ```

2. **Abra no Eclipse**
   - File → Import → Existing Projects into Workspace
   - Selecione a pasta
   - Clique em Finish

3. **Configure as dependências**
   - A biblioteca `itextpdf-5.5.13.jar` já está na pasta `lib/`
   - Adicione ao Build Path: clique direito no projeto → Properties → Java Build Path → Libraries → Add JARs → selecione `lib/itextpdf-5.5.13.jar`

4. **Execute o sistema**
   - Navegue até `src/view/TelaLogin.java`
   - Clique direito → Run As → Java Application
   - Ou execute o método main da classe TelaLogin
   - Ou execute o BeForwardMZ.jar

### Dados de Acesso
O sistema possui usuários pré-cadastrados em `resources/data/DadosUsuarios.txt`:
- **Dikshy Guinesh** / Senha: `Gui#2M`
- **Hélder Junior** / Senha: `He%6R`  
- **Saymara Chambal** / Senha: `Sa$3mC`

## 📊 Dados do Sistema

O sistema utiliza arquivos de texto para persistência:

- **DadosUsuarios.txt**: Usuários autorizados do sistema
- **DadosClientes.txt**: Informações dos clientes cadastrados
- **DadosCarros.txt**: Catálogo completo de veículos (75+ modelos)

### Marcas Disponíveis
Toyota, Honda, Nissan, Mazda, Mitsubishi, Hyundai, Kia, BMW, Mercedes, Audi, Range Rover, Peugeot, Ford, Chevrolet

## 🎨 Interface

O sistema apresenta:
- **Tema escuro profissional** com cores da marca BeForward
- **Interface intuitiva** com ícones personalizados
- **Efeitos visuais** e animações suaves
- **Layout responsivo** otimizado para desktop
- **Feedback visual** com mensagens e validações

## 📝 Funcionalidades Detalhadas

### Operações Principais
- ✅ **Autenticação segura** com validação de credenciais
- ✅ **CRUD completo** para veículos e clientes
- ✅ **Sistema de cálculos** automáticos baseados no tipo de cliente
- ✅ **Geração de relatórios** em PDF profissionais
- ✅ **Pesquisa avançada** com múltiplos filtros
- ✅ **Interface responsiva** com validações em tempo real

### Tipos de Cliente e Regras
Cada tipo de cliente possui regras específicas de cálculo e desconto, implementadas através de interfaces e herança.

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos como parte da disciplina de Programação Orientada a Objetos II no Instituto Superior de Ciências de Tecnologias de Moçambique.

## 🤝 Contribuições

Este é um projeto acadêmico finalizado. Para dúvidas ou sugestões, entre em contato com os desenvolvedores.

## 📞 Contato

**Projeto desenvolvido por estudantes do Instituto Superior de Ciências de Tecnologias de Moçambique**

- GitHub: [HTAJnr/BeForward-Vehicle-Management-System](https://github.com/HTAJnr/BeForward-Vehicle-Management-System)

---

**Desenvolvido com ❤️ pelos estudantes do Instituto Superior de Ciências de Tecnologias de Moçambique**
