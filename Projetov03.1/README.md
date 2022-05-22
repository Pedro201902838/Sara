# Programação Orientada por Objetos

**Eleições - Primeira fase**

**Ano Letivo: 2021/2022**

**Época Normal**

1. Introdução
2. Eleições
   1. Processo Eleitoral
   2. Votos
   3. Tipos de eleição
      1. Presidenciais
      2. Legislativas
      3. Europeias
      4. Eleições Autárquicas
3. Método de *Hondt*
4. Funcionalidades da aplicação
   1. Preparação de um caso de teste.

5. Fases de desenvolvimento e entrega
6. Implementação e codificação
7. Constituição de grupos
8. Entrega do projeto
9. Regras e Critérios de Avaliação do Projeto
   1. Regras de Avaliação
   2. Critérios de Avaliação

10. Resumo das Datas Importantes
    1. Entrega da 1ª fase
    2. Avaliações da 1ª fase



# 1. Introdução

O objetivo deste projeto passa pelo desenvolvimento, utilizando a linguagem Java e a Programação Orientada por Objetos (POO), de uma solução para gerir os resultados de processos eleitorais.

Existem vários tipos de eleições em Portugal, por exemplo: Presidenciais, Legislativas, Europeias e Autárquicas. Cada uma delas tem especificidades que a distingue. Contudo, excetuando as eleições presidenciais, em que o voto é efetuado numa pessoa especifica, todas as outras têm como base o cálculo de mandatos a atribuir a cada partido, tendo em conta o método de *Hondt*.

O projeto consiste na modelação e implementação de um conjunto de classes que permitam representar a lógica da aplicação e que permitam a sua utilização em modo **consola**.

Tenha particular atenção ao uso do paradigma de POO na modelação das classes, i.e., ao correto uso dos conceitos de encapsulamento, herança, classes abstratas, polimorfismo, interfaces, maximização da coesão (responsabilidade única), minimização do acoplamento, desenho orientado por responsabilidades, etc. Uma modelação bem pensada facilitará todo o processo de desenvolvimento e manutenção.

O presente documento versa apenas a primeira fase do projeto. Em data oportuna, após entrega da primeira fase, será apresentado o descritivo da segunda fase.



> **Nota**:  A interpretação do problema faz parte integrante da avaliação.  Qualquer dúvida em relação a este enunciado que não foi vista com o professor de laboratório deverá ser resolvida usando as boas práticas abordadas nas aulas.


# 2. Eleições

## 2.1 Processo Eleitoral

O processo eleitoral desenrola-se em mesas de votos que estão associadas a freguesias. As freguesias estão associadas a concelhos que por sua vez estão associados a distritos.

De acordo com os cadernos eleitorais cada votante tem associada uma mesa especifica e apenas pode exercer o voto nessa mesa, indicando para isso o seu número de eleitor ou cartão de cidadão. Naturalmente só pode votar uma vez.

São ainda admissíveis votos antecipados e votos efetuados por cidadãos portugueses que se encontrem no estrangeiro.

Nos casos dos votos antecipados, os votos são enviados fisicamente para as mesas de votos respetivas onde é registada a data do voto do cidadão e colocado na urna de voto o voto efetuado pelo eleitor.

Os votos são efetuados num boletim de voto fornecido pela mesa ao eleitor no momento da votação.

Todas as eleições se processam durante um determinado período horário. As urnas devem abrir às 8h e encerrar às 19h.

Cada tipo de eleição tem as suas particularidades. Serão apresentadas mais à frente.



## 2.2 Votos

Um voto pode ser considerado:

- **Válido** - quando é selecionada corretamente uma das opções disponíveis;
- **Branco** – quando não é selecionada nenhuma opção e o boletim de voto fica intacto;
- **Nulo** – quando é rasurado ou não é clara a opção de votação do eleitor.

**Nota: votos brancos e votos nulos não são considerados votos válidos.**


## 2.3 Tipos de eleição

### 2.3.1 Presidenciais

Nas eleições presidenciais vota-se para a eleição do presidente da república. É eleito Presidente da República o cidadão Português que se apresente a eleições, com mais de 35 anos e que obtenha pelo menos 50% dos votos.

Caso nenhum dos candidatos obtenha 50% dos votos (ou em caso de haver 2 candidatos empatados, cada um, com 50% dos votos), haverá um segundo sufrágio (segunda volta), ao qual concorrerão apenas os dois candidatos mais votados (que não tenham retirado a sua candidatura).



### 2.3.2 Legislativas

