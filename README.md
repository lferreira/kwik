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

<code>ruby -e "$(curl -fsSL https://raw.github.com/mxcl/homebrew/go)"</code>


Memcached
----------------------------------------------------------------------------

Porque ?
------

No momento era a solução mais rápida , mais simples de implementar e com melhor resultado,
é muito leve e roda em qualquer ambiente sem muita configuração. Mesmo assim desenvolvi de uma maneira
onde será muito simples trocar a implementação se for necessário


MAC
---

Instalando no Mac com Homebrew

<code>brew install memcached</code>

Iniciando o Memcached

<code>memcached -vv</code>

Windows
-------

Memcached 1.4.5 Windows (64-bit) - http://downloads.northscale.com/memcached-1.4.5-amd64.zip
Memcached 1.4.5 Windows (32-bit) - http://downloads.northscale.com/memcached-1.4.5-x86.zip

Instalando no windows

Basta descompactar em uma pasta de sua preferência

Iniciando o Memcached

Executar <MEMCACHED_HOME>/bin/memcached.exe

Linux
-----

<code>sudo apt-get install memcached</code>

Iniciando o Memcached

<code>sudo service memcached start</code>

