kwik
====

Solução
============================================================================

Arquitetura
============================================================================

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