Nas eleições legislativas vota-se para a constituição do Parlamento português. Este é constituído por uma câmara de Deputados única designada Assembleia da República. É um dos dois órgãos de soberania eletivos previstos na Constituição, além do Presidente da República, cabendo-lhe o papel constitucional de &quot;assembleia representativa de todos os cidadãos portugueses&quot;.

A definição dos mandatos é atribuída de acordo com o método de _Hondt_ (ver capítulo correspondente) e estes são definidos ao nível dos distritos. Ou seja, no conjunto de 230 deputados eleitos cada distrito elege um número predeterminado de acordo com a sua densidade populacional.

É de salientar que não é mandatório que os partidos políticos se candidatem por todos os distritos.



### 2.3.3 Europeias

Nas eleições europeias vota-se para o parlamento europeu. Neste caso o número de mandatos a atribuir é ao nível nacional.



### 2.3.4 Eleições Autárquicas

O processo eleitoral autárquico consiste em 3 processos eleitorais em simultâneo:

- Câmara Municipal
- Assembleia Municipal
- Assembleias de Freguesia

Concorrem para cada um dos processos eleitorais partidos políticos, que poderão ser distintos em cada um dos processos, isto é, um partido pode concorrer apenas a uma ou mais assembleias de freguesia, apenas à Câmara Municipal ou à Assembleia Municipal.

O método de cálculo de mandatos é mais uma vez atribuído com o método de _Hondt_, sendo que:

- Para a Câmara Municipal são contabilizados a soma de todos os votos no concelho no processo de eleição da Câmara Municipal;
- Para a Assembleia Municipal são contabilizados a soma de todos os votos no concelho no processo de eleição da Assembleia Municipal;
- Para cada uma das Assembleias de Freguesia são contabilizados os votos na freguesia respetiva.


# 3. Método de _Hondt_
O método _Hondt_ é um modelo matemático utilizado para converter votos em mandatos com vista à composição de órgãos de natureza colegial.

Os dois tipos de sistemas eleitorais são o sistema Maioritário e o sistema de Representação Proporcional (RP).

O sistema de RP caracteriza-se, essencialmente e de modo simples, pelo facto de o número de eleitos por cada candidatura concorrente a uma determinada eleição ser proporcional ao número de eleitores que escolheram votar nessa mesma candidatura.

O método de _Hondt_, integra a categoria dos métodos de divisores - por contraposição à categoria dos métodos de maiores restos - pois a operação matemática consiste precisamente na divisão do número total de votos obtidos por cada candidatura por divisores previamente fixados, no caso 1, 2, 3, 4, 5, e assim sucessivamente.

O método aplica-se mediante a divisão sucessiva do número total de votos obtidos por cada candidatura pelos divisores (1, 2, 3, 4, 5 etc.) e pela atribuição dos mandatos em disputa por ordem decrescente aos quocientes mais altos que resultarem das divisões operadas. O processo de divisão prossegue até se esgotarem todos os mandatos e todas as possibilidades de aparecerem quocientes iguais aos quais ainda caiba um mandato.

Em Portugal encontra-se legalmente prevista uma correção ao método _Hondt_ puro, na medida em que, caso falte atribuir o último mandato e se verifique igualdade do quociente em duas listas diferentes, tal mandato será atribuído à lista que em termos de resultados totais tenha obtido menor número de votos.

**Exemplo prático (conversão dos votos em mandatos):**

O círculo eleitoral &quot;X&quot; tem direito a eleger 7 deputados e concorrem 4 partidos: A, B, C e D. Apurados os votos, a distribuição foi a seguinte: A - 12.000 votos; B - 7.500 votos; C - 4.500 votos; e D - 3.000 votos. Da aplicação do método de _Hondt_ resulta a seguinte série de quocientes:

| Divisor | Partido A | Partido B | Partido C | Partido D |
| :-----: | :-------: | :-------: | :-------: | :-------: |
|    1    |   12000   |   7500    |   4500    |   3000    |
|    2    |   6000    |   3750    |   2250    |   1500    |
|    3    |   4000    |   2500    |   1500    |   1000    |
|    4    |   3000    |   1875    |   1125    |    750    |

No exemplo constante da tabela, os quocientes correspondentes a mandatos, assinalados a cinzento, levam à seguinte distribuição:

Partido A - 3 deputados, correspondentes aos quocientes 12000 (1.º eleito), 6000 (3.º eleito) e 4000 (5.º eleito). Note-se que apesar do quociente resultante da divisão por 4 ser 3000, igual aos votos obtidos pelo partido D, o mandato é atribuído ao menos votado, isto é, ao Partido D, que assim elege o seu deputado.

