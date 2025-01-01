Projeto: Simulação de Trens com Gerenciamento de Zonas Críticas

Descrição Geral

Este projeto é uma simulação de dois trens que compartilham trilhos com zonas críticas onde há risco de colisão. O objetivo é garantir que esses trens não entrem simultaneamente nas zonas críticas, utilizando técnicas de sincronização de processos e controle de concorrência. O projeto foi desenvolvido para a disciplina de Programação Concorrente, orientada pelo professor Marlos Marques.

Funcionalidades

Zonas Críticas: Simulação de áreas compartilhadas por dois trens, onde há risco de colisão.

Técnicas de Controle de Concorrência:

Variável de Travamento: Controle básico para gerenciar a entrada nas zonas críticas.

Estrita Alternância: Implementação de turnos para acesso alternado às zonas críticas.

Solução de Peterson: Algoritmo clássico para sincronização de dois processos concorrentes.

Objetivos do Projeto

Evitar colisões entre os trens nas zonas críticas.

Demonstrar o funcionamento de diferentes soluções para o problema da exclusão mútua.

Aplicar conceitos de programação concorrente em um cenário prático.

Tecnologias Utilizadas

Linguagem de programação: Java

Ferramentas de desenvolvimento: VScode

Conceitos teóricos: Exclusão mútua, seções críticas, sincronização de threads

Estrutura do Projeto

Variável de Travamento: Implementação inicial para bloquear e desbloquear as zonas críticas manualmente.

Estrita Alternância: Algoritmo que alterna o acesso entre os trens, garantindo a exclusão mútua.

Solução de Peterson: Versão otimizada e mais eficiente para evitar deadlocks e garantir a entrada ordenada nas zonas críticas.

Como Executar

Clone este repositório:

git clone https://github.com/francoborba/Projeto-trens

Abra o projeto em sua IDE de preferência.

Compile e execute o código principal para iniciar a simulação.

Exemplos de Saída

A interface textual ou gráfica mostra os trens aguardando ou atravessando as zonas críticas.

Logs indicam qual algoritmo de controle de concorrência está em uso e o comportamento dos trens em relação às zonas críticas.

Aprendizados

Implementação de soluções clássicas para problemas de concorrência.

Análise comparativa de desempenho entre as soluções (eficiência e simplicidade).

Desenvolvimento de aplicações concorrentes em Java.

Autor

Franco Ribeiro Borba

Curso: Ciência da Computação, 4º semestre

Instituição: UESB (Universidade Estadual do Sudoeste da Bahia)

Professor Orientador: Marlos Marques

Licença

Este projeto é licenciado sob a Licença MIT. Consulte o arquivo LICENSE para mais informações.

Contato

LinkedIn

Email: franco.borba14@gmail.com

