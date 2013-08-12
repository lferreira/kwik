kwik
====

Arquitetura/Solução
============================================================================

O Backend da aplicação foi inteiramente desenvolvido utilizando Java, pois é a linguagem que me sinto mais confortável
em utitilizar no momento. Como uma das premissas do desafio era não utilizar frameworks "component based" escolhi o VRaptor
que é um framework "action-based" , leve , poderoso de alta produtividade e o mais importante , a Testabilidade é muito boa.
Apesar de ter utilizado o VRaptor , procurei desacoplar as páginas do backend , ou seja todos as chamadas aos controllers são REST
com ajax/jquery e não estou utilizando nenhuma tag jsp , apenas html/css/js puro.

O aplicação conta também com uma camada de cache (Memcached) a partir da camada de serviços. Por padrão apenas as operações
de listar todos os produtos e categorias estão com cache com tempo 3 segundos (escolhi esse tempo aleatoriamente , mas a idéia 
é que tenha um lugar onde você possa cadastrar os tempos, cache de cache operações. Para essa aplicação os tempos e caches
estão fixos no código e por padrão a aplicação espera que o memcached esteja rodando em "localhost:11211".

O Front-end é bem simples, utilizei Jquery para realizar as chamadas aos serviços REST e montar o dinamismo das páginas.
Separei em alguns arquivos js , e também segui boas práticas como por exemplo , não criar funções anônimas. O código esta 
meio repetitivo porém esta bem simples de isolar os comportamentos comuns a todas as páginas e para dar uma "cara" melhorzinha utilizei o twitter-bootstrap.


Para os testes utilizei uma série de Test-Doubles e Helpers

- DBunit com Jstryker 
 
Apesar de utilizar o DB todos os testes da camada Dao são unitários e foram "driven development" pois estou utilizando um
banco de dados "In Memory" que é o HSQLDB o que torna esse tipo de teste rápido e executável sem depência nenhuma seguido os xUnit Test Patterns.

- Mockito
 
Para as suites que exigiram teste de comportamento, e ajudar nas "expectativas" dos testes. 

- Fixture Factory

Para organizar a criação dos objetos para o "System Under Test" , criei uma classe TemplateLoader onde estão as minhas fixtures

- Hamcrest

Para facilitar nas Assertivas e legibilidade dos testes

- Helpers

Criei uma classe chamada TestHelper essa qual todos os testes extendem , apesar das classes serem totalmente dependentes dela
foi por uma boa causa , pois os teste ficaram bem mais enxutos pois toda a responsabilidade de carregar, criar conexão, inicializar
os mocks , ou seja , toda a tarefa repetitiva e necessária para todos os testes estão nessa classe.


Para rodar todos os testes unitários basta executar:

<code> mvn test </code>

A Aplicação foi desenvolvida rodando no Jetty 7 porém testei no Jetty 8 e 9 e Tomcat 7 funcionando perfeitamente.


Ambiente
============================================================================

A maneira mais fácil de instalar pacotes no OS X é utilizando o Homebrew <br>
http://brew.sh/

- Instalando o Homebrew

<code>$ ruby -e "$(curl -fsSL https://raw.github.com/mxcl/homebrew/go)"</code>

Se não tem é legal ter o git instalado também

<code>$ brew install git</code>

<code>$ brew update</code>


Memcached
----------------------------------------------------------------------------

Por quê ?
------

No momento era a solução mais rápida , mais simples de implementar e com melhor resultado,
é muito leve e roda em qualquer ambiente sem muita configuração. Mesmo assim desenvolvi de uma maneira
onde será muito simples trocar a implementação se for necessário


* MAC

Instalando no Mac com Homebrew

<code>$ brew install memcached</code>

Iniciando o Memcached

<code>$ memcached -vv</code>

* Windows


Memcached 1.4.5 Windows (64-bit) - http://downloads.northscale.com/memcached-1.4.5-amd64.zip<br/>
Memcached 1.4.5 Windows (32-bit) - http://downloads.northscale.com/memcached-1.4.5-x86.zip

Instalando no windows

Basta descompactar em uma pasta de sua preferência

Iniciando o Memcached

Executar <MEMCACHED_HOME>/bin/memcached.exe

* Linux

<code>:~$ sudo apt-get install memcached</code>

Iniciando o Memcached

<code>:~$ sudo service memcached start</code>


MySQL
============================================================================

* Mac

Instalando no Mac com Homebrew

<code>$ brew install mysql </code>

Iniciando o MySql

<code>$ mysql.server start </code>


Se você tiver algum erro na subida do MySQL (como foi no meu caso) </br> 
Command + Shift + G) /usr/local/var/mysql e edite o arquivo com extensão .err (e.g. Your-Machine-Name.local.err) </br>


Para mim apareceu um erro : “ERROR! The server quit without updating PID file”. 
Isso é um erro de permissão no diretório /usr/local/var/mysql. 

<code>$ sudo chmod -R 755 /usr/local/var/mysql</code>

<code>$ rm -Rf /usr/local/var/mysql/Your-Machine-Name.local.err</code>

<code>$ mysql.server start </code>


Ativando Segurança do Mysql

<code>$ mysql_secure_installation</code>
 
Set root password? [Y/n] Y

Remove anonymous users? [Y/n] Y

Disallow root login remotely? [Y/n] Y

Remove test database and access to it? [Y/n] Y

Reload privilege tables now? [Y/n] Y


* Windows

http://dev.mysql.com/doc/refman/5.5/en/windows-installation.html

* Linux

http://dev.mysql.com/doc/refman/5.1/en/linux-installation.html


Jetty
============================================================================

* Mac

Download

http://jetty.codehaus.org/jetty/
http://www.eclipse.org/jetty/downloads.php

Iniciando

No diretório de instalação do Jetty:

<code>$ java -jar start.jar</code>