Partido B - 2 deputados, correspondentes aos quocientes 7500 (2.º eleito) e 3750 (6.º eleito).

Partido C - 1 deputado, correspondente ao quociente 4500 (4.º eleito).

Partido D - 1 deputado, correspondente ao quociente 3000 (7.º e último eleito), beneficiando da regra que em igualdade atribui o lugar à lista menos votada, arrebatando o lugar ao partido A.

**Tem-se em consideração que para o método de *Hondt* apenas são considerados os votos válidos.**


# 4. Funcionalidades da aplicação

Como é referido no enunciado existem vários tipos de eleições que possuem configurações e comportamentos distintos. Assim, a aplicação a desenvolver deverá permitir:

  1. A criação de um processo eleitoral, para cada tipo de eleição, com as respetivas configurações (Período eleitoral, Candidatos, Distritos, Concelhos, Freguesias, Mesas…)

  2. Configuração dos boletins de voto por processo eleitoral

  3. Indicação do número de votantes por mesa

  4. Apresentação dos resultados eleitorais
        1. Número de freguesias apuradas versus o total de freguesias existentes
        2. Taxa de abstenção
        3. Número de votos: válidos, brancos e nulos com a respetiva percentagem
        4. Número de mandatos atribuídos, número total de votos e % de votos

  5. Em qualquer fase de carregamento dos votos deve ser possível guardar e ler o progresso de carregamento da informação

        

## 4.1 Preparação de um caso de teste.

De modo a testar as funcionalidades da aplicação prepare 1 um caso de teste para o concelho de Setúbal.

- Configure uma eleição autárquica de acordo com os seguintes dados:

| Local                                                      | Mandatos | Partidos a sufrágio                                          |
| ---------------------------------------------------------- | -------- | ------------------------------------------------------------ |
| Assembleia Municipal                                       | 27       | Partido A; Partido C; Partido E; Partido F; Partido G        |
| Câmara Municipal                                           | 11       | Partido A; Partido B; Partido C; Partido D; Partido E; Partido F; Partido G |
| Assembleia de Freguesia de São Sebastião                   | 21       | Partido A; Partido C; Partido E; Partido F; Partido G        |
| Assembleia de Freguesia de União de Freguesias de Setúbal  | 25       | Partido A; Partido C; Partido E; Partido F; Partido G        |
| Assembleia de Freguesia do Sado                            | 9        | Partido A; Partido C; Partido E; Partido F; Partido G        |
| Assembleia de Freguesia de Gâmbia, Pontes e Alto da Guerra | 9        | Partido A; Partido C; Partido E; Partido F; Partido G        |
| Assembleia de Freguesia de União de Freguesias de Azeitão  | 19       | Partido A; Partido C; Partido E; Partido F; Partido G        |
- Utilize o ficheiro &quot;mesas.csv&quot; para importar para a aplicação a informação de mesas disponíveis por freguesia e respeito número de eleitores. Esta informação só deve poder ser carregada depois de criada estrutura para o concelho de Setúbal, nomeadamente o distrito e o concelho. As freguesias deverão ser criadas no processo de carga das mesas.
- Para o cálculo do número de votos deverão ser utilizados os ficheiros, &quot;VotosAssembleia.csv&quot;, &quot;VotosCamara.csv&quot; e &quot;VotosFreguesia.csv&quot;.



# 5. Fases de desenvolvimento e entrega

O projeto está dividido em 2 fases, com a cotação distribuída da seguinte forma:

- Fase I – 70% da avaliação final
- Fase II – 30% da avaliação final

Conforme referido na ficha da disciplina, poderá alternativamente entregar o projeto numa só data, na época de recurso (sem possibilidade de incorporar componente de avaliação contínua), contemplando as duas fases do projeto.


# 6. Implementação e codificação

O programa deve ser desenvolvido utilizando a linguagem Java, colocando em prática os conceitos fundamentais do paradigma de Programação Orientada por Objetos.

Em relação às regras de codificação, siga as convenções adotadas normalmente para a linguagem Java:

- A notação _camelCase_ para o nome das variáveis locais e identificadores de atributos e métodos;
- A notação _PascalCase_ para os nomes das classes e interfaces;
- Utilização de maiúsculas para os nomes das constantes e dos valores enumerados;
- Não utilize o símbolo &#39;\_&#39; nos identificadores (exceto nas constantes), nem abreviaturas.

É necessário que o projeto cumpra o que é pedido no seu enunciado, sendo deixado ao critério do programador qualquer pormenor de implementação que não seja referido, o qual deverá ser devidamente documentado.

