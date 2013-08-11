kwik
====

Arquitetura/Solução
============================================================================

O Backend da aplicação foi inteiramente desenvolvido utilizando Java, pois é a linguagem que me sinto mais confortável
em utitilizar no momento. Como uma das premissas do desafio era não utilizar frameworks "component based" escolhi o VRaptor
que é um framework "action-based" , leve , poderoso de alta produtividade e o mais importante , a Testabilidade é muito boa.
Apesar de ter utilizado o VRaptor , procurei desacoplar as páginas do backend , ou seja todos as chamadas aos controllers são REST
com ajax/jquery e não estou utilizando nenhuma tag jsp , apenas html/css/js puro.

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




