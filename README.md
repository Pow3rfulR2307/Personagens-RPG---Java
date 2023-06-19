# Personagens-RPG em Java
A ideia principal do projeto é servir como um programa de leitura de um arquivo CSV que contém dados de 100 personagens fictícios baseado em um jogo de RPG. Esses dados incluem nome(string), espécie(string), classe(string), level(int) e pontos de dano(float) para cada personagem. A interface gráfica do programa permite editar e manipular os dados do arquivo CSV de modo que seja possível dividir e listar os personagens em grupos baseados na sua espécie, editar seus nomes, classes e pontos de dano, bem como gerar um arquivo TXT com as edições feitas pelo usuário e com melhor formatação dos dados. A ideia gira em torno de permitir controle sobre dados pré-registrados em tabelas.
O programa possui uma classe de Exception a qual os métodos de leitura ou escrita de arquivos implementam quando se encontra um erro na abertura do arquivo especificado. Há uma classe generalizadora para as entradas do arquivo CSV denominada “Personagem” que é responsável por definir atributos gerais que as classes Humano, Elfo e Troll herdam. A interface do programa permite a opção de deletar um personagem, todas as classes de espécies a implementam, cada uma realiza a operação de remover para uma lista diferente baseada na espécie que está sendo modificada. 
A interface gráfica do programa é feita baseada em Java Swing, o menu principal possui 10 operações diferentes, sendo elas: listar humanos, listar elfos, listar trolls, editar a classe de um humano, editar o nome de um elfo, editar os pontos de dano de um troll, apagar um personagem, criar um personagem e escrever os dados corretamente formatados e editados em um arquivo TXT. Para identificar qual personagem deve ser editado, é geralmente necessário informar seu nome e level já que pode haver ocorrências de personagens diferentes com o mesmo nome.
Para a serialização, é gerado um arquivo específico só para a persistência de todos os personagens do CSV, sem modificação alguma do usuário. O método é implementado na classe de Personagem. Também é possível listar todos os personagens serializados como sendo a última operação do programa, os dados serializados são lidos de um TXT contendo os dados dos objetos em binário.