Deverá obrigatoriamente implementar: Coleções, Herança, Polimorfismo, Interfaces, Exceções e Entrada e Saida.


# 7. Constituição de grupos

Cada projeto deverá ser elaborado em grupos de dois alunos, podendo eventualmente ser elaborado individualmente. Não serão permitidos, em nenhum caso, grupos com mais do que dois alunos.

Os grupos dos alunos já se encontram determinados através da metodologia de _pair programming_ que está a ser utilizada nos laboratórios. Caso existam alunos que não têm o grupo escolhido, deverão contactar o respetivo docente de laboratório para regularizar a situação.


# 8. Entrega do projeto

O projeto será entregue em duas fases:

- Uma primeira fase ( **até às 23:55:00 do dia 29 de maio de 2022** ) com a implementação da lógica da aplicação (descrita no presente documento);
- A segunda fase ( **até às 23:55:00 do dia 24 de junho de 2022** ) com a parte gráfica (descrita em documento entregue futuramente).

O projeto deverá ser entregue até à data limite especificada **por via exclusivamente eletrónica utilizando os grupos criados no Github**.

**Não serão aceites quaisquer projetos entregues fora do prazo!**

Todos os materiais do projeto devem ser devidamente identificados com nome, número e endereço de correio eletrónico dos alunos.

Os materiais do projeto deverão incluir:

- Um **Manual Técnico** onde conste uma breve descrição do programa, incluindo a explicação das classes/interfaces implementadas, principais atributos e métodos e suas relações.
- A documentação do programa em **JavaDoc** (não converta o documento gerado automaticamente em HTML para DOC!).
- O código fonte do programa na forma de projeto em _NetBeans_ ou _IntelliJ_, com um _main_ de testes a funcionar e com todas as funcionalidades implementadas.
- Todos os ficheiros que compõem o projeto deverão estar guardados num único ficheiro compactado em formato ZIP cujo nome deverá ter a seguinte nomenclatura: <curso>_<numAluno1>_<numAluno2>.zip.



# 9. Regras e Critérios de Avaliação do Projeto

## 9.1 Regras de Avaliação

A avaliação do projeto está sujeita às seguintes regras:

- Caso o aluno falte ao momento de supervisão, terá essa componente avaliada com zero valores.
- **Não serão aceites quaisquer projetos entregues fora do prazo!**
- A classificação do programa terá em conta a qualidade da programação (fatores de qualidade do software), a estrutura do código criado segundo os princípios da Programação Orientada por Objetos, tendo em conta conceitos como a coesão de classes e métodos, o grau de acoplamento entre classes e o desenho de classes orientado pela responsabilidade, e a utilização/conhecimento da linguagem Java.
- Serão premiadas a facilidade de utilização, a apresentação, a imaginação e a criatividade.
- O projeto terá uma componente de avaliação oral obrigatória com classificação individual dos elementos do grupo.
- Os alunos que não comparecerem à discussão serão classificados com zero na fase respetiva. Nesta discussão será apurada a capacidade do aluno de produzir o código apresentado. Nos casos em que essa capacidade não for demonstrada, a nota atribuída será zero.
- A avaliação oral é realizada pelo respetivo professor de laboratório e irá ser feita uma marcação prévia para cada grupo de trabalho.
- Todos os projetos serão submetidos a um sistema automático de deteção de cópias. Os projetos que forem identificados como possíveis cópias, e verificando-se serem realmente cópias, serão anulados.
- As avaliações da primeira fase do projeto serão realizadas na segunda semana de junho de 2022.

  
## 9.2 Critérios de Avaliação

A primeira fase do projeto será avaliada segundo os seguintes critérios:

| **Funcionalidades** | **45%** |
| ------------------- | ------- |

| **Implementação**                           | **35%** |
| ------------------------------------------- | ------- |
| Estrutura de classes                        | 20%     |
| Conhecimento e boa utilização da linguagem  | 5%      |
| Bom estilo (nomes, comentários, indentação) | 5%      |
| Definição de testes unitários               | 5%      |

| **Documentação** | **10%** |
| ---------------- | ------- |
| JavaDOC          | 5%      |
| Manual técnico   | 5%      |

| **Avaliação qualitativa** | **10%** |
| ------------------------- | ------- |


# 10. Resumo das Datas Importantes

##   10.1 Entrega da 1ª fase

A entrega da 1ª fase do projeto será até **às 23:55:00 de domingo, dia 29 de maio de 2022.**


## 10.2 Avaliações da 1ª fase

As avaliações da primeira fase do projeto serão realizadas na semana de **30 de maio a 03 de junho de 2022**.

